package com.xfb.shiro.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import java.util.HashMap;
import java.util.Map;

/**
 * className:CustomRealm
 * describe:
 * author:邢芳彬
 * createTime:2018-11-14 10:49
 */
public class CustomRealm extends AuthorizingRealm {
    Map<String,String> userMap = new HashMap<String, String>();
    {
        userMap.put("Mark", "123456");
        super.setName("aaa");
    }
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //1.从主体传来的认证信息中。获取用户名
        String userName=(String)authenticationToken.getPrincipal();
        //2.通过用户名到数据库中获取凭证
        String passWord = getPassWordByUserName(userName);
        if (passWord == null) {
            return null;
        }
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo("Mark", passWord, "aaa");
        authenticationInfo.setCredentialsSalt(ByteSource.Util.bytes("mark"));
        return authenticationInfo;
    }

    private String getPassWordByUserName(String userName) {
        return userMap.get(userName);
    }
}
