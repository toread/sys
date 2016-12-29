package com.toread.sys.utils;

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

}
