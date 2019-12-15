package com.algorithm.leetcode;

public class 总持续时间可被整除的歌曲1013 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	 public int numPairsDivisibleBy60(int[] time) {
		 int n=0;
	        for(int i=0;i<time.length;i++) {
	        	for(int j=i+1;j<time.length;j++) {
	        		if((time[i]+time[j])%60==0) {
	        			n++;
	        		}
	        	}
	        }
	        return n;
	 }
}
