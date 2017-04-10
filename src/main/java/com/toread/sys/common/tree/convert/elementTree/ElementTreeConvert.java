package com.toread.sys.common.tree.convert.elementTree;

import com.toread.sys.common.tree.TreeNode;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * 平台树转换成ElementTree
 *
 * @author 黎志兵
 */
public abstract class ElementTreeConvert {

  public static final String CHILDREN_FILED = "children";

  /**
   * 转换指定节点
   *
   * @param treeNode
   * @param <T>
   * @return
   */
  public static final <T> T convert(TreeNode<T> treeNode) {
    T tagData = treeNode.getData();
    List<T> childData = new ArrayList<>();
    List<TreeNode<T>> childNode = treeNode.getChildes();
    if (CollectionUtils.isEmpty(childNode)) {
      return tagData;
    }
    for (TreeNode<T> tTreeNode : childNode) {
      childData.add(convert(tTreeNode));
    }
    try {
      BeanUtils.setProperty(tagData, CHILDREN_FILED, childData);
    } catch (IllegalAccessException e) {
      throw new RuntimeException(e);
    } catch (InvocationTargetException e) {
      throw new RuntimeException(e);
    }
    return tagData;
  }

  protected static <T> void check(T t) {
    //判断对象是否有属性
    Field field = FieldUtils.getDeclaredField(t.getClass(), "children", true);
    Assert.notNull(field != null & field.getType().isAssignableFrom(List.class), t.getClass().getName() + "必须含有一个属性名称为children并且类型为List的");
    //判断泛型类型是否是本身对象
    Type type = field.getGenericType();
    ParameterizedType paramType = (ParameterizedType) type;
    Type[] actualTypes = paramType.getActualTypeArguments();
    Assert.isTrue(actualTypes.length == 1, t.getClass().getName() + "属性名称为children型为List的泛型参数过长");
    Assert.isTrue(((Class) actualTypes[0]).isAssignableFrom(t.getClass()), "List泛型必须是" + t.getClass().getName());
  }

  /**
   * 转换指定节点的子节点
   *
   * @param treeNode
   * @param <T>
   * @return
   */
  public static final <T> List<T> convertChildes(TreeNode<T> treeNode) {
    List<T> elementTreeNodes = new ArrayList<>();
    List<TreeNode<T>> treeNodes = treeNode.getChildes();
    if (CollectionUtils.isEmpty(treeNodes)) {
      return elementTreeNodes;
    }
    for (TreeNode<T> node : treeNodes) {
      elementTreeNodes.add(convert(node));
    }
    return elementTreeNodes;
  }

  protected static <T> List<T> getchildesData(TreeNode<T> treeNode) {
    T t = treeNode.getData();
    List<T> childesData = new ArrayList<>();
    List<TreeNode<T>> childes = treeNode.getChildes();
    if (!CollectionUtils.isEmpty(childes)) {
      T tag = null;
      for (TreeNode<T> child : childes) {
        childesData.add(child.getData());
      }
    }
    return childesData;
  }

}
