package com.toread.sys;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.toread.sys.config.CacheConfig;
import com.toread.sys.config.MybatisPlusConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.support.ErrorPageFilter;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication(scanBasePackages = "com.toread.sys")
@MapperScan("com.toread.sys.mapper")
@AutoConfigureAfter({MybatisPlusConfig.class})
@EnableCaching
public class AccessCtlApplication   extends SpringBootServletInitializer {

	public AccessCtlApplication() {
		super();
		setRegisterErrorPageFilter(false);
	}

	public static void main(String[] args) throws IOException {
		SpringApplication.run(AccessCtlApplication.class, args);
	}

	@Bean
	public HttpMessageConverter FastJsonHttpMessageConverter(){
		FastJsonHttpMessageConverter  httpMessageConverter =  new  FastJsonHttpMessageConverter();
		List<MediaType> support = new  ArrayList<MediaType>();
		support.add(MediaType.APPLICATION_JSON);
		httpMessageConverter.setSupportedMediaTypes(support);
		httpMessageConverter.getFastJsonConfig().setSerializerFeatures(SerializerFeature.WriteMapNullValue,SerializerFeature.SortField);
		return httpMessageConverter;
	}
}
