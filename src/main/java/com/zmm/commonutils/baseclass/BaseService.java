package com.zmm.commonutils.baseclass;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Descriprion: TODO
 * @Author: zhoutao
 * @Date: 2019/10/29
 **/
public class BaseService<T> {

    @Autowired
    private MyMapper<T> mapper;

    public int save(T entity) {
        return mapper.insertSelective(entity);
    }

    public int delete(T entity) {
        return mapper.deleteByPrimaryKey(entity);
    }

    public int update(T entity) {
        return mapper.updateByPrimaryKeySelective(entity);
    }

    public T findOne(T entity) {
        return  mapper.selectOne(entity);
    }

    public List<T> list(T entity) {
        return mapper.select(entity);
    }

}
