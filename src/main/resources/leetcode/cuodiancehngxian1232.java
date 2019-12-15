package com.algorithm.leetcode;

public class cuodiancehngxian1232 {
    public static void main(String[] args) {
        checkStraightLine(new int[][]{{1,1},{2,2},{3,4},{4,5},{5,6},{7,7}});
//        checkStraightLine(new int[][]{{-7,-3},{-7,-1},{-2,-2},{0,-8},{2,-2},{5,-6},{5,-5},{1,7}});
    }

    public static boolean checkStraightLine(int[][] coordinates) {
        int index = 0;
        for(int i = 0;i <coordinates.length - 1;i++){
            if(coordinates[i][0] != coordinates[i + 1] [0]){
                index ++;
            }
        }
        index ++;
        if(index == coordinates.length){
            int temp = (coordinates[1][1] - coordinates[0][1] );
            int temp1 = (coordinates[1][0] - coordinates[0][0]);
            int k =temp / temp1;
            int b = coordinates[0][1] - k*coordinates[0][0];
            for(int i = 2;i < coordinates.length;i++){
                if(k * coordinates[i][0] + b != coordinates[i][1]){
                    return false;
                }
            }
            return true;
        }else {
            if(index ==0){
                return true;
            }else {
                return false;
            }

        }

    }

}
