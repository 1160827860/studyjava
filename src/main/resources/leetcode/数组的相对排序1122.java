package com.algorithm.leetcode;


public class ������������1122 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] arr1 = {2,3,1,3,2,4,6,7,9,2,19};
//		int[] arr2 = {2,1,4,3,9,6};
		int[] arr1 = {2,21,43,38,0,42,33,7,24,13,12,27,12,24,5,23,29,48,30,31};
		int[] arr2 = {2,42,38,0,43,21};
		
				
		relativeSortArray(arr1, arr2);
	}
    public static int[] relativeSortArray(int[] arr1, int[] arr2) {
    	List<Integer> builder = new ArrayList<Integer>();
    	int l = 0,r = arr1.length;
    	int temp ; 
    	for(int i : arr2) {
    		l = 0;
    		r = arr1.length;
    		while(l < r) {
    			if(arr1[l++] == i) {
    				builder.add(i);
    				
    			}
    		}
    	}
    	Arrays.sort(arr1);
    	LinkedList<Integer> arr3 = new LinkedList<Integer>();
    
    	for(int i : arr1) {
    		arr3.add(i);
    	}
    	
    	for(int i : builder) {
    		
    		arr3.remove((Object)i);
    	}
    	for(int i : arr3) {
    		builder.add(i);
    	}
//    	boolean index = false;
//    	for(int j = 0;j < arr1.length;j++) {
//    		for(Integer i : builder) {
//    			if(arr1[j] == i) {
//    				index = true;
//    			}
//    		}
//    		if(!index) {
//        		builder.add(arr1[j]);
//        	}
//    		index = false;
//    	}
    	int[] res = new int[arr1.length];
    	int t = 0;
    	for(int i : builder) {
    		res[t++] = i;
    	}
    	return res;
    }
}
