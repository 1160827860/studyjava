package com.algorithm.leetcode;

public class �ƶ���283 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums= {2,1};
		moveZeroes(nums);
	}
	 public static void moveZeroes(int[] nums) {
	        int slow=0,fast=1,temp;
	        while(fast<nums.length) {
	        	
	        	if(nums[slow]==0) {
	        		
	        		while(nums[fast]==0) {
	        			
	        			fast++;
	        			if(fast>=nums.length) {
	        				break;
	        			}
	        		}
	        		if(fast>=nums.length) {
        				break;
        			}
	        		temp=nums[slow];
	        		nums[slow]=nums[fast];
	        		nums[fast]=temp;
	        		slow++;
	        		fast++;
	        	}else {
	        		slow++;
	        		fast++;
	        		
	        	}
	        	
	        }
	        Arrays.sort(nums,0,slow);
	 }
}
