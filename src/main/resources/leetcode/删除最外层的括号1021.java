package com.algorithm.leetcode;

public class ɾ������������1021 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(removeOuterParentheses("(()())(())"));
	}
    public static String removeOuterParentheses(String S) {
        Stack<Character> stack = new Stack<Character>();
        StringBuilder res = new StringBuilder();
        for(int i = 0;i<S.length();i++) {
        	if(stack.empty()) {
        		stack.add(S.charAt(i));
        		
        	}else {
        		if(S.charAt(i)=='(') {
        			stack.add(S.charAt(i));
        			res.append(S.charAt(i));
        		}else {
        			if(stack.size()!=1){
        				stack.pop();
            			res.append(S.charAt(i));
        			}else {
        				stack.pop();
        			}
        			
        		}
        	}
        }
        return res.toString();
    }
}
