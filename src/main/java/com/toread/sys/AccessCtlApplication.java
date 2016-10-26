package com.toread.sys;

import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.toread.sys.config.MybatisPlusConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.HttpMessageConverter;

import java.io.IOException;

@SpringBootApplication
@MapperScan("com.toread.sys.mapper")
@AutoConfigureAfter(MybatisPlusConfig.class)
public class AccessCtlApplication {
	public static void main(String[] args) throws IOException {
		SpringApplication.run(AccessCtlApplication.class, args);
	}

	@Bean
	public HttpMessageConverter FastJsonHttpMessageConverter(){
		return new FastJsonHttpMessageConverter();
	}
}
