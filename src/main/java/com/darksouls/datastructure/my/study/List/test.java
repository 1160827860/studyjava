package com.darksouls.datastructure.my.study.List;

import com.sun.glass.ui.Size;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.swing.text.html.HTMLDocument;
import java.security.Signature;
import java.util.ArrayList;
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
  public void test11(){
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
   */
  @Test
  public void test12(){
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
   * 链表反转：利用递归
   */
  @Test
  public void test13(){
    LinkedList<Integer> c = new LinkedList<>();
    go(0,a.size,c);
    System.out.println(c.toString());
  }
  public static void go(int n,int size,LinkedList<Integer> c){
    if(n == size){
      return;
    }
    go(n + 1,size,c);
    c.add(a.get(n));
    return;
  }

  /**
   * 链表检查是否出现循环（只能检查是否出现重复）
   * 哈希表法,一直读取，出现重复自然size不足
   *如果是基本类型可能会出现错误,如果是对象就可以用这个方法。
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
    res.add(a);
    System.out.println(res.size());
    int aa= 10;
    int bb = 10;
    HashSet<Integer> t = new HashSet<>();
    t.add(aa);
    t.add(bb);
    System.out.println(t.size());
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
  public void test21(){
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

  /**
   * 牛客网
   * 利用搜索的方法来进行去除重复
   *pre是最后一个不重复的元素
   * 利用next对后面的元素进行搜索发现一样的对象就删除
   * 1->2->3->3->4->4->5
   * 代码写的太罗嗦了
   */
  @Test
  public void test22(){
    ListNode pHead = new ListNode(1);
    ListNode t = new ListNode(2);
    pHead.next = t;
    t.next  = new ListNode(3);
    t = t.next;
    t.next  = new ListNode(3);
    t = t.next;
    t.next  = new ListNode(4);
    t = t.next;
    t.next  = new ListNode(4);
    t = t.next;
    ListNode temp = pHead;
    ListNode tt = pHead;
    boolean index = false;
    ListNode res = null;
    ListNode p = null;
    while (temp != null){
      while (tt != null){
        if(tt.val == temp.val && !tt.equals(temp)){
          index = true;
          break;
        }
        tt = tt.next;
      }
      if(!index){
        if(res ==null){
          res = new ListNode(temp.val);
        }else if(res.next == null){
          p = new ListNode(temp.val);
          res.next = p;
        }else {
          p.next = new ListNode(temp.val);
          p = p.next;
        }
      }
      tt = pHead;
      index = false;
      temp = temp.next;
    }
  }


}
