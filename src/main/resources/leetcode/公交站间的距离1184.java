package com.algorithm.leetcode;

public class 公交站间的距离1184 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int distance[] = {1,2,3,4};
//		int distance[] = {8,11,6,7,10,11,2};
//		int distance[] = {7,10,1,12,11,14,5,0};
//		int distance[] = {14,21,8,35 ,30,21,28,19,10,25,16,23, 14,13,0,3,30,9};
		int distance[] = {28,59,22,29,28,27,22,21,48,27,30,41,40,47,30,33,24,27,38,9,32,55,22,37,48,35,42,21,4,7};
				
				
		distanceBetweenBusStops(distance, 2, 25);
	}
	/**
	 * 向左不加
	 * @param distance
	 * @param start
	 * @param destination
	 * @return
	 */
    public static int distanceBetweenBusStops(int[] distance, int start, int destination) {
    	int l = 0,r = 0;
    	int i = start;
    	while(true) {
    		if(i == destination) {
    			break;
    		}
    		r += distance[i];
    		i++;
    		if(i >= distance.length) {
    			i = 0;
    		}
    	}
    	int j = start  - 1;
    	while(true) {
    		if(j == destination - 1) {
    			break;
    		}
    		if(j < 0) {
    			j = distance.length - 1;
    			l += distance[j];
    			if(destination == distance.length - 1 ) {
    				break;
    			}
    			j--;
    		}else {
    			l += distance[j];
    			j--;
    		}
    		
    	
    		
    	}
    	return Math.min(l, r);
    }

}
