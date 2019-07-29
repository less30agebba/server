package com.taoleg.serverweb.main.config;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.taoleg.serverweb.main.interceptor.AuthConsumerInterceptor;
import com.taoleg.serverweb.main.interceptor.AuthManagerInterceptor;
import com.taoleg.serverweb.main.interceptor.LogInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter {

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {

        FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
        fastConverter.setFastJsonConfig(fastJsonConfig);

        converters.add(fastConverter);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(new LogInterceptor()).addPathPatterns("/**").excludePathPatterns("/manager/agent/**/imgupload");

        registry.addInterceptor(new AuthManagerInterceptor())
                .addPathPatterns("/manager/**")
                .excludePathPatterns("/manager/auth/login")
                .excludePathPatterns("/manager/auth/logout").excludePathPatterns("/manager/agent/**/imgupload");

        registry.addInterceptor(new AuthConsumerInterceptor())
                .addPathPatterns("/consumer/**")
                .excludePathPatterns("/consumer/auth/**/login")
                .excludePathPatterns("/consumer/auth/**/logout")
                .excludePathPatterns("/consumer/auth/**/forgetPassword")
                .excludePathPatterns("/consumer/auth/**/vcode/username")
                .excludePathPatterns("/consumer/auth/**/user/exists");
    }
}
