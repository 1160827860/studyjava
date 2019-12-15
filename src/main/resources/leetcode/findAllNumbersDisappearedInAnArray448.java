package com.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

public class findAllNumbersDisappearedInAnArray448 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	/**
	 * ��������
	 */
//    public List<Integer> findDisappearedNumbers(int[] nums) {
//	       List<Integer> arr =  new ArrayList<Integer>();
//	       for(int i = 1; i <= nums.length; i++){
//	       		arr.add(i);
//		   }
//		   for(Integer i : nums){
//		   		arr.remove(i);
//		   }
//		   return arr;
//	 }
	/**
	 * Ͱ���򷽷�
	 */
	public List<Integer> findDisappearedNumbers(int[] nums) {
		List<Integer> arr =  new ArrayList<Integer>(nums.length);
		for ( int i  = 0;i <=  nums.length;++i){
			/**
			 * ����һֱ����
			 */
			while (nums[nums[i] ] != nums[i]){
				nums[nums[i] ]  = nums[nums[i]]  ^ nums[i];
				nums[i] = nums[nums[i]]  ^ nums[i];
				nums[nums[i]]  = nums[nums[i]]  ^ nums[i];
			}
		}
		for(int i = 1;i  <= nums.length ; i++){
			if(nums[i - 1] != i){
				arr.add(i);
			}
		}
		return arr;
	}
}
