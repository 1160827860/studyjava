package com.algorithm.leetcode;

public class ÍĞÆÕÀû´Ä¾ØÕó766 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public boolean isToeplitzMatrix(int[][] matrix) {
			boolean index = true;
	        for(int i = 0;i < matrix.length;i++) {
	        	for(int j = 0 ;j < matrix[0].length;j++) {
	        		if(i + 1 < matrix.length&&j + 1 <  matrix[0].length) {
	        			if(matrix[i][j] != matrix[i + 1][j + 1]) {
	        				index = false;
	        				break;
	        			}
	        		}
	        	}
	        }
	        return index;
	}
}
