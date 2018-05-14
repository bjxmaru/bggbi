package com.bggbi.basedao.impl;

import com.bggbi.basedao.BaseDao;
import org.springframework.orm.hibernate5.HibernateTemplate;

import java.util.List;

public abstract class BaseDaoImpl implements BaseDao {

    public abstract HibernateTemplate getHibernateTemplate();

    @Override
    public <T> T query(Class<T> entityClass, String id) {
        return getHibernateTemplate().get(entityClass, id);
    }


    @Override
    public void save(Object entity) {
        getHibernateTemplate().save(entity);
    }


    @Override
    public void delete(Object entity) {
        getHibernateTemplate().delete(entity);
    }

    @Override
    public void update(Object entity) {
        getHibernateTemplate().update(entity);
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> List<T> queryAll(Class<T> className) {
        return (List<T>) getHibernateTemplate().find("from " + className.getName());
    }


}
