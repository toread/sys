package com.toread.sys.utils;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author 黎志兵
 */
public class FormatUtilsTest {

    @Test
    public void format() throws Exception {
    }

    @Test
    public void sqlAllLike() throws Exception {
        assertEquals("%111%",FormatUtils.sqlAllLike("11%1"));
    }
}