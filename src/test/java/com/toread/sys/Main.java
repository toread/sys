package com.toread.sys;

import com.alibaba.fastjson.JSON;
import com.toread.sys.entity.User;

import java.util.Date;

/**
 * @author 黎志兵
 */
public class Main {
    public static void main(String[] args) {
        User user = new User();
        user.setUserCode("传奇");
        user.setUserCTime(new Date());
        user.setUserState("1");
        System.out.println(JSON.toJSONString(user));
    }
}
