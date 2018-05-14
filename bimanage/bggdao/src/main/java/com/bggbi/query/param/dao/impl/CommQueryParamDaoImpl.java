package com.bggbi.query.param.dao.impl;

import com.bggbi.basedoc.pojo.MainFuncNodeBean;
import com.bggbi.query.param.dao.CommQueryParamDao;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

@Repository("CommQueryParamDao")
@Scope("singleton")
public class CommQueryParamDaoImpl implements CommQueryParamDao {
    @Override
    public MainFuncNodeBean getMainFuncNode(String id) {
        return null;
    }
}
