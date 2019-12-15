package com.algorithm.leetcode;

public class ��һ66 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a= {9,9};
		plusOne(a);
	}
	public static  int[] plusOne(int[] digits) {
		digits[digits.length-1]++;
		int[] res=new int[digits.length+1];

		if(digits[digits.length-1]!=10) {
			return digits;
		}else {
			for(int i=digits.length-1;i>=0;i--) {
				if(digits[i]==10&&i!=0) {
					digits[i-1]++;
					digits[i]=0;
				}else if(digits[i]==10&&i==0){
					for(int j=digits.length-1;j>0;j--) {
						res[j]=digits[j];
					}
					digits=res;
					digits[0]=1;
					digits[1]=0;
				}
				
			}
		}
		return digits;
		
     }
	
}
