package com.algorithm.leetcode;

public class ��С��ֵI908 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] A = {1,3,6};
//		int[] A = {0,10};
		int[] A = {2,7,2};
		System.out.println(smallestRangeI(A, 1));
	}
	 public static int smallestRangeI(int[] A, int K) {
		  	Arrays.sort(A);
		 	int res = Integer.MAX_VALUE;
	        if(A.length == 1) {
	        	return 0;
	        }else {
	        	for(int i = - K;i <=K;i++ ) {
	        		for(int j = - K;j <=K;j++ ) {
	        			int t = (A[A.length - 1] + i) -(A[0] + j);
		        		if(res > t&&t>= 0) {
		        			res = t;
		        		}
		        	}
	        	}
	        }
	        return res;
	    }

}
