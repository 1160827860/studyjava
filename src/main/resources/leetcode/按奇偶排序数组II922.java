package com.algorithm.leetcode;

public class ∞¥∆Ê≈º≈≈–Ú ˝◊ÈII922 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {4,2,5,7};
		sortArrayByParityII(A);
	}
	 public static int[] sortArrayByParityII(int[] A) {
	        for(int i = 0 ;i< A.length-1;i++){
	        if(i%2==0){
	                if(A[i]%2==0){
	                   
	                }else{
	                    for(int j = i+1;j < A.length ; j++){
	                        if(j % 2 != 0&&A[j] % 2 == 0){
	                            A[i] = A[i]^A[j];
	                            A[j] = A[i]^A[j];
	                            A[i] = A[i]^A[j];
	                          }else {
	                              j++;
	                          }
	                      }
	                }
	        }else{
	                if(A[i]%2==0){
	                     for(int j = i+1;j < A.length ; j++){
	                           if(j % 2 == 0&&A[j] % 2 != 0){
	                             A[i] = A[i]^A[j];
	                            A[j] = A[i]^A[j];
	                            A[i] = A[i]^A[j];
	                           }
	                     }
	                }else{
	                 
	                }
	        }       
	    }
	    return A;
	}
}
