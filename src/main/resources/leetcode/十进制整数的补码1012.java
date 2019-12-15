package com.algorithm.leetcode;

public class ʮ���������Ĳ���1012 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(bitwiseComplement(5));
	}
	 public static int bitwiseComplement(int N) {
	        
	        String a=Integer.toBinaryString(N);
	        char[] p=a.toCharArray();
	        for(int i=0;i<p.length;i++) {
	        	if(p[i]=='0') {
	        		p[i]='1';
	        	}else {
	        		p[i]='0';
	        	}
	        }
	        String d=new String(p);
	        return Integer.parseInt(d,2);
	    }
}
