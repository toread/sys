package com.toread.sys.controller;

import com.toread.sys.AccessCtlApplication;
import com.toread.sys.base.ControllerTest;
import com.toread.sys.common.enums.State;
import com.toread.sys.common.mvc.RestResult;
import com.toread.sys.config.APIRout;
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
public class DepartControllerTest extends ControllerTest{
    @Test
    public void getChildes() throws Exception {
        List<Department> xxx = restTemplate.postForObject(APIRout.DeptAPI.CHILDES,1L, List.class);
        Assert.isTrue(!CollectionUtils.isEmpty(xxx));
    }

    @Test
    public void addDepartment() throws Exception {
        Department department = new Department();
        department.setDptPid(819022112830210048l);
        department.setDptName("成功");
        department.setDptType("1");
        RestResult restResult = restTemplate.postForObject(APIRout.DeptAPI.ADD,department, RestResult.class);
        Assert.isTrue(restResult.getOperateResult().equals(RestResult.OperateResult.SUCCESS));
    }

    @Test
    public void deleteDepartment() throws Exception {
        Department department = new Department();
        department.setDptPid(1L);
        department.setDptName("市委拜纳姆市委拜纳姆市委拜纳姆市委拜纳姆市委拜纳姆市委拜纳姆市委");
        department.setDptState(State.ENABLED.code());
        department.setDptType("1");
        RestResult restResult = restTemplate.postForObject(APIRout.DeptAPI.ADD,department, RestResult.class);
        Assert.isTrue(restResult.getOperateResult().equals(RestResult.OperateResult.SUCCESS));
        RestResult restResultDel = restTemplate.postForObject(APIRout.DeptAPI.DELETE,department, RestResult.class);
        Assert.isTrue(restResultDel.getOperateResult().equals(RestResult.OperateResult.SUCCESS));
    }

    @Test
    public void updateDepartment() throws Exception {

    }
}