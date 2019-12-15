package com.algorithm.leetcode;//package com.algorithm.leetcode;
//
//import java.util.ArrayList;
//import java.util.LinkedList;
//
//public class ����ż��������905 {
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//	}
//	  public static int[] sortArrayByParity(int[] A) {
//		  LinkedList< Integer> res =new LinkedList<Integer>();
//		  for(int i = 0;i<A.length;i++) {
//			  if(A[i]%2==0) {
//				  res.addFirst(A[i]);
//			  }else {
//				  res.addLast(A[i]);
//			  }
//		  }
//		  Object[] res1 =res.toArray();
//		  int[] res2 = new int[res1.length];
//		  for(int i = 0 ;i<res1.length;i++) {
//			  res2[i] = (int) res1[i];
//		  }
//		  return res2;
//	   }
//}
