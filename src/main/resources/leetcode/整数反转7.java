package com.algorithm.leetcode;

public class 整数反转7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			int a=123;
			System.out.println(reverse(1534236469));
	}
    public static int reverse(int x) {
        if(x==0) {
        	return 0;
        }else if(x>0) {
        String a=	String.valueOf(x);
        a=a.trim();
        StringBuilder t=new StringBuilder();
        for(int i=a.length()-1;i>=0;i--) {
        	t.append(a.charAt(i));
        }
        
        return Integer.parseInt(t.toString().trim());
        }else {
        	String a=	String.valueOf(x);
        	a=a.trim();
        	StringBuilder t=new StringBuilder();
        	for(int i=a.length()-1;i>0;i--) {
        		t.append(a.charAt(i));
        	}
        	 return Integer.parseInt(t.toString().trim())*-1;
        }
        
    }
}
