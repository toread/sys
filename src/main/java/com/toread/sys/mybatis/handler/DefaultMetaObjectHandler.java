package com.toread.sys.mybatis.handler;

import com.baomidou.mybatisplus.mapper.IMetaObjectHandler;
import com.toread.sys.mybatis.annotation.CTime;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.apache.ibatis.reflection.MetaObject;
import java.lang.reflect.Field;
import java.util.Calendar;

/**
 * Created by toread on 16-10-19.
 */
public class DefaultMetaObjectHandler implements IMetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        Object tag = metaObject.getOriginalObject();
        Field[]  fields = FieldUtils.getFieldsWithAnnotation(tag.getClass(),CTime.class);
        for (Field field : fields) {
            metaObject.setValue(field.getName(), Calendar.getInstance().getTime());
        }
    }
}
