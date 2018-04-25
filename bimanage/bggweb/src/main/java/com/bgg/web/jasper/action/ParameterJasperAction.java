package com.bgg.web.jasper.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;
import com.sun.tools.classfile.StackMapTable_attribute;
import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;
import net.sf.jasperreports.engine.*;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;

@Controller("ParameterJasperAction")
@Scope("prototype")
public class ParameterJasperAction extends ActionSupport{
    String jasperUncompiledFilePath = "" ;
    String jasperCompiledFilePath = "" ;
    boolean compileJasper  =true;
    String funcCode ="" ;
    static String RTN_COMPILE_JASPER = "compileJasper";


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


    public String compile() throws IOException, JRException {

        jasperUncompiledFilePath =  ServletActionContext.getServletContext().getRealPath(jasperUncompiledFilePath);
        jasperCompiledFilePath   =  ServletActionContext.getServletContext().getRealPath(jasperCompiledFilePath);

        File fileDest = new File(jasperCompiledFilePath);

        if(!fileDest.getParentFile().exists() ) {
            fileDest.getParentFile().mkdirs();
        }

        if (! fileDest.exists()) {

            fileDest.createNewFile() ;
        }

        JasperReportsContext jasperReportsContext = new SimpleJasperReportsContext();
        JasperCompileManager.getInstance(jasperReportsContext).compileToFile(jasperUncompiledFilePath, jasperCompiledFilePath);

        return  SUCCESS ;
    }



    public String index() {
        return SUCCESS ;
    }





}
