package com.algorithm.leetcode;//package com.algorithm.leetcode;
//
//import java.util.ArrayList;
//import java.util.HashSet;
//import java.util.Hashtable;
//import java.util.LinkedList;
//import java.util.List;
//import java.util.Set;
//
//
//public class ��������Ľ���349 {
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		int[] nums1= {1,2,2,1};
//		int[] nums2= {2,2};
//		for(int i: intersection(nums1, nums2)) {
//			System.out.println(i);
//		}
//
//
//	}
//	  public static int[] intersection(int[] nums1, int[] nums2) {
//		  	LinkedList<Integer> res =new LinkedList<Integer>();
//	     	Set< Integer> a =new HashSet<Integer>();
//	    	Set< Integer> b =new HashSet<Integer>();
//	     	for(int i: nums1) {
//	     		a.add(i);
//	     	}
//	    	for(int i: nums2) {
//	     		b.add(i);
//	     	}
//	    	Object[] a1 = a.toArray();
//	    	Object[] b1 = b.toArray();
//	    	int [] a2 = new int[a.size()];
//	    	int [] b2 = new int[b.size()];
////	    	for(int i = 0;i <a1.length;i++ ) {
////	    		a2[i] = (int) a1[i];
////	    	}
////	    	for(int i = 0;i <b1.length;i++ ) {
////	    		b2[i] = (int) b1[i];
////	    	}
//	    	for(int i = 0;i<a.size();i++) {
//	    		for(int j = 0;j<b.size();j++) {
//	    			if((a2[i]^b2[j])==0) {
//	    				res.add(a2[i]);
//	    			}
//	    		}
//	    	}
//	    	int[] res1 =new int[res.size()];
//	    	Object[] t = res.toArray();
//	    	for(int i =0;i<res.size();i++) {
//	    		res1[i] = (int) t[i];
//	    	}
//	    	return res1;
//	    }
//
//
//}
