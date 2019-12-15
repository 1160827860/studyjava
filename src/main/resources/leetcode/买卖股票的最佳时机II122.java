package com.algorithm.leetcode;

public class ������Ʊ�����ʱ��II122 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[]= {1,2,3,4,5};
//		System.out.println(maxProfit(a));
		List<String> list2 = Arrays.asList(new String[]{"c","a","b"});
		
	
	}
	 public static int maxProfit(int[] prices) {
		 if(prices.length==0) {
			 return 0;
		 }else {
			 int res = 0;
			 for(int i = 1;i < prices.length;i++) {
				 if(prices[i] - prices[i - 1] > 0) {
					 res += prices[i] - prices[i - 1];
				 }
			
			 }
			 return res;
	    }
	
	 }
	
}
