package com.toread.sys.config;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 黎志兵
 */
@Configuration
public class SpringMvcConfig extends WebMvcConfigurerAdapter {

    //SpringMvcJson处理
    @Bean
    public HttpMessageConverter FastJsonHttpMessageConverter() {
        FastJsonHttpMessageConverter httpMessageConverter = new FastJsonHttpMessageConverter();
        List<MediaType> support = new ArrayList<MediaType>();
        support.add(MediaType.APPLICATION_JSON);
        httpMessageConverter.setSupportedMediaTypes(support);
        httpMessageConverter.getFastJsonConfig().setSerializerFeatures(SerializerFeature.WriteMapNullValue, SerializerFeature.SortField);
        return httpMessageConverter;
    }

    /**
     * 处理请求url地址的匹配规则为严格的规则
     *
     * @param configurer
     */
    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        configurer.setUseSuffixPatternMatch(false)
                .setUseTrailingSlashMatch(false);
    }
}
