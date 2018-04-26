package com.bggbi.basedoc.pojo;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

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

    private HashMap<String, String> queryParameter =new HashMap<>();

    private String jasperUncompiledFilePath = "" ;
    private String jasperCompiledFilePath = "" ;
    private boolean compileJasper  =true;
    private String funcCode ="" ;

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

    public HashMap<String, String> getQueryParameter() {
        return queryParameter;
    }

    public void setQueryParameter(HashMap<String, String> queryParameter) {
        this.queryParameter = queryParameter;
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
