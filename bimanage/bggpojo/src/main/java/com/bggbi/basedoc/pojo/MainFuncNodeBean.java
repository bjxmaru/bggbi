package com.bggbi.basedoc.pojo;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 功能节点信息
 *
 */

@Repository("MainFuncNodeBean")
@Scope("prototype")
public class MainFuncNodeBean {

    /**
     * 主键
     */
    private Integer  id ;


    /**
     * 节点的子节点列表
     */
    private List<MainFuncNodeBean>  childrenList ;

    /**
     * 节点名称
     */
    private  String fnName ;


    /**
     * 节点服务器端地址
     */

    private String  fnURL;

    /**
     * 节点加载时打开状态
     */

    private  Boolean  bInitOpen ;


    /**
     * 节点是否是父节点
     */

    private Boolean  bParent ;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<MainFuncNodeBean> getChildrenList() {
        return childrenList;
    }

    public void setChildrenList(List<MainFuncNodeBean> childrenList) {
        this.childrenList = childrenList;
    }

    public String getFnName() {
        return fnName;
    }

    public void setFnName(String fnName) {
        this.fnName = fnName;
    }

    public String getFnURL() {
        return fnURL;
    }

    public void setFnURL(String fnURL) {
        this.fnURL = fnURL;
    }

    public Boolean getbInitOpen() {
        return bInitOpen;
    }

    public void setbInitOpen(Boolean bInitOpen) {
        this.bInitOpen = bInitOpen;
    }

    public Boolean getbParent() {
        return bParent;
    }

    public void setbParent(Boolean bParent) {
        this.bParent = bParent;
    }
}
