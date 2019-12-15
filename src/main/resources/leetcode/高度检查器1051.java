package com.algorithm.leetcode;

public class �߶ȼ����1051 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = {1,1,4,2,1,3};
		System.out.println(heightChecker(a));
	}
	  public static int heightChecker(int[] heights) {
		  	
	        int[] heights1 = Arrays.copyOf(heights, heights.length);
	        Arrays.sort(heights);
	        int res = 0;
	        for(int i = 0; i<heights1.length;i++) {
	        	if((heights[i]^heights1[i])!=0) {
	        		res++;
	        	}
	        }
	        return res;
	        
	    }
}
