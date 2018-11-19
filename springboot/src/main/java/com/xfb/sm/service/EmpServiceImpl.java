package com.xfb.sm.service;

import com.xfb.sm.dao.EmpDao;
import com.xfb.sm.entity.Emp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * className:EmpServiceImpl
 * describe:
 * author:邢芳彬
 * createTime:2018-11-09 16:17
 */
@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpDao empDao;

    @Override
    public List<Emp> getList(Map map) {
        map.put("sort", map.get("sort")==null?"empno":map.get("sort"));
        map.put("order", map.get("order")==null?"asc":map.get("order"));
        return empDao.getList(map);
    }

    @Override
    public int add(Emp emp) {
        return empDao.add(emp);
    }

    @Override
    public int delete(Integer empNo) {
        return empDao.delete(empNo);
    }

    @Override
    public List<Emp> getProListBydeptNo(int deptNo) {
        Map map = new HashMap();
        map.put("deptNo", deptNo);
        empDao.getProListBydeptNo(map);
        List<Emp> csrEmp = (List<Emp>) map.get("csrEmp");
        return csrEmp;
    }

    @Override
    public List<Emp> getById(Map map) {
        return empDao.getById(map);
    }
}
