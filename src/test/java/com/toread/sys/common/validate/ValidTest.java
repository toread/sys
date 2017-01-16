package com.toread.sys.common.validate;

import com.toread.sys.AccessCtlApplicationTests;
import com.toread.sys.entity.Department;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

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
}