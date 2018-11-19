package com.xfb.sm;

import com.xfb.sm.interceptor.LoginInterceptor;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * className:MvcConfigClass
 * describe:
 * author:邢芳彬
 * createTime:2018-11-10 16:45
 */
@SpringBootConfiguration  //标识该类为配置类
public class MvcConfigClass implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        //添加自定义拦截器， 拦截路径：addPathPatterns，不拦截路径：excludePathPatterns  多个路径用，隔开
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**").excludePathPatterns("/emp/toUpload","/toLogin","/login");
    }
}
