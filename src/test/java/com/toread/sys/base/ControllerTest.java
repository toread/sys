package com.toread.sys.base;

import com.toread.sys.AccessCtlApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author 黎志兵
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = AccessCtlApplication.class,webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ControllerTest {
    @Autowired
    protected TestRestTemplate restTemplate;

    @Test
    public void test(){

    }
}
