package com.darksouls.datastructure.my.study.tree;

import java.lang.annotation.ElementType;
import java.util.AbstractList;
import java.util.LinkedList;

public class BinarySearchTree<E extends Comparable<? super E> >implements tree<E> {
    private BinaryNode<E> root = null;
    private static class BinaryNode<E>{
        E element;
        BinaryNode<E> left;
        BinaryNode<E> right;
        int count ;
        public BinaryNode(E element, BinaryNode<E> left, BinaryNode<E> right) {
            this.element = element;
            this.left = left;
            this.right = right;
            count = 0;
        }

        public BinaryNode(E element) {
            this.element = element;
            count = 0;
        }
    }
    /**
     * 使树为空
     */
    @Override
    public void makeEmpety() {
        root = null;
    }

    /**
     * 检查树是否为空
     *
     * @return true 空
     */
    @Override
    public boolean isEmpty() {
        return root == null;
    }

    /**
     * 检查节点是否包含e这个元素
     *
     * @param e
     */
    @Override
    public boolean contains(E e) {
        return contains(e,root);
    }

    /**
     * 找到树中的最小值
     */
    @Override
    public E findMin() {
        return findMin(root);
    }
    private E findMin(BinaryNode<E> e){
        if(e.left == null && e.count != 0){
            return e.element;
        }else if(e == null) {
            return null;
        }
        return findMax(e.left);
    }
    /**
     * 找到树中的最大值
     *
     * @return
     */
    @Override
    public E findMax() {
        return findMax(root);
    }
    private E findMax(BinaryNode<E> e){
        if(e.right == null && e.count != 0){
            return e.element;
        }else if(e == null) {
            return null;
        }
        return findMax(e.right);
    }
    /**
     * 向树中插入元素
     *
     * @param x 所插入的元素
     */
    @Override
    public void insert(E x) {
        root = insert(x,root);
    }
    private BinaryNode<E> insert(E x,BinaryNode<E> t){
        if(t == null){
            return new BinaryNode<>(x,null,null);
        }
        int compareResult = x.compareTo(t.element);
        if(compareResult > 0 ){
            t.right = insert(x,t.right);
        }else if(compareResult < 0){
            t.left = insert(x,t.left);
        }else {
            t.count ++;
        }
        return t;
    }

    /**
     * 删除数中的某个元素
     *
     * @param x 所要删除的元素
     */
    @Override
    public E remove(E x) {
        return remove(x,root).element;
    }
    private BinaryNode<E> remove(E x,BinaryNode<E> t){
        if(t == null){
            return t;
        }
        int compareResult = x.compareTo(t.element);
        if(compareResult > 0){
            t.right  =  remove(x,t.right);
        }else if(compareResult < 0){
            t.left  =  remove(x,t.left);
        }else {
            if(t.count == 1){
                t.count --;
            }
        }
        return t;
    }

    /**
     * 输出所有数的元素
     * 根据前序遍历
     */
    @Override
    public void printTree() {
        printTree(root);
    }
    private void printTree (BinaryNode<E> t){
        if(t != null){
            printTree(t.left);
            printTree(t.right);
            System.out.println(t.element);

        }
    }

    /**
     * 查看是否包含
     * @param e
     * @param t
     * @return
     */
    private boolean contains(E e,BinaryNode<E> t){
        if(t == null){
            return false;
        }
        int  compareResult = e.compareTo(t.element);
        if(compareResult > 0){
            contains(e,t.right);
        }else if(compareResult < 0){
            contains(e,t.left);
        }else {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        BinarySearchTree t = new BinarySearchTree();
        t.insert(5);
        t.insert(4);
        t.insert(6);
        t.insert(2);
        t.insert(3  );
        t.printTree();
    }
}
