package com.bggbi.basedoc.pojo;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    private Set<MainFuncNodeBean> childrenSet = new HashSet<MainFuncNodeBean>(1);

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


    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Integer getDr() {
        return dr;
    }

    public void setDr(Integer dr) {
        this.dr = dr;
    }

    /**
     * 数据版本
     */
    private  Integer  version ;

    /**
     * 删除标识
     */
    private Integer dr ;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Set<MainFuncNodeBean> getChildrenSet() {
        return childrenSet;
    }

    public void setChildrenSet(Set<MainFuncNodeBean> childrenSet) {
        this.childrenSet = childrenSet;
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
