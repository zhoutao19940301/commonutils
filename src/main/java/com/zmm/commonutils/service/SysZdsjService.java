package com.zmm.commonutils.service;

import com.zmm.commonutils.dao.SysZdsjMapper;
import com.zmm.commonutils.entity.SysZdsj;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * @Descriprion: TODO
 * @Author: zhoutao
 * @Date: 2019/11/6
 **/
@Service
public class SysZdsjService {

    @Resource
    private SysZdsjMapper sysZdsjMapper;

    /**
     * 根据字典类型获取字典数据
     */
    public List<SysZdsj> findByZdlxId(Long zdlxId){
        return sysZdsjMapper.getByZdlxId(zdlxId);
    }

    public List<SysZdsj> findAll(){
        return sysZdsjMapper.selectAll();
    }

    public void test(Long... ids){
        //条件的组合工具
        Example example = new Example(SysZdsj.class);
        //条件,一个criteria中可以组合无数个条件，但是这些条件都是and关系
        Example.Criteria criteria = example.createCriteria();
        criteria.andIn("quantitativeIndexId" , Arrays.asList(ids));
        sysZdsjMapper.selectByExample(example);
    }

}
