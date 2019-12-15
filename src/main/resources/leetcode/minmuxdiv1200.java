package com.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class minmuxdiv1200 {
    public static void main(String[] args) {

    }
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Arrays.sort(arr);
        int min = Integer.MAX_VALUE;
        for(int i = arr.length - 1;i > 0 ;i--){
            int temp = arr[i] - arr[i -1];
            min = Math.min(temp,min);
        }
        for(int i = 0; i < arr.length - 1;i++){
            int temp = arr[i + 1] - arr[i ];
            if(temp == min){
                List<Integer> res1 = new ArrayList<Integer>();
                res1.add(arr[i]);
                res1.add(arr[i + 1]);
                res.add(res1);
            }
        }



        return res;
    }
}
