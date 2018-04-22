package com.bgg.web.jasper.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;
import com.sun.tools.classfile.StackMapTable_attribute;
import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller("BaseDocAction")
@Scope("prototype")
public class BaseDocAction extends ActionSupport{

    String bgg = "bgg";

    String servletActionContext_reuqest =  ServletActionContext.HTTP_REQUEST;

    public String corpInfo() {

        return "corpInfo";
    }

    public String test() {


        ValueStack valueStack = ActionContext.getContext().getValueStack();

        HttpServletRequest  httpServletRequest =(HttpServletRequest)  ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);

        boolean  a = true;

        boolean b = true ;
        boolean c = true ;

        boolean d =  (!a &&  b );

        System.out.println(b);



        return "test" ;
    }
}
