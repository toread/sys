package com.toread.sys.config;

import org.hibernate.validator.HibernateValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ConversionServiceFactoryBean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

/**
 * @author 黎志兵
 */
@Configuration
public class OtherConfig {


  @Bean
  public LocalValidatorFactoryBean localValidatorFactoryBean(ResourceBundleMessageSource resourceBundleMessageSource) {
    LocalValidatorFactoryBean factoryBean = new LocalValidatorFactoryBean();
    factoryBean.setProviderClass(HibernateValidator.class);
    factoryBean.setValidationMessageSource(resourceBundleMessageSource);
    return factoryBean;
  }


  @Bean(name = "customizationConversionService")
  public ConversionServiceFactoryBean conversionServiceFactoryBean() {
    ConversionServiceFactoryBean conversionServiceFactoryBean = new ConversionServiceFactoryBean();
    return conversionServiceFactoryBean;
  }
}
