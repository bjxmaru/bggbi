package com.bggbi.jasper.service.impl;

import com.bggbi.jasper.service.JasperHandle;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.io.File;

@Service("JasperHandle")
@Scope("singleton")
public class JasperHandleImpl implements JasperHandle {


    @Override
    public File compileJasperXml(File jaserXmlFile) {

        return null;
    }
}
