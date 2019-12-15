package com.algorithm.leetcode;

public class ���ܾ���566 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int[][] matrixReshape(int[][] nums, int r, int c) {
	      if(r * c > nums.length*nums[0].length) {
	    	  return nums;
	      }else {
	    	  LinkedList<Integer> temp = new LinkedList<Integer>();
	    	  for(int j[]:nums) {
	    		  for(int i:j) {
	    			  temp.add(i);
	    		  }
	    	  }
	    	  int[][] res = new int[r][c];
	    	  while(temp.size() > 0) {
	    		  for(int i = 0;i < r;i++) {
	    			  for(int j = 0;j < c;j++) {
	    				  res[i][j] = temp.remove();
	    			  }
	    		  }
	    	  }
	    	  return res;
	      }
	}

}
