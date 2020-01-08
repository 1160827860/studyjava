package com.darksouls.datastructure.my.study.List;

import java.lang.annotation.ElementType;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * 动态增长数组
 * @param <E> 泛型
 */
public class ArrayList<E> implements List<E> {
    //链表中元素数量
    public int size = 0;
    //存储元素的数组
    private E[] element;
    //初始化数组容量
    final private int INIT_ARRAY_LENGTH = 10;
    //目前可存储的容量
    int captatiy = 0;

    public ArrayList() {
        //初始化动态数组
        element = (E[]) new Object[INIT_ARRAY_LENGTH];
        captatiy = INIT_ARRAY_LENGTH;
    }
    /**
     * 向链表中插入
     *向最后插入
     * @param e 所要添加的对象
     */
    @Override
    public void add(E e) {
        //先让链表中存的元素个数加一
        size ++;
        //检测是否超过链表的存储上限，超过就扩容
        checkCaptatiy();
        //将元素添加到链尾
        element[size - 1] = e;
    }

    /**
     * 在某个位置插入元素e
     *
     * @param index 位置
     * @param e     所要插入的元素
     */
    @Override
    public void add(int index, E e) {
        size ++;
        checkCaptatiy();
        //temp存储的是添加位置之后的全部元素
        E[] temp = Arrays.copyOfRange(element,index,size);
        //在这个位置插入元素
        element[index] = e;
        //将之前保存的元素添加进来
        for (int i = 0; i < temp.length; i++) {
            element[index] =temp[i];
            index ++;
        }
    }


    private void checkCaptatiy(){
        //如果总容量小于存储元素的数量就扩容
        if(captatiy < size) {
            remalloc();
        }
    }
    /**
     *申请内存
     */
    private void remalloc(){
        //对链表进行扩容
        element = Arrays.copyOf(element,size + INIT_ARRAY_LENGTH);
        captatiy =size +INIT_ARRAY_LENGTH;
    }

    /**
     * 头插法
     *
     * @param e 所要插入的对象
     */
    @Override
    public void addFirst(E e) {
        //先让链表中存的元素个数加一
        size ++;
        //检查是否应该扩容
        checkCaptatiy();
        //将目前的元素拷贝到零时表中
        E[] temp = Arrays.copyOf(element,size);
        //然后将链首元素赋值
        element[0] = e;
        //将零时表中元素放回element表中
        for (int i = 1; i < temp.length; i++) {
            element[i] = temp[i - 1];
            temp[i - 1] = null;
        }
    }

    /**
     * 尾插法
     *
     * @param e 所要插入的元素
     */
    @Override
    public void addLast(E e) {
        size ++;
        checkCaptatiy();
        //在最后插入元素
        element[size - 1] = e;
    }

    /**
     * 从节点删除e
     *
     * @param e 待删除的节点
     */
    @Override
    public E remove(E e) {
        //pre存储在这个节点之前的所有元素
        E[] pre = null;
        //next存储在这个结点之后的所有元素
        E[] next = null;
        //保存要删除节点的位置
        int n = -1;
        //保存要删除的节点的值
        E res = null;
        //寻找要删除节点的位置
        for (int i = 0; i < size; i++) {
            //寻找这个节点在表中的位置
            if(element[i].equals(e)){
                //pre保存结点之前的所有元素
                 pre = (E[]) Arrays.copyOfRange(element,0,i);
                 //next保存节点之后的所有元素
                 next = (E[]) Arrays.copyOfRange(element,i+1,size);
                 //保存所删除节点的位置的值
                 n = i;
                 res = element[i];
            }
        }
        clear();
        //将删除节点前面的元素插入表中
        for (int i = 0; i < pre.length; i++) {
            element[i] = pre[i];
        }
        //将删除节点之后的元素插入表中
        for (int i = 0; i < next.length; i++) {
            element[n] = next[i];
        }
        size = pre.length + next.length;
        return res;
    }

    /**
     * 删除尾节点
     */
    @Override
    public E removeLast() throws Exception {
        E res = null;
        //保存尾节点的值
        res = element[size - 1];
        //删除尾节点
        element[size-1] = null;
        //让所存元素数量减一
        size --;
        return res;
    }

    /**
     * 获得在i位置上的E
     *
     * @param i 指定位置
     * @return 节点中存储的对象
     */
    @Override
    public E get(int i) {
        //获取越界就报错
        if(i > size || i < 0){
            throw new IndexOutOfBoundsException();
        }
        return element[i];
    }

    /**
     * 删除头节点
     *
     * @return 头节点的值
     */
    @Override
    public E removeFirst() {
        int count = size;
        //保存头节点
        E res = element[0];
        clear();
        //头节点之后的所有值保存在element中
        element = Arrays.copyOfRange(element,1,element.length);
        size = --count;
        return  res;
    }

    /**
     * 设置某个位置
     *
     * @param idx
     * @param e
     */
    @Override
    public void set(int idx, E e) {
        element[idx] = e;
    }

    /**
     * 清除表中所有元素
     */
    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            element[i] = null;
        }
        size = 0;
    }

    /**
     * 检索元素位置
     *
     * @param e 所要检索的元素
     * @return 在表中的位置
     */
    @Override
    public int indexOf(E e) {
        for (int i = 0; i < size; i++) {
            if(element[i].equals(e)){
                return i;
            }
        }
        return -1;
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

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public void forEach(Consumer<? super E> action) {

    }

    @Override
    public Spliterator<E> spliterator() {
        return null;
    }

    /**
     * 迭代器实现类
     */
    private class Itr implements Iterator{
        int count = -1;
        @Override
        public boolean hasNext() {
            if(count < size && size >=0 ){
                return true;
            }else {
                return false;
            }
        }

        @Override
        public Object next() {
            count ++;
            return get(count);
        }

        @Override
        public void remove() {
            ArrayList.this.remove(get(count));
        }
        @Override
        public void forEachRemaining(Consumer action) {

        }
    }
}
