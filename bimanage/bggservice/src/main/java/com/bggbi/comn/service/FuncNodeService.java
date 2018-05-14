package com.bggbi.comn.service;

import com.bggbi.basedoc.pojo.MainFuncNodeBean;

import java.util.List;

public interface FuncNodeService {

    /**
     * init the function node list in the ztree  ui  component  locationed  in the left of  the web  page ;
     * 获取初始化时的功能节点明细列表
     * @return
     */

    public List<MainFuncNodeBean> initMainFuncNode() ;
}
