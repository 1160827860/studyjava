package com.algorithm.leetcode;

public class 在D天内送达包裹的能力1014 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a= {10,50,100,100,50,100,100,100};
				
		System.out.println(shipWithinDays(a, 5));
	}
	  public static int shipWithinDays(int[] weights, int D) {
	        int n=0;
	        int pp=0;
	        int res=0;
	        for(int i=0;i<weights.length;i++) {
	        	pp+=weights[i];
	        }
	        pp=pp/D;
	        for(int i=0;i<weights.length;i++) {
	        	if(n>D) {
	        		i=0;
	        		pp++;
	        		n=0;
	        	}
	        	res+=weights[i];
	        	if(res>pp) {
	        		res=res-weights[i];
	        		n++;
	        		res=0;
	        		i--;
	        	}else 
	        	      if(res==pp) {
	        		n++;
	        		
	        	}
	        	if(i==weights.length-1) {
	        		n++;
	        	}
	        	if(n>D) {
	        		i=0;
	        		pp++;
	        		n=0;
	        	}
	        }
	        	
	        return pp;
	    }
}
