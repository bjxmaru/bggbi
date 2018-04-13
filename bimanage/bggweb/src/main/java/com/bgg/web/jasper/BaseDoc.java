package com.bgg.web.jasper;

import com.opensymphony.xwork2.ActionSupport;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller("baseDoc")
@Scope("prototype")
public class BaseDoc  extends ActionSupport{


    public String corpInfo() {

        return "corpInfo";
    }
}
