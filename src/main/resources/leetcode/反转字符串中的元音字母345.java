package com.algorithm.leetcode;

public class 反转字符串中的元音字母345 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(reverseVowels("hello"));
	}
    public static String reverseVowels(String s) {
        int fast=0,slow=1;
        char temp;
        char[] a=s.toCharArray();
        while(fast<s.length()) {
        	
        	if(a[slow]=='a'||a[slow]=='e'||a[slow]=='i'||a[slow]=='o'||a[slow]=='u') {
        		if(fast>=s.length()) {
        			break;
        		}
        		while(a[fast]!='a'||a[fast]!='e'||a[fast]!='i'||a[fast]!='o'||a[fast]!='u') {
        			
        			fast++;
        			if(fast>=s.length()) {
            			break;
            		}
        		}
        		if(fast>=s.length()) {
        			break;
        		}
        		temp=a[slow];
        		a[fast]=a[slow];
        		a[slow]=temp;
        		slow++;
        		fast++;
        	}else {
        		slow++;
        		fast++;
        	}
        	
        }
        String p=(String)a.toString();
      
        	System.out.println(p);
     
        return p;
    }
}
