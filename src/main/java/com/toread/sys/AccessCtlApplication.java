package com.toread.sys;

import com.toread.sys.common.mybatis.CRUDMapper;
import com.toread.sys.common.spring.SpringContext;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.BeansException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.io.IOException;

@SpringBootApplication(scanBasePackages = "com.toread.sys")
@MapperScan(basePackages = {"com.toread.sys.mapper"}, markerInterface = CRUDMapper.class)
@EnableCaching
@EnableTransactionManagement
public class AccessCtlApplication   extends SpringBootServletInitializer implements ApplicationContextAware {

	public AccessCtlApplication() {
		super();
		setRegisterErrorPageFilter(false);
	}

	public static void main(String[] args) throws IOException {
		SpringApplication.run(AccessCtlApplication.class, args);
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		SpringContext.setApplicationContext(applicationContext);
	}
}
