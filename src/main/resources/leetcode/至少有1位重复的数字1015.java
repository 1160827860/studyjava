package com.algorithm.leetcode;

public class 至少有1位重复的数字1015 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			System.out.println(numDupDigitsAtMostN(1000));
	}
    public static int numDupDigitsAtMostN(int N) {
    	int n=0;
        for(int i=1;i<=N;i++) {
        	if(i%11==0) {
        		n++;
        	}else if(i%10==0&&i>=100){
        		n++;
        	}
        }
        return n;
    }
}
