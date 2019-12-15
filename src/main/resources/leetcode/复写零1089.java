package com.algorithm.leetcode;

public class ¸´Ğ´Áã1089 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,5,2,0,6,8,0,6,0};
//		int[] arr = {1,2,3};
//		int[] arr = {9,0,9,0,6,0,0,0,1,1,6,5,4,4,8,3,0,0,0,1,5,3,0,0,7,2,1,0,2,0,9,1,0,2,0,0,0,0,0,0,0,6,0,0,7,9,0,8,7,0,9,7,1,0,2,0,0,0,0,9,0,0,0,0};
//		int[] arr = {1,0,2,3,0,4,5,0};
//		int[] arr = {0,0,0,0,0,0,0};
//		int[] arr = {8,4,5,0,0,0,0,7};
//		int[] arr = {0,1,9,3,3,2,1,7,3,9,1,8,5,7,9,9,8,1,0,2,6,2,9,0,6,9,0,8,5,3,3,9,8,0,7,1,5,0,0,9,2,3,3,2,2,0,8,5,0,8,0,3,1,5,6,0,2,6,8,0,2,6,7,8,1,8,4,8,6,0,3,0,0,0,0,6,9,5,0,8,6,9,1,1,0,3,0,6,0,0,5,5,0,4,7,4,0,0,0,0};
		duplicateZeros(arr);
	}
	 public static void duplicateZeros(int[] arr) {
		 int count = 0;
		 int t = 0;
		
			 for(int j : arr) {
			
				 if( j != 0 ) {
					 t++;
				 }else {
					 t += 2;
				 }
				 if(t > arr.length - 1) {
					 break;
				 }
				 count++;
				
			 }
			int len = 0;
		 for(int i = 0;i <= count;i++) {
			 len +=( arr[i] == 0)?2:1;
		 }
		
		 if(count == 0) {
			 
		 }else {
//			 count--;
			 if(len > arr.length) {
				 count--;
				 arr[arr.length - 1] = 0;
				 for(int i = arr.length -2;i >= 0;i--) {
					 if(arr[count] == 0) {
						 if(i == 0) {
							 arr[i] = 0;
						 }else {
							 arr[i--] = 0;
							 arr[i] = 0; 
							 count--;
						 }
						
					 }else {
						 arr[i] = arr[count--];
					 }
					
				 }
			 }else {
				 for(int i = arr.length - 1;i >= 0;i--) {
					 if(arr[count] == 0) {
						 if(i == 0) {
							 arr[i] = 0;
						 }else {
							 arr[i--] = 0;
							 arr[i] = 0; 
							 count--;
						 }
						
					 }else {
						 arr[i] = arr[count--];
					 }
					
				 }
			 }
			
		 }
		
		 
	 }
}
