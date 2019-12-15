package com.algorithm.leetcode;

public class ���ҳ����ַ�1002 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] A = {"bella","label","roller"};
		commonChars(A);
	}
	   public static List<String> commonChars(String[] A) {
			List<String> res = new ArrayList<String>();
			Set<Character> temp = new HashSet<Character>();
			for(int i = 0 ; i < A[0].length();i++) {
				temp.add(A[0].charAt(i));
			}
			int[] mark = new int[A.length];
//			for(int i = 0;i < temp.size();i++) {
			for(Character str :temp) {
				
				for(int i = 0 ;i< A.length;i++) {
					
					for(int j = 0;j < A[i].length();j++) {
						
						if(str.equals(A[i].charAt(j))) {
							mark[i]++;
						}
					}
				}
//				int index = 0;
//				boolean m = false;
//				for(int k = 0;k < mark.length - 1 ;k++) {
//					if(mark[k]!=mark[k+1]) {
//						m = true;
//					}	
//				}
//				if(m==false) {
//					for(int i = 0;i < mark[0] ;i++) {
//						res.add(str.toString());
//					}
//				
//				}
//				mark = new int[A.length];
				int min = Integer.MAX_VALUE;
				for(int t : mark) {
					min = Math.min(min, t);
				}
				for(int e = 0;e < min;e++) {
					res.add(str.toString());
				}
				mark = new int[A.length];
			}
			
//			}
			return res;
		}
}
