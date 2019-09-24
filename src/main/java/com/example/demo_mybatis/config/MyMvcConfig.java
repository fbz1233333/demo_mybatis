package com.example.demo_mybatis.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

@Configuration
//扩展SpringMvc的功能
public class MyMvcConfig implements WebMvcConfigurer {
//    @Override
//    public  void addViewControllers(ViewControllerRegistry registry){
//        registry.addViewController("/").setViewName("index");
//        registry.addViewController("/welcome").setViewName("welcome");
//        registry.addViewController("/login").setViewName("login");
//        registry.addViewController("/register").setViewName("register");
//        registry.addViewController("/file").setViewName("upload_file");
//
//
//    }

//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        //springboot已经做好了静态资源的映射了
//        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
//        .excludePathPatterns("/login","/","/user/login","user/register","/register","/hello");
//    }

 
    public void addViewControllers(ViewControllerRegistry registry){
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/login").setViewName("login");

    }



    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //配置静态资源处理
        registry.addResourceHandler("/image/**")
                .addResourceLocations( "file:H://manga/");
    }
}
