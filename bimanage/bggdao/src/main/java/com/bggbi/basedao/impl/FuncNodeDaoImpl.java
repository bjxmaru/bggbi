package com.bggbi.basedao.impl;

import com.bggbi.basedao.FuncNodeDao;
import com.bggbi.basedoc.pojo.MainFuncNodeBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

@Repository("FuncNodeDao")
@Scope("singleton")

public class FuncNodeDaoImpl extends BaseDaoImpl implements FuncNodeDao {

    @Autowired()
    @Qualifier("hibernateTemplateBggwebdb")
    private HibernateTemplate hibernateTemplateBggwebdb;


    @Override
    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplateBggwebdb;
    }

    @Override
    public MainFuncNodeBean getMainFuncNodeWithSonNodeList(Integer id) {

        

        return null;
    }
}
