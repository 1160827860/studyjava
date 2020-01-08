package com.darksouls.datastructure.my.study.List;

import java.util.*;
import java.util.ArrayList;
import java.util.function.Consumer;

/**
 * 链表
 * @param <E>
 */
public class LinkedList<E> implements List<E>  {
    //链表中元素格式
    public int size = 0;
    //头节点
    private Node head;
    //尾节点
    private Node tail;
    public int getSize(){
        return size;
    }
    /**
     * 向链表中插入元素
     * @param e 所要添加的对象
     */
    @Override
    public void add(E e) {
        //如果头节点为null就代表链表是空的，否则就在链尾加入元素
        if(head == null){
            head = new Node(e);
            tail = head;
        }else {
            tail.setNext(new Node(tail,e));
            tail = tail.getNext();
        }
        size ++;
    }

    /**
     * 在某个位置插入元素e
     *
     * @param index 位置
     * @param e     所要插入的元素
     */
    @Override
    public void add(int index, E e) {
        Node temp = head;
    }


    /**
     * 头插法
     * @param e 所要插入的对象
     */
    @Override
    public void addFirst(E e) {
        Node temp = new Node(e);
        head.setPre(temp);
        temp.setNext(head);
        head = temp;
        size ++;
    }

    /**
     * 尾插法
     *
     * @param e 所要插入的元素
     */
    @Override
    public void addLast(E e) {
        Node temp = new Node(tail,null,e);
        tail.setNext(temp);
        tail = temp;
    }

    /**
     * 从节点删除e
     *
     * @param e 待删除的节点
     */
    @Override
    public E remove(E e) {
        Node temp = null;
        Node pre;
        Node next;
        if(head.getElement().equals(e)){
            return removeFirst();
        }else if(tail.getElement().equals(e)){
            return removeLast();
        }else {
            for (int i = 0; i < size ; i++) {
                if(i ==0){
                    temp = head;
                }else {
                    temp = temp.getNext();
                }
                if(get(i).equals(e)){
                    if(i == 0){
                        return removeFirst();
                    }else if(i == size -1){
                        return removeLast();
                    }else {
                        size --;
                        pre = temp.getPre();
                        next = temp.getNext();
                        pre.setNext(next);
                        next.setPre(pre);
                        return (E) temp.getElement();
                    }
                }
            }

        }
        return null;
    }

