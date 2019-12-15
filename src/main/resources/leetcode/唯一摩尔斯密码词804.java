package com.algorithm.leetcode;

public class ΨһĦ��˹�����804 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] words = {"gin", "zen", "gig", "msg"};
		System.out.println(uniqueMorseRepresentations(words));
	}
	 public static int uniqueMorseRepresentations(String[] words) {
		 String[] MOS = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
		 Set<String> set = new HashSet<String>();
		 
		 for(String row: words) {
			 StringBuilder builder = new StringBuilder();
			 for(int i = 0 ;i<row.length();i++) {
				 builder.append(MOS[(int)(row.charAt(i)-97)]);
			 }
			 set.add(builder.toString());
		 }
		 return set.size();
	  }
}
