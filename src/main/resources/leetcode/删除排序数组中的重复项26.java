package com.algorithm.leetcode;
/**
 * 快慢指针
 * @author 李正阳
 *
 */
public class 删除排序数组中的重复项26 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a= {0,0,1,1,1,2,2,3,3,4};
		removeDuplicates(a);
		
	}
	 public static int  removeDuplicates(int[] nums) {
		 int slow=0;
		 int fast=1;
		 while(fast<nums.length) {
			 if(nums[slow]==nums[fast]) {
				 fast++;
			 }else {
				 nums[slow+1]=nums[fast];
				 slow++;
				 fast++;
			 }
		 }
		
		 return slow+1;
	 }
}