    /**
     * 删除尾节点
     */
    @Override
    public E removeLast()  {
        Node temp = tail;
        if(size == 0){
            try {
                throw new  Exception("链表为空无法删除");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else if (size == 1){
            tail = head = null;
        }else {
            temp = tail;
            tail.getPre().setNext(null);
            tail = tail.getPre();
        }
        size --;
        return (E) temp.getElement();
    }


    /**
     * 获得在i位置上的E
     *
     * @param n 指定位置
     * @return 节点中存储的对象
     */
    @Override
    public E get(int n) {
        Node temp = head;
        for (int i = 0; i < n; i++) {
            temp = temp.getNext();
        }
        return (E) temp.getElement();
    }

    /**
     * 删除头节点
     * @return 头节点的值
     */
    @Override
    public E removeFirst() {
        Node temp = head;
        if(size == 0){
            try {
                throw new Exception("链表为空不能删除");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else if(size ==1){
            head = tail = null;
        }else {
            head = head.getNext();
            head.setPre(null);
        }
        size --;
        return (E) temp.getElement();
    }

    /**
     * 设置idx位置的元素
     * @param idx 替换idx个
     * @param e 替换i
     */
    @Override
    public void set(int idx, E e) {
        Node temp = head;
        for (int i = 0; i < idx; i++) {
            temp = temp.getNext();
        }
        temp.setElement(e);
    }

    @Override
    public void clear() {
        Node temp = head;
        while (temp != null){
            temp.setElement(null);
            temp.setNext(null);
            temp.setPre(null);
            temp = temp.getNext();
        }
        head = tail = null;
        size = 0;
    }

    /**
     * 检索元素位置
     *
     * @param e 需要检索的位置
     * @return 在表中的位置
     */
    @Override
    public int indexOf(E e) {
        Node temp = head;
        int res = 0;
        while (temp != null){
            if(temp.getElement().equals(e)){
                return res;
            }
            temp = temp.getNext();
            res ++;
        }
        res = -1;
        return res;
    }

    /**
     * 检查是不是已经为空
     *
     * @return
     */
    @Override
    public boolean isEmpty() {
        if(size == 0){
            return true;
        }else {
            return false;
        }
    }

    /**
     *转化为字符串
     * @return 将值转换为字符串
     */
    @Override
    public String toString(){
       StringBuilder st = new StringBuilder();
        for (int i = 0; i < size; i++) {
            st.append("[" + get(i)+"],");
        }
        return st.toString();
    }

    @Override
    public Iterator<E> iterator() {
        return new Itr();
    }

    @Override
    public void forEach(Consumer<? super E> action) {

    }

    @Override
    public Spliterator<E> spliterator() {
        return null;
    }

    /**
     * 实现迭代器
     */
    private class Itr implements Iterator<E>{
        int count  = -1;
        int modfiyCount = 0;
        @Override
        public boolean hasNext() {
            if(count < size &size !=0){
                return true;
            }else {
                return false;
            }
        }

        @Override
        public E next() {
            modfiyCount = 0;
            E temp = get(count);
            count ++;
            return temp;
        }

        @Override
        public void remove() {
            if(modfiyCount  == 0){
                modfiyCount ++;
                LinkedList.this.remove(get(count));
                count --;
            }else {
                try {
                    throw new Exception("不能调用两次");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        //jdk1.8和foreach实现有关
        @Override
        public void forEachRemaining(Consumer<? super E> action) {

        }
    }

    /**
     * 内部节点
     * @param <E> 泛型
     */
    private static class Node<E>{
        Node<E> pre;
        Node<E> next;
        E element;

        public Node<E> getPre() {
            return pre;
        }

        public void setPre(Node<E> pre) {
            this.pre = pre;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }

        public E getElement() {
            return element;
        }

        public void setElement(E element) {
            this.element = element;
        }

        public Node(E element) {
            this.element = element;
        }

        public Node(Node<E> pre, E element) {
            this.pre = pre;
            this.element = element;
        }

        public Node(Node<E> pre, Node<E> next, E element) {
            this.pre = pre;
            this.next = next;
            this.element = element;
        }
    }

    public static void main(String[] args) {
        LinkedList<String> res = new LinkedList<>();
        java.util.LinkedList addd = new java.util.LinkedList();
        addd.clear();
        ArrayList addt = new ArrayList();
        addt.clear();
        res.add("ttttt");
        res.add("asf");
        res.removeLast();
        res.add("sfsdcx");
        res.addFirst("charu1");
        res.addFirst("charu12");
        System.out.println(res.toString());
        //值传递
        Integer a ;
        Integer p;
        a = 10;
        p = a;
        a =50;
        System.out.println(p);
        System.out.println(a);
        //
        String ad = "HELLO";
        String add = ad;
        ad += "IS COLL";
        System.out.println(ad);
        System.out.println(add);
        //引用传递
        Node<Integer> ap = new Node<Integer>(10);
        Node<Integer> app = ap;
        Node<Integer> appp = new Node<Integer>(20);
        appp = ap;
        ap.setElement(50);
        System.out.println(ap.getElement());
        System.out.println(app.getElement());
        System.out.println(appp.getElement());
        Iterator<String> Itr = res.iterator();
        while (Itr.hasNext()){
            System.out.println(Itr.next());
            Itr.remove();
        }
        int[] ppp=new  int[10];
        System.out.println(ppp.length);
    }
}
