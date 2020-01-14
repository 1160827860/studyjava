package com.darksouls.datastructure.leetcode.List;


import com.sun.org.apache.bcel.internal.generic.NEW;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;

/**
 * leetcode上的链表题
 * 方法名字为leetcode上的题目的编号
 */
public class List {
    /**
     * leetcode上的标准链表
     */
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
     }
    /**
     * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
     * 输出：7 -> 0 -> 8
     * 原因：342 + 465 = 807
     * 先加存起来再用链表加入节点
     */
    @Test
    public ListNode q2(ListNode l1, ListNode l2){
        LinkedList<Integer> res = new LinkedList<>();
        while (l1 != null|| l2 != null) {
            int a;
            int b;
            if(l1 == null){
                a = 0;
            }else {
                 a = l1.val;
            }
            if(l2 ==null){
                b = 0;
            }else {
                 b = l2.val;
            }
            res.add(a + b);
            if(l1 != null){
                l1 = l1.next;
            }
            if(l2 !=null){
                l2 = l2.next;
            }


        }
        for (int i = 0; i < res.size(); i++) {
            if(res.get(i) >= 10 && i != res.size() - 1){
                res.set(i,res.get(i) % 10);
                res.set(i + 1,res.get(i + 1) + 1);
            }else if(res.get(i) >= 10 && i == res.size() - 1){
                res.add(1);
                res.set(i,res.get(i) % 10);
            }
        }
        ListNode res1 = null;
        ListNode temp = null;


        for(int i = 0;i < res.size();i++){
            if(i ==0){
                res1 = new ListNode(res.get(0));
            }else if (i == 1){
                temp = new ListNode(res.get(1));
                res1.next = temp;
            }else {
                temp.next =  new ListNode(res.get(i));
                temp = temp.next;
            }
        }
        return res1;
    }

    /**
     *  删除链表的倒数第N个节点
     *  给定一个链表: 1->2->3->4->5, 和 n = 2.
     *
     * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
     *递归解决
     *   if(go(head,n) != null){
     *             head =head.next;
     *         }
     *  核心设计，处理头和尾的有问题
     * @param head
     * @param n
     * @return
     */

    static int count = 0;
    @Test
    public ListNode q19(   ListNode head,int n){
//        count = 0;
//        head = new ListNode(1);
//        head.next = new ListNode(2);
        n = 1;
        ListNode p = null;
        ListNode temp = head;
        int size = 0;
        while (temp != null){
            size ++;
            temp = temp.next;
        }
        if(size == 1)
        {
            return p;
        }
//        if(size == 2 && n == 1){
//            head.next = null;
//            return head;
//        }else if(size == 2 && n == 2) {
//            head = head.next;
//            return head;
//        }
        if(go(head,n) != null){
            head =head.next;
        }
        return head;
    }
    public static ListNode go(ListNode temp,int n){
        ListNode t = null;
        if(temp == null){
            return null;
        }
        t = go(temp.next,n);
        if(t != null){
            temp.next = t.next;
        }
        count ++;
        if(count == n){
            return temp;
        }else {
            return null;
        }
    }

    /**
     *
     * 输入:
     * [
     *   1->4->5,
     *   1->3->4,
     *   2->6
     * ]
     * 输出: 1->1->2->3->4->4->5->6
     * @param l1
     * @param l2
     * @return
     */
    @Test
    public ListNode q21(ListNode l1, ListNode l2){
        if(l1 == null){
            return l2;
        }else if (l2 == null){
            return l1;
        }else if(l1.val > l2.val){
            l2.next = q21(l1,l2.next);
            return l2;
        }else {
            l1.next = q21(l1.next,l2);
            return l1;
        }
    }
    @Test
    public ListNode q23(ListNode[] lists){
        boolean index = false;
        for(ListNode temp : lists){
            if(temp != null){
                index = true;
            }
        }
        if(!index){
            return null;
        }
        ListNode t = new ListNode(Integer.MAX_VALUE);
        int i = 0;
        for(int j = 0 ;j< lists.length;j++){
            ListNode temp = lists[j];
            if(temp == null){

                continue;
            }
            if(temp.val < t.val){
                t = temp;
                i = j;
            }

        }
        if(lists[i] != null){
            lists[i] = lists[i].next;
        }
        t.next = q23(lists);
        return t;
    }

    /**
     * 83. 删除排序链表中的重复元素
     * 输入: 1->1->2
     * 输出: 1->2
     */
    @Test
    public ListNode q83(ListNode head){
        HashSet<Integer> a = new HashSet<>();
        while (head != null){
            a.add(head.val);
            head = head.next;
        }
        ListNode res = null;
        int count = 0;
        int num[] = new int[a.size()];
        for(int i:a){
            num[count] = i;
            count ++;
        }
        Arrays.sort(num);
        for (int i = 0; i < num.length; i++) {
            if(i == 0){
                res = new ListNode(num[i]);
            }else if (i == 1){
                head = new ListNode(num[i]);
                res.next = head;
            }else {
                head.next = new ListNode(num[i]);
                head  = head.next;
            }
        }
        return res;
    }
    /**
     * 24. 两两交换链表中的节点
     * 给定 1->2->3->4, 你应该返回 2->1->4->3.
     */
    @Test
    public ListNode q24(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
            ListNode temp = head;
            head = head.next;
            temp.next  = q24(head.next);
            head.next = temp;
            return head;
    }

    /**
     * 输入: 1->2->3->3->4->4->5
     * 输出: 1->2->5
     * 输入: 1->1->1->2->3
     * 输出: 2->3
     * 没做出来
     * @param head
     * @return
     */
    @Test
    public ListNode q82(ListNode head){
        ListNode res = new ListNode(-1);
        ListNode pre = head;
        ListNode next = null;
        ListNode temp = null;
        boolean index = false;
        while (pre.next != null){
            temp =pre;
            next = head;
            while (next != null){
                if(pre.val == next.val){
                    index =true;
                }
                next = next.next;
            }
            pre = pre.next;
            if(!index){
                if(res.next == null){
                    res.next = pre;
                    temp = pre;
                }else {
                    temp.next = temp;
                    temp = temp.next;
                }
            }
        }
        return res.next;
    }
    static int size = 0;
    static int c = 0;
    @Test
    public static ListNode q876(ListNode head){
        if(head.next == null && size == 0){
            return head;
        }
        if(head == null){
            return null;
        }
        size ++;
        c++;
        ListNode res = null;

         res = q876(head.next);
        if(res != null){
            return res;
        }
        c--;
        if(size % 2 == 0){
            size ++;
        }
        if(size / 2 == c){
            return head;
        }


        return null;
    }


    /**
     * 利用数组解决q876
     */
    class Solution {
        public ListNode middleNode(ListNode head) {
            ListNode[] A = new ListNode[100];
            int t = 0;
            while (head.next != null) {
                A[t++] = head;
                head = head.next;
            }
            return A[t / 2];
        }
    }

    /**
     * 查找两个链表的相交入口
     * @param headA
     * @param headB
     * @return
     */
    @Test
    public static ListNode q160(ListNode headA, ListNode headB){
        HashSet<ListNode> res = new HashSet<>();
        while (headA != null){
            res.add(headA);
            headA = headA.next;
        }
        while (headB!= null){
            if(!res.add(headB)){
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }

    /**
     * 倒置链表
     * @param head
     * @return
     */
    @Test
    public static ListNode q206(ListNode head){
        if (head == null || head.next == null){ return head;}
        ListNode p = q206(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }

    /**
     * 在链表中删除val
     * 递归
     * @param head
     * @param val
     * @return
     */
    @Test
    public static ListNode q203(ListNode head, int val){
        if(head == null ||head.next == null){
            if(head != null && head.val == val){
                head = null;
            }
            return head;
        }
        ListNode temp = q203(head.next,val);
        if(head.val == val){
            head = temp;
        }
        if (head != null){
            head.next = temp;
        }else{
            head = null;
        }

        return head;
    }

    /**
     * 检查有没有循环点
     * @param head
     * @param val
     * @return
     */
    @Test
    public static boolean q141(ListNode head, int val){
        HashSet<ListNode> res = new HashSet<>();
        while (head != null){
            if(!res.add(head)){
                return true;
            }
            head = head.next;
        }
        return false;
    }

    /**
     * 转换二进制
     * @param head
     * @return
     */
    @Test
    public static int q1290(ListNode head){
        StringBuilder res = new StringBuilder();
        while (head != null){
            res.append(head.val);
            head = head.next;
        }
        return Integer.parseInt(res.toString(),2);
    }



}
