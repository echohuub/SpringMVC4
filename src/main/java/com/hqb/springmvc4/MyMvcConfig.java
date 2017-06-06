/**
 * Copyright (c) 2017 qingbao.ho@gmail.com. All rights reserved.
 */
package com.hqb.springmvc4;

import com.hqb.springmvc4.interceptor.DemoInterceptor;
import com.hqb.springmvc4.messageconverter.MyMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import java.util.List;

/**
 * Created by heqingbao on 2017/6/6.
 */
@Configuration
@EnableWebMvc // 开启SpringMVC支持，若无此句，重写WebMvcConfigurerAdapter方法无效
@ComponentScan("com.hqb.springmvc4")
public class MyMvcConfig extends WebMvcConfigurerAdapter { // 继承WebMvcConfigurerAdapter类，重写其方法可对SpringMVC进行配置

    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/classes/views/");
        viewResolver.setSuffix(".jsp");
        viewResolver.setViewClass(JstlView.class);
        return viewResolver;
    }

    @Bean // 配置拦截器的Bean
    public DemoInterceptor demoInterceptor() {
        return new DemoInterceptor();
    }

    @Bean
    public MultipartResolver multipartResolver() {
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
        multipartResolver.setMaxUploadSize(1000000);
        return multipartResolver;
    }

    @Bean
    public MyMessageConverter converter() {
        return new MyMessageConverter();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) { // 重写addInterceptors方法，注册拦截器
        registry.addInterceptor(demoInterceptor());
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // addResourceHandler指的是对外暴露的访问路径，addResourceLocations指的是文件放置的目录
        registry.addResourceHandler("/assets/**").addResourceLocations("classpath:/assets/");
    }

    // 无任何业务处理，只是简单的页面转向，这样更简洁，管理更集中
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/index").setViewName("/index");
        registry.addViewController("/toUpload").setViewName("/upload");
        registry.addViewController("/converter").setViewName("/converter");
    }

    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        // 在SpringMVC中，路径参数如果带"."的话，"."后面的值将被忽略。
        configurer.setUseSuffixPatternMatch(false);
    }

    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(converter());
    }
}
