package com.algorithm.leetcode;

public class 盛最多水的容器11 {

	public static void main(String[] args) {
		int[] a={2,3,4,5,18,17,6};
		// TODO Auto-generated method stub
		System.out.println(maxArea(a));
	}
	 public static int maxArea(int[] height) {
	        int are=0;
	        for(int i=0;i<height.length;i++){
	            for(int j=i+1;j<height.length;j++){
	                if(height[i]<height[j]){
	                    if(are<height[i]*(j-i)){
	                        are=height[i]*(j-i);
	                    }
	                }else{
	                    if(are<height[i]*(j-i)){
	                        are=height[j]*(j-i);
	                    }
	            }
	        }
	    }
	        return are;
	    }

}
