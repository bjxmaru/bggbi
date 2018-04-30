package com.bggbi.basedoc.pojo;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JREmptyDataSource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Repository("JasperQueryVO")
@Scope("prototype")
public class JasperQueryVO {
    private String dataSource;
    private String format;
    private String documentName;
    private String contentDisposition;
    private String delimiter;
    private String imageServletUrl = "/images/";
    private String timeZone;
    private boolean wrapField = true;

    private boolean compileJasper = true ;

    public Map<String, Object> getJasperreportsParameter() {
        return jasperreportsParameter;
    }

    public void setJasperreportsParameter(Map<String, Object> jasperreportsParameter) {
        this.jasperreportsParameter = jasperreportsParameter;
    }

    public Map<String, Object> getQueryRptParameter() {
        return queryRptParameter;
    }

    public void setQueryRptParameter(Map<String, Object> queryRptParameter) {
        this.queryRptParameter = queryRptParameter;
    }

    private Map<String, Object> jasperreportsParameter = new HashMap<>();

    private Map<String, Object> queryRptParameter = new HashMap<>();


    private String jrResultLocation ;

    public String getJrResultLocation() {
        return jrResultLocation;
    }

    public void setJrResultLocation(String jrResultLocation) {
        this.jrResultLocation = jrResultLocation;
    }

    public JRDataSource getJrResultdataSource() {
        return jrResultdataSource;
    }

    public void setJrResultdataSource(JRDataSource jrResultdataSource) {
        this.jrResultdataSource = jrResultdataSource;
    }

    public String getJrResultformat() {
        return jrResultformat;
    }

    public void setJrResultformat(String jrResultformat) {
        this.jrResultformat = jrResultformat;
    }

    private JRDataSource jrResultdataSource = new JREmptyDataSource( ) ;
    private String jrResultformat = "text/html";

    public Date getqDate() {
        return qDate;
    }

    public void setqDate(Date qDate) {
        this.qDate = qDate;
    }

    public String getqDateStr() {
        return qDateStr;
    }

    public void setqDateStr(String qDateStr) {
        this.qDateStr = qDateStr;
    }


    private Date qDate;
    private String qDateStr;

    public String getqOrgCode() {
        return qOrgCode;
    }

    public void setqOrgCode(String qOrgCode) {
        this.qOrgCode = qOrgCode;
    }

    private String qOrgCode;


    private String jasperUncompiledFilePath = "";
    private String jasperCompiledFilePath = "";

    private String funcCode = "";

    public String getDataSource() {
        return dataSource;
    }

    public void setDataSource(String dataSource) {
        this.dataSource = dataSource;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getDocumentName() {
        return documentName;
    }

    public void setDocumentName(String documentName) {
        this.documentName = documentName;
    }

    public String getContentDisposition() {
        return contentDisposition;
    }

    public void setContentDisposition(String contentDisposition) {
        this.contentDisposition = contentDisposition;
    }

    public String getDelimiter() {
        return delimiter;
    }

    public void setDelimiter(String delimiter) {
        this.delimiter = delimiter;
    }

    public String getImageServletUrl() {
        return imageServletUrl;
    }

    public void setImageServletUrl(String imageServletUrl) {
        this.imageServletUrl = imageServletUrl;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    public boolean isWrapField() {
        return wrapField;
    }

    public void setWrapField(boolean wrapField) {
        this.wrapField = wrapField;
    }

    public String getJasperUncompiledFilePath() {
        return jasperUncompiledFilePath;
    }

    public void setJasperUncompiledFilePath(String jasperUncompiledFilePath) {
        this.jasperUncompiledFilePath = jasperUncompiledFilePath;
    }

    public String getJasperCompiledFilePath() {
        return jasperCompiledFilePath;
    }

    public void setJasperCompiledFilePath(String jasperCompiledFilePath) {
        this.jasperCompiledFilePath = jasperCompiledFilePath;
    }

    public boolean isCompileJasper() {
        return compileJasper;
    }

    public void setCompileJasper(boolean compileJasper) {
        this.compileJasper = compileJasper;
    }

    public String getFuncCode() {
        return funcCode;
    }

    public void setFuncCode(String funcCode) {
        this.funcCode = funcCode;
    }
}
