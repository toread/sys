package com.toread.sys.utils;

import com.toread.sys.AccessCtlApplicationTests;
import com.toread.sys.common.spring.SpringContext;
import com.toread.sys.entity.User;
import org.junit.Before;
import org.junit.Test;
import org.springframework.core.convert.ConversionService;

import java.util.Map;

import static org.junit.Assert.*;

/**
 * @author 黎志兵
 */
public class MapBeanUtilsTest extends AccessCtlApplicationTests {
    private User user;

    @Before
    public void setUp() throws Exception {
        user = new User();
        user.setUserCode("传奇世界");
        user.setUserId(2L);
    }

    @Test
    public void beanToMap() throws Exception {
        Map<String,Object> maps = MapBeanUtils.beanToMap(user);
        assertNotNull(maps.get("userCode"));
        assertNotNull(maps.get("userId"));
        assertNull(maps.get("userState"));
    }

    @Test
    public void mapToBean() throws Exception {
        Map<String,Object> maps = MapBeanUtils.beanToMap(user);
        assertNotNull(maps.get("userCode"));
        assertNotNull(maps.get("userId"));
        assertNull(maps.get("userState"));

        maps.put("userCode","1212");
        maps.put("userId","1212");
        maps.put("userState","1");
        User userXX  =  MapBeanUtils.mapToBean(maps,User.class);
        assertNotNull(userXX.getUserCode());
        assertNotNull(userXX.getUserId());
        assertNull(userXX.getUserState());
    }

    @Test
    public void testConver(){
        ConversionService conversionService = SpringContext.getBean("customizationConversionService",ConversionService.class);
        assertTrue(conversionService.canConvert(String.class,Long.class));
    }
}