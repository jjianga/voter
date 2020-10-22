package org.jjianga.voter.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 服务器配置
 */
@Configuration
public class AppConfiguration implements WebMvcConfigurer {
    //登录状态验证
    @Autowired
    private StatusIntercepter statusIntercepter;

    //开区跨域请求
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowCredentials(true)
                .allowedMethods("GET", "POST", "DELETE", "PUT")
                .allowedHeaders("*")
                .maxAge(86400);
    }

    //拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration addInterceptor = registry.addInterceptor(statusIntercepter);
//        //排除配置
//        addInterceptor.excludePathPatterns("/**");
        // 拦截配置
        addInterceptor.addPathPatterns("/AppsController/**");
    }


}
