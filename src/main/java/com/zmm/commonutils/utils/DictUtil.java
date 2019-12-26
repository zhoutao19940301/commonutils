package com.zmm.commonutils.utils;

import com.zmm.commonutils.dao.SysZdsjMapper;
import com.zmm.commonutils.entity.SysZdsj;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;

/**
 * @Descriprion: TODO
 * @Author: zhoutao
 * @Date: 2019/11/7
 **/
public class DictUtil {

    @Autowired
    private static SysZdsjMapper sysZdsjMapper;

    private static HashMap<String, String> hashMap = new HashMap<String, String>();

    static {
        //在这里我们不能使用注入进来的customerDao，因为它此时还没有被创建出来，所以我们要在系统
        //运行的时候获取项目的上下文手动去获取这个bean
        sysZdsjMapper = SpringUtil.getBean(SysZdsjMapper.class);
        queryDict();
    }

    //把字典信息放到map中
    public static void queryDict() {
        List<SysZdsj> dicts = sysZdsjMapper.selectAll();
        for(SysZdsj dict : dicts ){
            String key = "sys_zdsj.ZDSJMC" + dict.getZdsjId();
            String value = dict.getZdsjmc();
            hashMap.put(key, value);
        }
    }

    //获取字典信息的具体方法
    public static String getValue(String tableColumn,Integer code) {
        String key = tableColumn + code;
        String val = hashMap.get(key);
        return val;
    }

}
