package com.darksouls.datastructure.my.study.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.swing.text.html.HTMLDocument;
import java.security.Signature;
import java.util.HashSet;
import java.util.Iterator;

public class test {
  /**
   * 自己定义的链表
   */
  static LinkedList<Integer> a = new LinkedList<>();
  static {
    a.add(1);
    a.add(2);
    a.add(1);
    a.add(3);
    a.add(8);
  }
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
   * 反转链表，利用一个额外遍变量实现
   */
  @Test
  public void test1(){
      int temp;
      for(int i = 0 ,j = a.size - 1;i < a.size/2;i++,j--){
        temp = a.get(i);
        a.set(i,a.get(j));
        a.set(j,temp);
      }
      System.out.println(a.toString());
  }
  /**
   * 链表反转,采用暴力法
   * 还有一种应该是利用递归实现
   */
  @Test
  public void test2(){
    int[] b =new int[a.size];
    for (int i = 0; i < a.size; i++) {
      b[i] = a.get(i);
    }
    for (int i = b.length - 1,j = 0; i >= 0; i--,j++) {
        a.set(j,b[i]);
    }
    System.out.println(a.toString());
  }
  /**
   * 链表检查是否出现循环
   * 三种方法
   * 哈希表法,一直读取，出现重复自然size不足
   *反转指针法，反转指针，不能到头部就说明有循环
   *
   */
  @Test
  public void test3(){
    ListNode a = new ListNode(5);
    ListNode b = new ListNode(5);
    a.next = b;
    b.next = b;
    HashSet<ListNode> res = new HashSet<>();
    res.add(a);
    res.add(b);
    System.out.println(res.size());
  }

  /**
   * 返回链表倒数第n个节点
   */
  @Test
  public void test4(){
    int n = 2;
    System.out.println(a.get(a.size - n));
  }

  /**
   *删除链表中重复项
   * 使用hash表去重
   */
  @Test
  public void test5(){
    HashSet<Integer> b = new HashSet<>();
    for (int i = 0; i < a.size; i++) {
      b.add(a.get(i));
    }
    a.clear();
    Iterator<Integer> itr = b.iterator();
    while (itr.hasNext()){
      a.add(itr.next());
    }
    System.out.println(a.toString());
  }
  
}
