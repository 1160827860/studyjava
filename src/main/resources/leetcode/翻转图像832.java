package com.algorithm.leetcode;

public class ·­×ªÍ¼Ïñ832 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int A[][] = {
				{1,1,0},{1,0,1},{0,0,0}
		};
		System.out.println(flipAndInvertImage(A));
	}
	  public static int[][] flipAndInvertImage(int[][] A) {
		  int l =0;
		  int k = 0;
	        for(int i = 0 ;i<A[0].length;i++) {
	        	k = A.length -1;
	        	for( int j = 0 ;j<A.length/2;j++) {
	        		A[i][j] = A[i][j]^A[i][k];
	        		A[i][k] =  A[i][j]^A[i][k];
	        		A[i][j] = A[i][j]^A[i][k];
	        		
	        		k--;
	        	}
	        	for(int j = 0 ;j<A.length ;j++) {
	        		A[i][j] = A[i][j] ^1;
	        	}
	        }
	        return A;
	    }
	 
}
