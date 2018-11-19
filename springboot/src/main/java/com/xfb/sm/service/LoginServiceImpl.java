package com.xfb.sm.service;

import com.xfb.sm.dao.LoginDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * className:LoginServiceImpl
 * describe:
 * author:邢芳彬
 * createTime:2018-11-12 09:10
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginDao loginDao;

    @Override
    public List<Map> login(Map map) {
        return null;
    }
}
