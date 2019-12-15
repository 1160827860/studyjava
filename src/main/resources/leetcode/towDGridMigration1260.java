package com.algorithm.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class towDGridMigration1260 {
    public static void main(String[] args) {

    }
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        LinkedList<Integer> temp = new LinkedList();
        for(int [] i:grid){
            for(int j : i){
                temp.add(j);
            }
        }
        for(int i = 0;i < k; i++){
           temp.addFirst(temp.removeLast());
        }
        for(int i = 0; i < grid.length; i++){
            ArrayList<Integer> temp1 = new ArrayList<Integer>();
            for (int j = 0;j < grid[0].length ;j++){
                temp1.add( temp.removeFirst());
            }
            res.add(temp1);
        }
        return res;
    }
}
