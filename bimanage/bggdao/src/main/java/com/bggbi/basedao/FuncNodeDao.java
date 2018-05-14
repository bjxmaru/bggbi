package com.bggbi.basedao;

import com.bggbi.basedoc.pojo.MainFuncNodeBean;

public interface FuncNodeDao  extends  BaseDao{


    /**
     * function node  with  directive children ;
     * 功能节点,只带有直接子节点信息
     * @param id  node id
     * @return
     */
    public MainFuncNodeBean getMainFuncNodeWithSonNodeList(Integer  id)  ;
}
