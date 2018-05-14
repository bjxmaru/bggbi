package com.bggbi.query.param.service.impl;

import com.bggbi.basedao.FuncNodeDao;
import com.bggbi.basedoc.pojo.MainFuncNodeBean;
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
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:applicationContext-*.xml")
public class JasperAntTest {


    @Autowired
    ApplicationContext ctx;



    @Test
    public  void test01() {
        MainFuncNodeBean bean = ctx.getBean(MainFuncNodeBean.class);


        FuncNodeDao funcNodeDao = ctx.getBean(FuncNodeDao.class);

        List<MainFuncNodeBean> mainFuncNodeBeanList = funcNodeDao.queryAll(MainFuncNodeBean.class);

        bean.setFnName("沃尔沃哦");

        System.out.println(mainFuncNodeBeanList.size());
    }
}
