package com.darksouls.datastructure.leetcode.Stack;

import com.sun.javafx.image.impl.IntArgb;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.omg.PortableInterceptor.INACTIVE;

import java.sql.ResultSet;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Stack {
    /**
     * 删除字符串中的所有相邻重复项
     */

//    @Test
//    public String q1047(String s){
//        char[] p = s.toCharArray();
//        java.util.Stack<Character> a =new java.util.Stack<>();
//        java.util.Stack<Character> b =new java.util.Stack<>();
//        for(char i : p){
//            a.push(i);
//        }
//        while ()
//    }

    /**
     * 棒球比赛算积分
     * @param ops
     * @return
     * 输入："abbaca"
     * 输出："ca"
     * 解释：
     * 例如，在 "abbaca" 中，我们可以删除 "bb" 由于两字母相邻且相同，这是此时唯一可以执行删除操作的重复项。之后我们得到字符串 "aaca"，其中又只有 "aa" 可以执行重复项删除操作，所以最后的字符串为 "ca"。
     */
      @Test
   public int q682(String[] ops){
          java.util.LinkedList<String> a = new java.util.LinkedList<>();
          int res = 0;
          for(String i : ops){
              if(i.equals("+")){
                  a.add(String.valueOf(Integer.parseInt(a.get(a.size() - 1)) + Integer.parseInt(a.get(a.size() - 2))));
              }else if(i.equals("D")){
                  a.add(String.valueOf(Integer.parseInt(a.get(a.size() - 1))*2));
              }else if(i.equals("C")){
                  a.removeLast();
              }else {
                 a.add(i);
              }
          }
          for(String t : a){
              res += Integer.parseInt(t);
          }
          return res;
      }

    /**
     * 输入: nums1 = [2,4], nums2 = [1,2,3,4].
     * 输出: [3,-1]
     * 解释:
     *     对于num1中的数字2，第二个数组中的下一个较大数字是3。
     *     对于num1中的数字4，第二个数组中没有下一个更大的数字，因此输出 -1。
     * @return
     */
    @Test
    public int[] q496(int[] nums1, int[] nums2){
        boolean index = false;
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            int indexj = -1;
            for (int j = 0; j < nums2.length; j++) {
                if(nums1[i] == nums2[j]){
                    indexj = j;
                }
            }
            for (int j = indexj; j < nums2.length; j++) {
                if(nums1[i] < nums2[j]){
                    index = true;
                    res[i] = nums2[j];
                    break;
                }
            }
            if(!index){
                res[i] = -1;
            }
            index = false;
        }
        return res;
    }
    @Test
    public String q1047(String S){
        java.util.Stack<Character> a = new java.util.Stack<>();
        char[] t = S.toCharArray();
        for(char i : t){
            if(a.size() != 0){
                if(a.peek().equals(i)){
                    a.pop();
                }else {
                    a.push(i);
                }
            }else {
                a.push(i);
            }
        }
        StringBuilder res = new StringBuilder();
        for(char i: a){
            res.append(i);
        }
        return res.toString();
    }
    @Test
    public Boolean q844(String S, String T){
        java.util.Stack<Character> a = new java.util.Stack<>();
        for (char i : S.toCharArray()){
            if(i == '#'){
                if(!a.isEmpty()){
                    a.pop();
                }
            }else {
                a.add(i);
            }
        }
        S = a.toString();
        a.clear();
        for (char i : T.toCharArray()){
            if(i == '#'){
                if(!a.isEmpty()){
                    a.pop();
                }
            }else {
                a.add(i);
            }
        }
        T = a.toString();
        if(S.equals(T)){
            return true;
        }else {
            return false;
        }
    }

    /**
     * 有一堆石头，每块石头的重量都是正整数。
     *
     * 每一回合，从中选出两块最重的石头，然后将它们一起粉碎。假设石头的重量分别为 x 和 y，且 x <= y。那么粉碎的可能结果如下：
     *
     * 如果 x == y，那么两块石头都会被完全粉碎；
     * 如果 x != y，那么重量为 x 的石头将会完全粉碎，而重量为 y 的石头新重量为 y-x。
     * 最后，最多只会剩下一块石头。返回此石头的重量。如果没有石头剩下，就返回 0。
     * @param stones
     * @return
     */
    @Test
    public int q1046(int[] stones){
        int weight = 0;
        for(int i=0;i<stones.length-1;i++){
            Arrays.sort(stones);
            weight = stones[stones.length-1] - stones[stones.length-2];
            stones[stones.length-2] = 0;
            stones[stones.length-1] = weight;
        }
        return stones[stones.length-1];
    }
}

/**
 * q232用栈实现队列
 */
class MyQueue {

    java.util.Stack<Integer> a ;
    java.util.Stack<Integer> b;
    /** Initialize your data structure here. */
    public MyQueue() {
        a = new java.util.Stack<>();
        b = new java.util.Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        a.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(b.size() == 0){
            while (a.size() !=0){
                b.add(a.pop());
            }
            return b.pop();
        }else {
            return b.pop();
        }
    }

    /** Get the front element. */
    public int peek() {
        if(b.size() == 0){
            while (a.size() !=0){
                b.add(a.pop());
            }
            return b.peek();
        }else {
            return b.peek();
        }
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        if(a.size() == 0 && b.size() == 0){
            return true;
        }else {
            return false;
        }
    }
}

/**
 * 用队列实现栈一个实现法
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
class MyStack {
    Queue<Integer> a;

    /** Initialize your data structure here. */
    public MyStack() {

        a = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        a.add(x);
        int size = a.size();
        while (size > 1){
            a.add(a.remove());
            size --;
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return a.remove();
    }

    /** Get the top element. */
    public int top() {
        return a.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return a.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */

/**
 * 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
 * push(x) -- 将元素 x 推入栈中。
 * pop() -- 删除栈顶的元素。
 * top() -- 获取栈顶元素。
 * getMin() -- 检索栈中的最小元素。
 */
class MinStack {
    java.util.Stack<Integer> a ;
    java.util.Stack<Integer> b;
    /** initialize your data structure here. */
    public MinStack() {
        a = new java.util.Stack<>();
        b = new java.util.Stack<>();
    }
    public void push(int x) {
        a.push(x);
        if(b.size() > 0){
            if(x <= b.peek()){
                b.push(x);
            }
        }else {
            b.push(x);
        }
    }

    public void pop() {
        if(a.peek() .equals( b.peek())){
            a.pop();
            b.pop();
        }else {
            a.pop();
        }
    }

    public int top() {
        return a.peek();
    }

    public int getMin() {
        return b.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */