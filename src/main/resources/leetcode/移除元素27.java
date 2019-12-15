package com.algorithm.leetcode;
/**
 * 双指针
 * @author 李正阳
 *
 */
public class 移除元素27 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a={0,1,2,2,3,0,4,2};
		System.out.println(	removeElement(a, 2));
	}
//	public static int removeElement(int[] nums, int val) {
//		 StringBuilder a=new StringBuilder();
//		 for(int i=0;i<nums.length;i++) {
//			 a.append(nums[i]);
//		 }
//		 for(int i=0;i<a.length();i++) {
//			 if(Integer.parseInt(String.valueOf(a.charAt(i)))==val) {
//				 a.deleteCharAt(i);	 
//			}
//		 }
//		 System.out.println(a.length());
//		 for(int i=0;i<a.length();i++) {
//			 nums[i]=Integer.parseInt(String.valueOf(a.charAt(i)));
//		 }
//		 return nums.length;
//	}
	 public static int removeElement(int[] nums, int val) {
		 int n=0;
		 for(int i:nums) {
			 if(i==val) {
				 n++;
			 }
		 }
		 if(n==0) {
			 return nums.length;
			 
		 }
	        int slow=0;
	        int fast=1;
	        int temp;
	        while(fast<nums.length) {
	        	if(nums[slow]==val) {
	        		
	        		while(nums[slow]==nums[fast] ) {
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
	        		fast++;
	        		slow++;
	        		
	        	}else {
	        		if(fast>=nums.length) {
	        			break;
	        		}
	        		fast++;
	        		slow++;
	        	}
	        }
	        for(int i:nums) {
	        	System.out.println(i);
	        }
	        
	        return slow+1;
	 }

}
