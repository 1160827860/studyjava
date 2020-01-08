package com.darksouls.datastructure.my.study.Stack;

import com.darksouls.datastructure.my.study.List.LinkedList;
import com.darksouls.datastructure.my.study.List.List;
import sun.dc.pr.PRError;

/**
 * 栈的实现可以用一张链表来实现，自然也可以用数组来实现
 * @param <E>
 */
public class Stack<E> implements Vector<E>{

    private LinkedList list = new LinkedList();

    /**
     * 入栈(入队）
     */
    @Override
    public void push(E e) {
        list.addLast(e);
    }

    /**
     * 出栈（出队）
     */
    @Override
    public E pop() {
        if(list.getSize() == 0){
            throw new NullPointerException();
        }else {
            try {
                return (E) list.removeLast();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /**
     * 测空
     *
     * @return true 空
     */
    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    /**
     * 获得栈顶元素
     *
     * @return
     */
    @Override
    public E getTop() {
        return (E) list.get(list.getSize() -1);
    }

    public static void main(String[] args) {
        int a = 1;
        int b = a;
        a = 10;
        System.out.println(a);
        System.out.println(b);
    }

}
