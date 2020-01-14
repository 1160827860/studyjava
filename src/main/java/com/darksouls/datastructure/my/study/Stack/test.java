package com.darksouls.datastructure.my.study.Stack;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 关于栈的一些题目
 */
public class test {
    /**
     * 牛客网给的链表，剑指offic里面
     */
    public class ListNode {
        int val;
        ListNode next = null;
        ListNode(int val) {
            this.val = val;
        }
    }
    /**
     * 例如两个栈实现队列
     * 牛客网上的已经实现了
     */
    @Test
    public void test1(){

    }
    /**
     * 实现滑动窗口实现找到每个窗口的最大值
     * 要注意size不能等于0或size大于num的长度
     */
    @Test
    public ArrayList test21(int []num,int size){
        if(size == 0 || size > num.length){
            return new ArrayList();
        }
        LinkedList<Integer> r = new LinkedList<>();
        ArrayList<Integer> res = new ArrayList<>();
        for(int i = 0; i < size;i++){
            r.add(num[i]);
        }
        int temp = Integer.MIN_VALUE;
        for (int i: r){
            if(i > temp){
                temp = i;
            }
        }
        res.add(temp);
        for(int i = size;i < num.length;i++){
            r.removeFirst();
            r.add(num[i]);
            temp = Integer.MIN_VALUE;
            for (int j: r){
                if(j > temp){
                    temp = j;
                }
            }
            res.add(temp);
        }
        return res;
    }
    /**
     * 平衡符号
     */
    @Test
    public void test31(){

    }
    /**
     * 后缀表达式
     */
    @Test
    public void test41(){

    }
    /**
     * 将中缀表达式
     */
    @Test
    public void test51(){

    }

}
