package com.algorithm.leetcode;

public class �������II119 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	 public static List<Integer> getRow(int rowIndex) {
	        List<Integer> a=new ArrayList<Integer>();
	        int[][] p=new int[rowIndex][rowIndex];
	        for(int i=0;i<rowIndex;i++) {
	        	for(int j=0;j<i;j++) {
	        		if(j==0) {
	        			p[i][j]=1;
	        		}else if(j==i-1) {
	        			p[i][j]=1;
	        		}else {
	        			p[i][j]=p[i-1][j]+p[i-1][j+1];
	        		}
	        	}
	        }
	        for(int j=0;j<rowIndex;j++) {
	        	a.add(p[rowIndex][j]);
	        }
	        return a;
	    }
}
