package com.algorithm.leetcode;

public class �Գ���728 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(selfDividingNumbers(1, 22));
	}
	 public static List<Integer> selfDividingNumbers(int left, int right) {
		 List<Integer> A=new ArrayList<Integer>();
		 for(int i=left;i<=right;i++) {
			 if(String.valueOf(i).contains("0")) {
				 continue;
			 }else {
				 boolean t=true;
				 int n=i;
				 while(n>0) {
					 if(i%(n%10)!=0) {
						 t=false;
						 break;
					 }else {
						 n/=10;
					 }
				 }
				 if(t) {
					 A.add(i);
				 }
			 }
		 }
		 
		 return A;
	    }
}
