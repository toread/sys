package com.toread.sys.common.tree;

import com.toread.sys.common.Check;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;

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
         Field[] fields = getFields((T) t, annotationClass);
         BeanWrapper beanWrapper = new BeanWrapperImpl(t);
         Object id = beanWrapper.getPropertyValue(fields[0].getName());
         return id;
    }

    /**
     * 设置含有该注释属性的值
     * @param t
     * @param annotationClass
     * @param propertyValue
     * @param <T>
     */
    public  static <T> void setAnnotationFieldValue(T t, Class annotationClass,Object propertyValue){
        Field[] fields = getFields(t, annotationClass);
        BeanWrapper beanWrapper = new BeanWrapperImpl(t);
        beanWrapper.setPropertyValue(fields[0].getName(),propertyValue);
    }

    private static <T> Field[] getFields(T t, Class annotationClass) {
        Field[]  fields = FieldUtils.getFieldsWithAnnotation(t.getClass(),annotationClass);
        if(fields.length==0){
            String  errorMsg = String.format("未找%s字段中标记%s注解",t.getClass().getName(),annotationClass.getName());
            throw  new TreeException(errorMsg);
        }else if (fields.length>1){
            String errorMsg = String.format("只语序%s字段标记一个%s注解",t.getClass().getName(),annotationClass.getName());
            throw  new TreeException(errorMsg);
        }
        return fields;
    }


    /**
     * 获取节点下的所有数据
     * @param treeNode
     * @param <T>
     * @return
     */
    public static <T> Collection<T>  getTreeChildesData(TreeNode<T> treeNode){
        Check.notNull(treeNode,"树节点不能为空");
        Collection<TreeNode<T>>  treeNodes = treeNode.getChildes();
        Collection<T>  datas = new ArrayList<T>();
        for (TreeNode<T> node : treeNodes) {
            datas.add(node.getData());
        }
        return datas;
    }
}
