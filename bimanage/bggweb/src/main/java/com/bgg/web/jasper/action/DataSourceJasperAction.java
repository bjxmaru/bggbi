package com.bgg.web.jasper.action;

import com.bggbi.basedoc.pojo.JasperQueryVO;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import net.sf.jasperreports.engine.JREmptyDataSource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller("DataSourceJasperAction")
@Scope("prototype")
public class DataSourceJasperAction  extends ActionSupport {



    public String jasperDataSource() {

        JasperQueryVO jasperQueryVO = (JasperQueryVO) ActionContext.getContext().getValueStack().findValue(JasperQueryVO.class.getSimpleName());

        jasperQueryVO.setJrResultdataSource(new JREmptyDataSource());
        jasperQueryVO.setJrResultformat("text/html");
        jasperQueryVO.setJrResultLocation(jasperQueryVO.getJasperCompiledFilePath());


        return "jasperDataSource";
    }
}
