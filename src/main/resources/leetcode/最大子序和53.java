package com.algorithm.leetcode;

public class 最大子序和53 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[]= {-1,0,-2};
		System.out.println(maxSubArray(a));
	}
	 public static int maxSubArray(int[] nums) {
	        if(nums.length==1){
	            return nums[0];
	        }else if(nums.length==2){
	            if(nums[0]>0&&nums[1]>0){
	                return nums[0]+nums[1];
	            }else{
	                return Math.max(nums[0],nums[1]);
	            }
	        }
	        else{
	        int res=-999999,n=0;
	        for(int i=0;i<nums.length;i++){
	            n=nums[i];
	           
	            for(int j=i+1;j<nums.length;j++){
	            	  if(res<n){
		                    res=n;
		                }
	                n+=nums[j];
	              
	            }
	              if(res<n){
	                    res=n;
	                }
	            n=0;
	        }
	        return res;
	      }
	        
	    }
}
