package com.toread.sys.config;

import com.toread.sys.common.shiro.URLPermissionsFilter;
import com.toread.sys.common.shiro.UserRealm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.filter.authc.AnonymousFilter;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.DelegatingFilterProxy;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 黎志兵
 */
@Configuration
public class ShiroConfig {
    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean filterRegistration = new FilterRegistrationBean();
        DelegatingFilterProxy delegatingFilterProxy = new DelegatingFilterProxy("shiroFilter");
        delegatingFilterProxy.setTargetFilterLifecycle(true);
        filterRegistration.setFilter(delegatingFilterProxy);
        filterRegistration.setEnabled(true);
        filterRegistration.addUrlPatterns("/*");
        filterRegistration.setDispatcherTypes(DispatcherType.REQUEST);
        return filterRegistration;
    }

    /**
     * @return
     * @see org.apache.shiro.spring.web.ShiroFilterFactoryBean
     */
    @Bean(name = "shiroFilter")
    public ShiroFilterFactoryBean shiroFilter(DefaultWebSecurityManager defaultWebSecurityManager, URLPermissionsFilter urlPermissionsFilter) {
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        bean.setSecurityManager(defaultWebSecurityManager);
        bean.setLoginUrl("/login.html");
        bean.setSuccessUrl("/index.html");

        Map<String, Filter> filters = new HashMap<>();
        filters.put("anon", new AnonymousFilter());
        filters.put("perms", urlPermissionsFilter);
        bean.setFilters(filters);

        Map<String, String> chains = new HashMap<>();
        chains.put(APIRout.UserAPI.LOGIN, "anon");
        chains.put(APIRout.UserAPI.LOGOUT, "logout");
        chains.put("/login.html", "anon");
        chains.put("/**", "perms");
        bean.setFilterChainDefinitionMap(chains);
        return bean;
    }


    /**
     * @return
     * @see org.apache.shiro.mgt.SecurityManager
     */
    @Bean(name = "ShiroSecurityManager")
    public DefaultWebSecurityManager securityManager(UserRealm userRealm) {
        DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
        manager.setRealm(userRealm);
        return manager;
    }

    /**
     * @return
     * @see DefaultWebSessionManager
     */
    @Bean(name = "sessionManager")
    public DefaultWebSessionManager defaultWebSessionManager() {
        DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
        sessionManager.setGlobalSessionTimeout(1800000);
        sessionManager.setDeleteInvalidSessions(true);
        sessionManager.setSessionValidationSchedulerEnabled(true);
        sessionManager.setDeleteInvalidSessions(true);
        return sessionManager;
    }

    @Bean
    public UserRealm userRealm() {
        UserRealm userRealm = new UserRealm();
        return userRealm;
    }

}
