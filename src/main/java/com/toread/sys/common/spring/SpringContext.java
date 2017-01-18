package com.toread.sys.common.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;

/**
 * Spring对象读取
 * @author 黎志兵
 */
public  abstract class SpringContext {
    private static  final Logger logger = LoggerFactory.getLogger(SpringContext.class);
    private static ApplicationContext applicationContext;
    public static final void setApplicationContext(ApplicationContext applicationContext) {
        synchronized (SpringContext.class) {
            logger.debug("setApplicationContext, notifyAll");
            SpringContext.applicationContext = applicationContext;
            SpringContext.class.notifyAll();
        }
    }

    public static final ApplicationContext getApplicationContext() {
        synchronized (SpringContext.class) {
            while (applicationContext == null) {
                try {
                    logger.debug("getApplicationContext, wait...");
                    ApplicationContext.class.wait(20000);
                    if (applicationContext == null) {
                        logger.warn("Have been waiting for ApplicationContext to be set for 20 second", new Exception());
                    }
                } catch (InterruptedException ex) {
                    logger.debug("getApplicationContext, wait interrupted");
                }
            }
            return applicationContext;
        }
    }

    public static  final Object getBean(String name) {
        return getApplicationContext().getBean(name);
    }

    public static final <T>  T  getBean(Class<T> t ) {
        return getApplicationContext().getBean(t);
    }

    public static final  <T>  T  getBean(String name,Class<T> t) {
        return getApplicationContext().getBean(name,t);
    }
}
