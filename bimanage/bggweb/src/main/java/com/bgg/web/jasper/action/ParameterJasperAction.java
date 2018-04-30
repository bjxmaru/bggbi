package com.bgg.web.jasper.action;

import com.bggbi.basedoc.pojo.JasperQueryVO;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;
import com.sun.tools.classfile.StackMapTable_attribute;
import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;
import net.sf.jasperreports.engine.*;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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


    @Autowired
    @Qualifier("JasperQueryVO")
    JasperQueryVO  jasperQueryVO ;


    public JasperQueryVO getJasperQueryVO() {
        return jasperQueryVO;
    }

    public void setJasperQueryVO(JasperQueryVO jasperQueryVO) {
        this.jasperQueryVO = jasperQueryVO;
    }




    public String jasperCompile() throws IOException, JRException {


        jasperQueryVO.setJasperUncompiledFilePath( ServletActionContext.getServletContext().getRealPath(jasperQueryVO.getJasperUncompiledFilePath()) );


        jasperQueryVO.setJasperCompiledFilePath( ServletActionContext.getServletContext().getRealPath(jasperQueryVO.getJasperCompiledFilePath()) );

        File tempFile = new File(jasperQueryVO.getJasperCompiledFilePath());


        if(!tempFile.getParentFile().exists() ) {
            tempFile.getParentFile().mkdirs();
        }


        if (! tempFile.exists()) {

            tempFile.createNewFile() ;
        }


      /*  JasperReportsContext jasperReportsContext = new SimpleJasperReportsContext();
        JasperCompileManager.getInstance(jasperReportsContext).compileToFile(jasperQueryVO.getJasperUncompiledFilePath(), jasperQueryVO.getJasperCompiledFilePath());
        */
        JasperCompileManager.compileReportToFile(jasperQueryVO.getJasperUncompiledFilePath(), jasperQueryVO.getJasperCompiledFilePath());

        ActionContext.getContext().getValueStack().push(jasperQueryVO);

        return  "jasperCompile" ;
    }



    public String index() {
        return SUCCESS ;
    }





}
