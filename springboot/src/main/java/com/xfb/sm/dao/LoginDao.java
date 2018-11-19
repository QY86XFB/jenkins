package com.xfb.sm.dao;

import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * className:LoginDao
 * describe:
 * author:邢芳彬
 * createTime:2018-11-12 09:01
 */
public interface LoginDao {
    @Select("select * from tb_login where username=map.get('username') and password=map.get('pass')")
    List<Map> login(Map map);
}
