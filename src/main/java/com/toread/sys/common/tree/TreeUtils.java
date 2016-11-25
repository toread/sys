package com.toread.sys.common.tree;

import org.apache.commons.lang3.reflect.FieldUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.util.Assert;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * @author toread
 */
public abstract class TreeUtils {

    /**
     * 获取注释属性的值
     * @param t
     * @param annotationClass
     * @return
     */
     public  static <T> Object getAnnotationFieldValues(T t, Class annotationClass){
        Field[]  fields = FieldUtils.getFieldsWithAnnotation(t.getClass(),annotationClass);
        if(fields.length==0){
            String  errorMsg = String.format("未找%s字段中标记%s注解",t.getClass().getName(),annotationClass.getName());
            throw  new TreeException(errorMsg);
        }else if (fields.length>1){
            String errorMsg = String.format("只语序%s字段标记一个%s注解",t.getClass().getName(),annotationClass.getName());
            throw  new TreeException(errorMsg);
        }
        BeanWrapper beanWrapper = new BeanWrapperImpl(t);
        Object id = beanWrapper.getPropertyValue(fields[0].getName());
        return id;
    }

    /**
     * 获取节点下的所有数据
     * @param treeNode
     * @param <T>
     * @return
     */
    public static <T> Collection<T>  getTreeChildesData(TreeNode<T> treeNode){
        Assert.notNull(treeNode,"树节点不能为空");
        Collection<TreeNode<T>>  treeNodes = treeNode.getChildes();
        Collection<T>  datas = new ArrayList<T>();
        for (TreeNode<T> node : treeNodes) {
            datas.add(node.getData());
        }
        return datas;
    }
}
