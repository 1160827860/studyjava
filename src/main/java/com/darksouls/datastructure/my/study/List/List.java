package com.darksouls.datastructure.my.study.List;

import java.util.Iterator;

public interface List<E> extends Iterable<E>{
    /**
     * 向链表中插入
     * @param e 所要添加的对象
     */
    void  add(E e);

    /**
     * 在某个位置插入元素e
     * @param index 位置
     * @param e 所要插入的元素
     */
    void add(int index,E e);
    /**
     * 头插法
     * @param e 所要插入的对象
     */
    void addFirst(E e);

    /**
     * 尾插法
     * @param e 所要插入的元素
     */
    void addLast(E e);

    /**
     * 从节点删除e
     * @param e 待删除的节点
     */
    E  remove(E e);

    /**
     * 删除尾节点
     */
    E removeLast() throws Exception;

    /**
     * 获得在i位置上的E
     * @param i 指定位置
     * @return 节点中存储的对象
     */
    E get(int i);

    /**
     * 删除头节点
     * @return 头节点的值
     */
    E removeFirst();

    /**
     * 设置某个位置
     * @param idx
     * @param e
     */
    void set(int idx,E e);

    /**
     * 删除数组中所有元素
     */
    void clear();

    /**
     * 检索元素位置
     * @param e
     * @return
     */
    int indexOf(E e);

    /**
     * 检查是不是已经为空
     * @return
     */
    boolean isEmpty();
}
