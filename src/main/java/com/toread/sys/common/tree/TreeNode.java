package com.toread.sys.common.tree;

import com.toread.sys.common.tree.annotation.TreeId;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.util.Assert;

import java.lang.reflect.Field;
import java.util.List;

/**
 * @author 探路者
 * <h1></h1>
 */
public class TreeNode<T> {
    private List<TreeNode<T>> childes;
    private TreeNode<T> father;
    private T entity;

    public List<TreeNode<T>> getChildes() {
        return childes;
    }

    public void setChildes(List<TreeNode<T>> childes) {
        this.childes = childes;
    }

    public TreeNode<T> getFather() {
        return father;
    }

    public void setFather(TreeNode<T> father) {
        this.father = father;
    }

    public T getEntity() {
        return entity;
    }

    public void setEntity(T entity) {
        this.entity = entity;
    }

    public  TreeNode<T> buildTree(List<T> tList, Object rootId){
        Assert.notEmpty(tList);
        T t = findRoot(tList,rootId);
        TreeNode<T> rootNode = new TreeNode<T>();
        rootNode.setEntity(t);
        for (T t1 : tList) {

        }
        return  null;
    }


    /**
     *
     * @param tlist
     * @return
     */
    private T findRoot(List<T> tlist,Object rootId){
        for (T t : tlist) {
            Field[]  fields = FieldUtils.getFieldsWithAnnotation(t.getClass(),TreeId.class);
            if(fields.length==0){
                String  errorMsg = String.format("未找%s字段中标记%s注解",t.getClass().getName(),TreeId.class.getName());
                throw  new TreeException(errorMsg);
            }else if (fields.length>1){
                String errorMsg = String.format("只语序%s字段标记一个%s注解",t.getClass().getName(),TreeId.class.getName());
                throw  new TreeException(errorMsg);
            }
            BeanWrapper beanWrapper = new BeanWrapperImpl(t);
            Object id = beanWrapper.getPropertyValue(fields[0].getName());
            if(rootId.equals(id)){return t;}
        }
        String errorMsg = "未找到含有"+rootId+"根节点";
        throw  new TreeException(errorMsg);
    }
}
