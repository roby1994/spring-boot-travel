package com.roby.config;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.roby.interceptor.TimeInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by Tao Pingping on 2018/3/21.
 */

@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {


    /**
     * 整合 Fastjson
     *
     * @return
     */
    @Bean
    public HttpMessageConverters fastJsonHttpMessageConverters() {
        FastJsonHttpMessageConverter fastJsonHttpMessageConverter = new FastJsonHttpMessageConverter();
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
        fastJsonHttpMessageConverter.setFastJsonConfig(fastJsonConfig);
        HttpMessageConverter<?> converter = fastJsonHttpMessageConverter;
        return new HttpMessageConverters(converter);
    }


    /**
     * 注册 Servlet
     * @return

     @Bean public ServletRegistrationBean servletRegistrationBean() {
     return new ServletRegistrationBean(new ServletTest(),"/servletTest");
     }*/
    /**
     * 注册过滤器
     * @return

     @Bean public FilterRegistrationBean timeFilter() {
     FilterRegistrationBean registrationBean = new FilterRegistrationBean();
     TimeFilter timeFilter = new TimeFilter();
     registrationBean.setFilter(timeFilter);
     List<String> urls = new ArrayList<>();
     urls.add("/*");
     registrationBean.setUrlPatterns(urls);
     return registrationBean;
     }*/

    /**
     * 注册监听器
     *
     * @return
     * @Bean public ServletListenerRegistrationBean<ListenerTest> servletListenerRegistrationBean() {
     * return new ServletListenerRegistrationBean<ListenerTest>(new ListenerTest());
     * }
     */


    @Autowired
    private TimeInterceptor timeInterceptor;


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(timeInterceptor);
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/fastjson/**")
                .allowedOrigins("http://localhost:28080");// 允许 8088 端口访问
    }
}