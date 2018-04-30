package com.bgg.web.jasper.action;

import com.bggbi.basedoc.pojo.CustomBean;
import com.bggbi.basedoc.pojo.JasperQueryVO;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import net.sf.jasperreports.engine.JREmptyDataSource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller("DataSourceJasperAction")
@Scope("prototype")
public class DataSourceJasperAction  extends ActionSupport {


    private List<CustomBean>  customBeanList  = null ;
    private Map<String ,Object > reportParameters =  null;
    private String location  = null;



    public String jasperDataSource() {

        JasperQueryVO jasperQueryVO = (JasperQueryVO) ActionContext.getContext().getValueStack().findValue(JasperQueryVO.class.getSimpleName());

        jasperQueryVO.setJrResultdataSource(new JREmptyDataSource());
        jasperQueryVO.setJrResultformat("text/html");
        jasperQueryVO.setJrResultLocation(jasperQueryVO.getJasperCompiledFilePath());

        customBeanList = genCustomBean() ;

        reportParameters = new HashMap<>(2);
        reportParameters.put("ReportTitle", "Address Report");
        reportParameters.put("DataFile", "CustomBeanFactory.java - Bean Collection");


        location = "/WEB-INF/jasperDesignJasper/testModel/dataSourceReport.jasper" ;

        ActionContext.getContext().getValueStack().push(customBeanList);
        ActionContext.getContext().getValueStack().push(reportParameters);
        ActionContext.getContext().getValueStack().push(location);

        System.out.println("------------------------------------------------datasource jasper reports ");
        return "jasperDataSource";
    }



    public String jasperDataSourceFont() {

        JasperQueryVO jasperQueryVO = (JasperQueryVO) ActionContext.getContext().getValueStack().findValue(JasperQueryVO.class.getSimpleName());

        jasperQueryVO.setJrResultdataSource(new JREmptyDataSource());
        jasperQueryVO.setJrResultformat("text/html");
        jasperQueryVO.setJrResultLocation(jasperQueryVO.getJasperCompiledFilePath());

        customBeanList = genCustomBean() ;

        reportParameters = new HashMap<>(2);
        reportParameters.put("ReportTitle", "Address Report");
        reportParameters.put("DataFile", "CustomBeanFactory.java - Bean Collection");


        location = "/WEB-INF/jasperDesignJasper/testModel/font.jasper" ;

        ActionContext.getContext().getValueStack().push(customBeanList);
        ActionContext.getContext().getValueStack().push(reportParameters);
        ActionContext.getContext().getValueStack().push(location);

        System.out.println("------------------------------------------------font jasper reports ");
        return "jasperDataSourceFont";
    }


    private List<CustomBean> genCustomBean() {
        CustomBean[] data =
                {
                        new CustomBean("Berne", new Integer(9), "James Schneider", "277 Seventh Av."),
                        new CustomBean("Berne", new Integer(22), "Bill Ott", "250 - 20th Ave."),
                        new CustomBean("Boston", new Integer(23), "Julia Heiniger", "358 College Av."),
                        new CustomBean("Boston", new Integer(32), "Michael Ott", "339 College Av."),
                        new CustomBean("Chicago", new Integer(39), "Mary Karsen", "202 College Av."),
                        new CustomBean("Chicago", new Integer(35), "George Karsen", "412 College Av."),
                        new CustomBean("Chicago", new Integer(11), "Julia White", "412 Upland Pl."),
                        new CustomBean("Dallas", new Integer(47), "Janet Fuller", "445 Upland Pl."),
                        new CustomBean("Dallas", new Integer(43), "Susanne Smith", "2 Upland Pl."),
                        new CustomBean("Dallas", new Integer(40), "Susanne Miller", "440 - 20th Ave."),
                        new CustomBean("Dallas", new Integer(36), "John Steel", "276 Upland Pl."),
                        new CustomBean("Dallas", new Integer(37), "Michael Clancy", "19 Seventh Av."),
                        new CustomBean("Dallas", new Integer(19), "Susanne Heiniger", "86 - 20th Ave."),
                        new CustomBean("Dallas", new Integer(10), "Anne Fuller", "135 Upland Pl."),
                        new CustomBean("Dallas", new Integer(4), "Sylvia Ringer", "365 College Av."),
                        new CustomBean("Dallas", new Integer(0), "Laura Steel", "429 Seventh Av."),
                        new CustomBean("Lyon", new Integer(38), "Andrew Heiniger", "347 College Av."),
                        new CustomBean("Lyon", new Integer(28), "Susanne White", "74 - 20th Ave."),
                        new CustomBean("Lyon", new Integer(17), "Laura Ott", "443 Seventh Av."),
                        new CustomBean("Lyon", new Integer(2), "Anne Miller", "20 Upland Pl."),
                        new CustomBean("New York", new Integer(46), "Andrew May", "172 Seventh Av."),
                        new CustomBean("New York", new Integer(44), "Sylvia Ott", "361 College Av."),
                        new CustomBean("New York", new Integer(41), "Bill King", "546 College Av."),
                        new CustomBean("Oslo", new Integer(45), "Janet May", "396 Seventh Av."),
                        new CustomBean("Oslo", new Integer(42), "Robert Ott", "503 Seventh Av."),
                        new CustomBean("Paris", new Integer(25), "Sylvia Steel", "269 College Av."),
                        new CustomBean("Paris", new Integer(18), "Sylvia Fuller", "158 - 20th Ave."),
                        new CustomBean("Paris", new Integer(5), "Laura Miller", "294 Seventh Av."),
                        new CustomBean("San Francisco", new Integer(48), "Robert White", "549 Seventh Av."),
                        new CustomBean("San Francisco", new Integer(7), "James Peterson", "231 Upland Pl.")
                };


        List<CustomBean> customBeans = Arrays.asList(data);

        return  customBeans ;
    }


}
