package com.darksouls.datastructure.my.study.Stack;

public interface Vector<E> {
    /**
     * 入栈(入队）
     */
    void push(E e);

    /**
     * 出栈（出队）
     */
    E pop();

    /**
     * 测空
     * @return true 空
     */
    boolean isEmpty();

    /**
     * 获得栈顶元素
     * @return E 类型的对象
     */
    E getTop();

}
