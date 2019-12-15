package com.algorithm.leetcode;

public class ת�þ���867 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[][] A = {{1,2,3},{4,5,6},{7,8,9}};
		int[][] A = {{1,2,3},{4,5,6}};
		
		
		transpose(A);
	}
	 public static int[][] transpose(int[][] A) {
	        int res[][] = new int[A[0].length][A.length];
	     
	        ArrayDeque<Integer> temp1 =new ArrayDeque<Integer>();
	        
	        for(int i = 0 ;i< A[0].length;i++) {
	        	for(int j = 0;j<A.length;j++) {
	        		temp1.add( A[j][i]);
	        	}
	        }
	        for(int i = 0 ;i < A[0].length;i++) {
	        	for(int j = 0 ;j < A.length ;j++) {
	        		A[i][j] = temp1.removeFirst();
	        	}
	        }
	        return res;
	    }
}
