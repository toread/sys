package com.toread.sys.controller;

import com.toread.sys.AccessCtlApplication;
import com.toread.sys.entity.Menu;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.CollectionUtils;

import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * @author toread
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = AccessCtlApplication.class,webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MenuControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void addMenu() throws Exception {
        List<Menu>  result =  restTemplate.postForObject("/menu/getChildes",1L,List.class);
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

    }

}