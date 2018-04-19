package com.bggbi.query.param.service.impl;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.net.URL;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:applicationContext-*.xml")
public class JasperAntTest {


    TableApp tableApp;

    @Autowired
    ApplicationContext  ctx;

    @Before
    public void init() {
        tableApp = new TableApp();
    }

    @Test
    public void testTableApp() {

        URL resource = tableApp.getClass().getClassLoader().getResource("resources");

    }


}
