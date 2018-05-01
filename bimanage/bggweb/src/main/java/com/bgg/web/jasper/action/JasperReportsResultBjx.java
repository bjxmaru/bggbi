package com.bgg.web.jasper.action;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.util.ValueStack;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.export.*;
import net.sf.jasperreports.engine.util.JRLoader;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.result.StrutsResultSupport;
import org.apache.struts2.views.jasperreports.JasperReportConstants;
import org.apache.struts2.views.jasperreports.JasperReportsResult;
import org.apache.struts2.views.jasperreports.ValueStackDataSource;
import org.apache.struts2.views.jasperreports.ValueStackShadowMap;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;

public class JasperReportsResultBjx  extends  JasperReportsResult {



    private static final Logger LOG = LogManager.getLogger(JasperReportsResultBjx.class) ;



    @Override
    protected void doExecute(String finalLocation, ActionInvocation invocation) throws Exception {
        // Will throw a runtime exception if no "datasource" property. TODO Best place for that is...?
        initializeProperties(invocation);

        LOG.debug("Creating JasperReport for dataSource = {}, format = {}", dataSource, format);

        HttpServletRequest request = (HttpServletRequest) invocation.getInvocationContext().get(ServletActionContext.HTTP_REQUEST);
        HttpServletResponse response = (HttpServletResponse) invocation.getInvocationContext().get(ServletActionContext.HTTP_RESPONSE);

        // Handle IE special case: it sends a "contype" request first.
        // TODO Set content type to config settings?
        if ("contype".equals(request.getHeader("User-Agent"))) {
            try (OutputStream outputStream = response.getOutputStream()) {
                response.setContentType("application/pdf");
                response.setContentLength(0);
            } catch (IOException e) {
                LOG.error("Error writing report output", e);
                throw new ServletException(e.getMessage(), e);
            }
            return;
        }

        // Construct the data source for the report.
        ValueStack stack = invocation.getStack();
        ValueStackDataSource stackDataSource = null;

        Connection conn = (Connection) stack.findValue(connection);
        if (conn == null)
            stackDataSource = new ValueStackDataSource(stack, dataSource, wrapField);

        if ("https".equalsIgnoreCase(request.getScheme())) {
            // set the the HTTP Header to work around IE SSL weirdness
            response.setHeader("CACHE-CONTROL", "PRIVATE");
            response.setHeader("Cache-Control", "maxage=3600");
            response.setHeader("Pragma", "public");
            response.setHeader("Accept-Ranges", "none");
        }

        // Determine the directory that the report file is in and set the reportDirectory parameter
        // For WW 2.1.7:
        //  ServletContext servletContext = ((ServletConfig) invocation.getInvocationContext().get(ServletActionContext.SERVLET_CONFIG)).getServletContext();
        ServletContext servletContext = (ServletContext) invocation.getInvocationContext().get(ServletActionContext.SERVLET_CONTEXT);
        String systemId = servletContext.getRealPath(finalLocation);
        Map parameters = new ValueStackShadowMap(stack);
        File directory = new File(systemId.substring(0, systemId.lastIndexOf(File.separator)));
        parameters.put("reportDirectory", directory);
        parameters.put(JRParameter.REPORT_LOCALE, invocation.getInvocationContext().getLocale());

        // put timezone in jasper report parameter
        if (timeZone != null) {
            timeZone = conditionalParse(timeZone, invocation);
            final TimeZone tz = TimeZone.getTimeZone(timeZone);
            if (tz != null) {
                // put the report time zone
                parameters.put(JRParameter.REPORT_TIME_ZONE, tz);
            }
        }

        // Add any report parameters from action to param map.
        Map reportParams = (Map) stack.findValue(reportParameters);
        if (reportParams != null) {
            LOG.debug("Found report parameters; adding to parameters...");
            parameters.putAll(reportParams);
        }

        ByteArrayOutputStream output;
        JasperPrint jasperPrint;

        // Fill the report and produce a print object
        try {
            JasperReport jasperReport = (JasperReport) JRLoader.loadObject(new File(systemId));
            if (conn == null) {
                jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, stackDataSource);
            }
            else {
                jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, conn);
            }
        } catch (JRException e) {
            LOG.error("Error building report for uri {}", systemId, e);
            throw new ServletException(e.getMessage(), e);
        }

        // Export the print object to the desired output format
        try {
            if (contentDisposition != null || documentName != null) {
                final StringBuffer tmp = new StringBuffer();
                tmp.append((contentDisposition == null) ? "inline" : contentDisposition);

                if (documentName != null) {
                    tmp.append("; filename=");
                    tmp.append(documentName);
                    tmp.append(".");
                    tmp.append(format.toLowerCase());
                }

                response.setHeader("Content-disposition", tmp.toString());
            }

            JRExporter exporter;

            if (format.equals(FORMAT_PDF)) {
                response.setContentType("application/pdf");
                exporter = new JRPdfExporter();
            } else if (format.equals(FORMAT_CSV)) {
                response.setContentType("text/csv");
                exporter = new JRCsvExporter();
            } else if (format.equals(FORMAT_HTML)) {
                response.setContentType("text/html");

                // IMAGES_MAPS seems to be only supported as "backward compatible" from JasperReports 1.1.0
//
//                Map imagesMap = new HashMap();
//                request.getSession(true).setAttribute("IMAGES_MAP", imagesMap);

//                 exporter = new JRHtmlExporter();
                exporter = new HtmlExporter();
//                exporter.setParameter(JRHtmlExporterParameter.IMAGES_MAP, imagesMap);
//                exporter.setParameter(JRHtmlExporterParameter.IMAGES_URI, request.getContextPath() + imageServletUrl);

//                // Needed to support chart images:
//                  exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
//                request.getSession().setAttribute("net.sf.jasperreports.j2ee.jasper_print", jasperPrint);
            } else if (format.equals(FORMAT_XLS)) {
                response.setContentType("application/vnd.ms-excel");
                exporter = new JRXlsExporter();
            } else if (format.equals(FORMAT_XML)) {
                response.setContentType("text/xml");
                exporter = new JRXmlExporter();
            } else if (format.equals(FORMAT_RTF)) {
                response.setContentType("application/rtf");
                exporter = new JRRtfExporter();
            } else {
                throw new ServletException("Unknown report format: " + format);
            }

            Map exportParams = (Map) stack.findValue(exportParameters);
            if (exportParams != null) {
                LOG.debug("Found export parameters; adding to exporter parameters...");
                exporter.getParameters().putAll(exportParams);
            }

            output = exportReportToBytes(jasperPrint, exporter);
        } catch (JRException e) {
            LOG.error("Error producing {} report for uri {}", format, systemId, e);
            throw new ServletException(e.getMessage(), e);
        } finally {
            try {
                if (conn != null) {
                    // avoid NPE if connection was not used for the report
                    conn.close();
                }
            } catch (Exception e) {
                LOG.warn("Could not close db connection properly", e);
            }
        }

        response.setContentLength(output.size());
        // Will throw ServletException on IOException.
        writeReport(response, output);
    }


    /**
     * Writes report bytes to response output stream.
     *
     * @param response Current response.
     * @param output   Report bytes to write.
     * @throws ServletException on stream IOException.
     */
    private void writeReport(HttpServletResponse response, ByteArrayOutputStream output) throws ServletException {
        try (OutputStream outputStream = response.getOutputStream()) {
            output.writeTo(outputStream);
            outputStream.flush();
        } catch (IOException e) {
            LOG.error("Error writing report output", e);
            throw new ServletException(e.getMessage(), e);
        }
    }



    /**
     * Sets up result properties, parsing etc.
     *
     * @param invocation Current invocation.
     * @throws Exception on initialization error.
     */
    private void initializeProperties(ActionInvocation invocation) throws Exception {
        if (dataSource == null && connection == null) {
            String message = "No dataSource specified...";
            LOG.error(message);
            throw new RuntimeException(message);
        }
        if (dataSource != null)
            dataSource = conditionalParse(dataSource, invocation);

        format = conditionalParse(format, invocation);
        if (StringUtils.isEmpty(format)) {
            format = FORMAT_PDF;
        }

        if (contentDisposition != null) {
            contentDisposition = conditionalParse(contentDisposition, invocation);
        }

        if (documentName != null) {
            documentName = conditionalParse(documentName, invocation);
        }

        reportParameters = conditionalParse(reportParameters, invocation);
        exportParameters = conditionalParse(exportParameters, invocation);
    }

    /**
     * Run a Jasper report to CSV format and put the results in a byte array
     *
     * @param jasperPrint The Print object to render as CSV
     * @param exporter    The exporter to use to export the report
     * @return A CSV formatted report
     * @throws net.sf.jasperreports.engine.JRException
     *          If there is a problem running the report
     */
    private ByteArrayOutputStream exportReportToBytes(JasperPrint jasperPrint, JRExporter exporter) throws JRException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
        exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, baos);
        if (delimiter != null) {
            exporter.setParameter(JRCsvExporterParameter.FIELD_DELIMITER, delimiter);
        }

        exporter.exportReport();
        return baos;
    }

}
