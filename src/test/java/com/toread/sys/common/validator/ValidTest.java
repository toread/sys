package com.toread.sys.common.validator;

import com.toread.sys.AccessCtlApplicationTests;
import com.toread.sys.entity.Department;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author 黎志兵
 */
public class ValidTest extends AccessCtlApplicationTests {
    @Autowired
    private  Valid valid;

    @Test
    public void valid() throws Exception {
        Department department = new Department();
        valid.valid(department);
    }

    @Test
    public void validateProperty() throws Exception {

    }


    @Test
    public void validateNotNullProperty() throws Exception {
        Department department = new Department();
        department.setDptState(11);
        valid.validateNotNullProperty(department);
    }
}