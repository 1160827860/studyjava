package com.algorithm.leetcode;

public class 最后一个单词的长度58 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(lengthOfLastWord("a"));
	}
	  public static int lengthOfLastWord(String s) {
	        int n=0;
	   
	        for(int i=s.length()-1;i>=0;i--){
	            if(s.charAt(i)==' '){
	                return n;
	            }else{
	                 n++;
	            }
	        }
	    
	         if(n!=0){
	             return n;
	         }else{
	            return 0; 
	         }
	        
	    }
}
