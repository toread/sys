package com.toread.sys.common.tree.convert.elementTree;

import java.util.List;

/**
 * @author 黎志兵
 */
public class ElementTreeNode<T> {
  private T data;
  private List<T> children;

  public T getData() {
    return data;
  }

  public void setData(T data) {
    this.data = data;
  }

  public List<T> getChildren() {
    return children;
  }

  public void setChildren(List<T> children) {
    this.children = children;
  }
}
