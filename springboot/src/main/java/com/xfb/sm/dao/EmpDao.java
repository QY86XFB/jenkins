package com.xfb.sm.dao;

import com.xfb.sm.entity.Emp;

import java.util.List;
import java.util.Map;

/**
 * className:EmpDao
 * describe:
 * author:邢芳彬
 * createTime:2018-11-09 15:51
 */
public interface EmpDao {

    /**
     * 员工列表方法
     * @param map
     * @return
     */
    List<Emp> getList(Map map);

    /**
     * 员工添加
     * @param emp
     * @return
     */
    int add(Emp emp);

    /**
     * 根据ID获取员工
     * @param map
     * @return
     */
    List<Emp> getById(Map map);

    /**
     * 员工删除
     * @param empNo
     * @return
     */
    int delete(Integer empNo);


    /**
     * 调用存储过程，根据部门编号获取人员列表
     * @param map
     * @return
     */
    List<Emp> getProListBydeptNo(Map map);
}
