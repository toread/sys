package com.toread.sys.utils;

import java.util.logging.Logger;

/**
 * @author 黎志兵
 */
public  abstract class MonitorUtils {
    /**
     * 初始时间
     * @return
     */
    public static final Long timeNow(){
        return System.currentTimeMillis();
    }

    /**
     * 结束时间
     * @param begin
     */
    public static final void idleLogger(Long begin){
        Long end = System.currentTimeMillis();
        //判断堆栈信息
        StackTraceElement[] trace = Thread.currentThread().getStackTrace();
        if(trace.length<=2){return;}
        StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[2];
        Logger.getLogger(stackTraceElement.getClassName()).info(stackTraceElement.getMethodName()+"耗时:"+(end-begin));
    }

}
