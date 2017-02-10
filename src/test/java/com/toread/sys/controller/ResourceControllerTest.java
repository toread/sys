package com.toread.sys.controller;

import com.toread.sys.base.ControllerTest;
import com.toread.sys.common.enums.State;
import com.toread.sys.common.spring.mvc.RestResult;
import com.toread.sys.config.APIRout;
import com.toread.sys.entity.Resource;
import org.junit.Test;
import org.springframework.util.Assert;

/**
 * @author 黎志兵
 */
public class ResourceControllerTest extends ControllerTest {

    @Test
    public void addResource() throws Exception {
        Resource resource = new Resource();
        resource.setResName("资源名称");
        resource.setResState(State.ENABLED.code());
        resource.setResVal("wwww.baidu.com");
        RestResult xxx = restTemplate.postForObject(APIRout.ResourceAPI.ADD, resource, RestResult.class);
        Assert.isTrue(xxx.getOperateResult().equals(RestResult.OperateResult.SUCCESS));
    }

    @Test
    public void deleteResource() throws Exception {

    }

    @Test
    public void updateResource() throws Exception {

    }

    @Test
    public void queryResource() throws Exception {

    }
}