package com.bggbi.comn.service.impl;

import com.bggbi.basedao.FuncNodeDao;
import com.bggbi.basedoc.pojo.MainFuncNodeBean;
import com.bggbi.comn.service.FuncNodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("FuncNodeService")
@Scope("singleton")
public class FuncNodeServiceImpl implements FuncNodeService {

    @Autowired
    @Qualifier("FuncNodeDao")
    private FuncNodeDao  funcNodeDao ;


    @Override
    public List<MainFuncNodeBean> initMainFuncNode() {

        return null;
    }
}
