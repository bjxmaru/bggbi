package com.bggbi.query.param.dao;

import com.bggbi.basedoc.pojo.MainFuncNodeBean;

public interface CommQueryParamDao {

    /**
     *
     * @param id  funcNode   primary key  , funcNode  is the node of   the  function tree  location in the  left of the web page ;
     * @return  funcNode
     */
    public MainFuncNodeBean getMainFuncNode(String id);
}
