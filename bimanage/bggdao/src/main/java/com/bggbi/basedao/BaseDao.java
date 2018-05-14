package com.bggbi.basedao;

import java.util.List;

/**
 * Created by Administrator on 2017/12/26.
 * 关于存货相关的CRUD接口
 */
public interface BaseDao {



    /**
     * 插入对象
     *
     * @param entity
     * @return
     */
    void  save(Object entity) ;

    /**
     * 删除对象
     *
     * @param entity
     */
    void delete(Object entity) ;

    /**
     * 修改对象
     *
     * @param entity
     */
    void update(Object entity) ;



    /**
     * 根据ID查询对象
     *
     * @param entityClass
     *            类名,如:String.class
     * @param id
     *            ID值
     *
     * @return T
     *             返回的类
     */
    <T> T query(Class<T> entityClass, String id)  ;


    /**
     * 查询全部
     *
     * @param className
     *            类名
     * @return List<T>
     *     类实例的列表
     */
    @SuppressWarnings("unchecked")
    <T> List<T> queryAll(Class<T> className) ;












}
