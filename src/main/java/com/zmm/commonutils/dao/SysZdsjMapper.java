package com.zmm.commonutils.dao;

import com.zmm.commonutils.baseclass.MyMapper;
import com.zmm.commonutils.entity.SysZdsj;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysZdsjMapper extends MyMapper<SysZdsj> {

    List<SysZdsj> getByZdlxId(@Param("zdlxId") Long zdlxId);

}