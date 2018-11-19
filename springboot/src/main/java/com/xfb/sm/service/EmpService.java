package com.xfb.sm.service;

import com.xfb.sm.entity.Emp;

import java.util.List;
import java.util.Map;

/**
 * className:EmpService
 * describe:
 * author:邢芳彬
 * createTime:2018-11-09 16:16
 */
public interface EmpService {

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
     * @param emp
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
     * @param deptNo
     * @return
     */
    List<Emp> getProListBydeptNo(int deptNo);
}
