package com.toread.sys;

import com.alibaba.fastjson.JSON;
import com.toread.sys.entity.Menu;
import org.springframework.cglib.beans.BeanGenerator;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;

/**
 * @author 黎志兵
 */
public class CGlibLean {
  public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
    BeanGenerator beanGenerator = new BeanGenerator();
    beanGenerator.setSuperclass(Menu.class);
    beanGenerator.createClass();
    beanGenerator.addProperty("children", List.class);
    Menu menu = (Menu) beanGenerator.create();
    org.apache.commons.beanutils.BeanUtils.setProperty(menu, "children", Arrays.asList("1221"));
    System.out.println(JSON.toJSON(menu));
  }
}
