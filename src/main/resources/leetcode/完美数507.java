package com.algorithm.leetcode;

public class ÍêÃÀÊı507 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(checkPerfectNumber(28));
	}
    public static boolean checkPerfectNumber(int num) {
    	int rse=0;
        for(int i=1;i<num/2;i++) {
        	if(num%i==0) {
        		rse+=i;
        	}
        	if(rse==num) {
            	return true;
            }
        	if(i>99999000) {
        		return false;
        	}
        }
        
        	return false;
      
    }
}
