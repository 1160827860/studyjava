package com.algorithm.leetcode;

public class 反转字符串中的单词III557 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s ="Let's take LeetCode contest";
		System.out.println(reverseWords(s));
	}
	public static String reverseWords(String s) {
	     String res[] =s.split(" ");
	     StringBuilder a = new StringBuilder();
	     for(String t: res) {
	    	for(int k = t.length() -1 ;k >= 0;k--) {
	    		 a.append(t.charAt(k));
	    		
	    	}
	    	 a.append(" ");
	     }
	     a.deleteCharAt(a.length()-1);
	     return a.toString();
	  
	  }
}
