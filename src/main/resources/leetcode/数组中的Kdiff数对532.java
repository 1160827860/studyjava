package com.algorithm.leetcode;//package com.algorithm.leetcode;
//
//import java.util.Arrays;
//import java.util.HashSet;
//import java.util.Set;
//
//public class �����е�Kdiff����532 {
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		int a[]= {1,3,1,5,4};
//		findPairs(a, 0);
//	}
//	   public static int findPairs(int[] nums, int k) {
//		   int n=0;
//
////	        return n;
//		   if(k==0) {
//			   for(int i=0;i<nums.length-1;i++) {
//				   if(Arrays.binarySearch(nums,nums[i],nums.length,i+1)>0) {
//					   n++;
//				   }
//			  }
//
//			   return n;
//		   }else {
//			   Set< Integer> a=new HashSet<Integer>();
//			   for(int i:nums) {
//				   a.add(i);
//			   }
//			   int[] num=new int[a.size()];
//			   for(int i=0;i<a.size();i++) {
//				   num[i]=(int)a.toArray()[i];
//			   }
//			   for(int i=0;i<num.length;i++) {
//		        	for(int j=i+1;j<num.length;j++) {
//		        		if(num[i]>num[j]) {
//		        			if(num[i]-num[j]==k)n++;
//		        		}else {
//		        			if(num[j]-num[i]==k)n++;
//						}
//		        	}
//		        }
//		   }
//		   return n;
//	    }
//}
