package com.toread.sys.controller;

import com.toread.sys.AccessCtlApplication;
import com.toread.sys.entity.Department;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.RequestEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * @author 黎志兵
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = AccessCtlApplication.class,webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DepartControllerTest {
    @Autowired
    private TestRestTemplate template;

    @Test
    public void getChildes() throws Exception {
        RestTemplate restTemplate = new RestTemplate();
        List<Department> xxx = restTemplate.postForObject("http://localhost:8081/depart/childes",1L, List.class);
        Assert.isTrue(!CollectionUtils.isEmpty(xxx));
    }
}