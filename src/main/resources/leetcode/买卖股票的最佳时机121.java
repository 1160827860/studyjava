package com.algorithm.leetcode;

public class 买卖股票的最佳时机121 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a= {7,1,5,3,6,4};
		System.out.println(maxProfit(a));
	}
	public static int maxProfit(int[] prices) {
        int n=0;
        for(int i=0;i<prices.length;i++){
            for(int j=i+1;j<prices.length;j++) {
            	if(prices[i]>prices[j]) {
            		if(n<prices[i]-prices[j]) {
            			n=prices[i]-prices[j];
            		}
            	}
            }
        }
        return n;
    }
}
