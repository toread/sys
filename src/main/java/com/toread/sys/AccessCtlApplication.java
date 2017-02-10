package com.toread.sys;

import com.toread.sys.common.mybatis.CRUDMapper;
import com.toread.sys.common.spring.SpringContext;
import org.hibernate.validator.HibernateValidator;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.BeansException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ConversionServiceFactoryBean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.io.IOException;

@SpringBootApplication(scanBasePackages = "com.toread.sys")
@MapperScan(basePackages = {"com.toread.sys.mapper"}, markerInterface = CRUDMapper.class)
@EnableCaching
public class AccessCtlApplication   extends SpringBootServletInitializer implements ApplicationContextAware {

	public AccessCtlApplication() {
		super();
		setRegisterErrorPageFilter(false);
	}

	public static void main(String[] args) throws IOException {
		SpringApplication.run(AccessCtlApplication.class, args);
	}



	@Bean
	public  LocalValidatorFactoryBean localValidatorFactoryBean(ResourceBundleMessageSource resourceBundleMessageSource){
		LocalValidatorFactoryBean factoryBean = new LocalValidatorFactoryBean();
		factoryBean.setProviderClass(HibernateValidator.class);
		factoryBean.setValidationMessageSource(resourceBundleMessageSource);
		return factoryBean;
	}
	@Bean
	public ResourceBundleMessageSource resourceBundleMessageSource(){
		ResourceBundleMessageSource resourceBundleMessageSource = new  ResourceBundleMessageSource();
        //自定义的错误内容
        resourceBundleMessageSource.addBasenames("messages/message");
        resourceBundleMessageSource.addBasenames("validationExtMessages/validationExtMessages");
        resourceBundleMessageSource.addBasenames("org/hibernate/validator/ValidationMessages");
        resourceBundleMessageSource.setDefaultEncoding("UTF-8");
        return  resourceBundleMessageSource;
	}

	@Bean
	public SessionLocaleResolver sessionLocaleResolver(){
		SessionLocaleResolver sessionLocaleResolver = new SessionLocaleResolver();
		return sessionLocaleResolver;
	}

	@Bean(name = "customizationConversionService")
	public ConversionServiceFactoryBean conversionServiceFactoryBean(){
		ConversionServiceFactoryBean conversionServiceFactoryBean = new ConversionServiceFactoryBean();
		return conversionServiceFactoryBean;
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		SpringContext.setApplicationContext(applicationContext);
	}
}
