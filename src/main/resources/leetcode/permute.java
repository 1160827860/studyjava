package com.algorithm.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * 全排列问题
 * leetcode中的全局变量需要重新初始化一下，才能清空
 */
public class permute {
    static  List<List<Integer>> res = new LinkedList<List<Integer>>();
    static LinkedList<Integer> builder = new LinkedList<Integer>();
    public static List<List<Integer>> permute(int[] nums) {
        res.clear();
        builder.clear();
        boolean[] arrsb = new boolean[nums.length];
        for(int i = 0;i < nums.length;i++){
            sort(i,nums,arrsb);
        }

        return res;
    }
    public static void sort(int index ,int[] arrs,boolean[] arrsb){
        builder.addLast(arrs[index]);
        arrsb[index] = true;
        for(int j = 0; j < arrs.length ;j++){
            if(arrsb[j] == false){
                sort(j,arrs,arrsb);
            }
        }
        if(builder.size() == arrs.length){
            LinkedList temp = (LinkedList) builder.clone();
            res.add(temp);
            builder.remove(builder.size() - 1);
            arrsb[index] = false;
            return;
        }
        builder.remove(builder.size() - 1);
        arrsb[index] = false;
        return;

    }

    public static void main(String[] args) {
        permute(new int[]{1});
    }
}
