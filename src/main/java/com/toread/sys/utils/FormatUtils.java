package com.toread.sys.utils;

import org.apache.commons.lang.StringEscapeUtils;

import java.text.MessageFormat;

/**
 * @author 黎志兵
 */
public abstract class FormatUtils {
    /**
     * 格式化显示数据
     * @param template
     * @param objects
     * @return
     */
    public static final String  format(String template,Object... objects ){
        MessageFormat messageFormat = new MessageFormat(template);
        return messageFormat.format(objects);
    }

    public static final String sqlAllLike(String values){
        return StringEscapeUtils.escapeSql(format("{0}"+values+"{0}","%"));
    }

}
