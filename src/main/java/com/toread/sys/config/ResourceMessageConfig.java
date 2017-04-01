package com.toread.sys.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

/**
 * @author 黎志兵
 */
@Configuration
public class ResourceMessageConfig {
  @Bean
  public ResourceBundleMessageSource resourceBundleMessageSource() {
    ResourceBundleMessageSource resourceBundleMessageSource = new ResourceBundleMessageSource();
    //自定义的错误内容
    resourceBundleMessageSource.addBasenames("messages/message");
    resourceBundleMessageSource.addBasenames("validationExtMessages/validationExtMessages");
    resourceBundleMessageSource.addBasenames("org/hibernate/validator/ValidationMessages");
    resourceBundleMessageSource.setDefaultEncoding("UTF-8");
    return resourceBundleMessageSource;
  }

  @Bean
  public SessionLocaleResolver sessionLocaleResolver() {
    SessionLocaleResolver sessionLocaleResolver = new SessionLocaleResolver();
    return sessionLocaleResolver;
  }
}
