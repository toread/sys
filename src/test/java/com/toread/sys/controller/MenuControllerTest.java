package com.toread.sys.controller;

import com.toread.sys.base.ControllerTest;
import com.toread.sys.common.enums.State;
import com.toread.sys.common.spring.mvc.RestResult;
import com.toread.sys.config.APIRout;
import com.toread.sys.entity.Menu;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.util.CollectionUtils;

import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * @author toread
 */
public class MenuControllerTest extends ControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void addMenu() throws Exception {
        Menu menu = new Menu();
        menu.setMenuName("资源树");
        menu.setMenuState(State.ENABLED.code().toString());
        menu.setMenuIcon("home");
        menu.setMenuOrder(1);
        menu.setMenuPid(1L);
        restTemplate.postForObject(APIRout.MenuAPI.ADD, menu, RestResult.class);
        Menu menu1 = new Menu();
        menu1.setMenuPid(1L);
        menu1.setMenuIcon("ios-locked");
        menu1.setMenuName("权限管理");
        menu1.setMenuState(State.ENABLED.code().toString());
        menu1.setMenuPid(1L);
        menu1.setMenuOrder(1);
        restTemplate.postForObject(APIRout.MenuAPI.ADD, menu1, RestResult.class);

        Menu menu2 = new Menu();
        menu2.setMenuPid(1L);
        menu2.setMenuOrder(2);
        menu2.setMenuState(State.ENABLED.code().toString());
        menu2.setMenuIcon("ios-people");
        menu2.setMenuName("机构管理");
        restTemplate.postForObject(APIRout.MenuAPI.ADD, menu2, RestResult.class);
        List<Menu> result = restTemplate.postForObject(APIRout.MenuAPI.ADD, 1L, List.class);
        assertTrue(!CollectionUtils.isEmpty(result));
    }

    @Test
    public void deleteMenu() throws Exception {

    }

    @Test
    public void updateMenu() throws Exception {

    }

    @Test
    public void getChildes() throws Exception {
        List<Menu> result = restTemplate.postForObject("/menu/getChildes", 1L, List.class);
        assertTrue(!CollectionUtils.isEmpty(result));
    }

}