package com.bgg.web.jasper.action;

import com.opensymphony.xwork2.ActionSupport;
import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller("BaseDocAction")
@Scope("prototype")
public class BaseDocAction extends ActionSupport{


    public String corpInfo() {

        return "corpInfo";
    }
}
