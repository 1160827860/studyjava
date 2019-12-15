package com.algorithm.leetcode;

public class Æ´Ð´µ¥´Ê1160 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String words[] =  {"cat","bt","hat","tree"};
		String chars = "atach";
		countCharacters(words, chars);
		System.out.println(5^0);
	}
	public static int countCharacters(String[] words, String chars) {
		int res = 0;
		boolean[] index = new boolean[chars.length()];
		
		for(String i : words) {
			boolean[] indexOfWords = new boolean[i.length()];
			for(int t = 0;t < i.length();t++) {
				for(int j = 0;j < chars.length();j++) {
					if(i.charAt(t) == chars.charAt(j)&&index[j] == false) {
						index[j] = true;
						indexOfWords[t] = true;
						break;
					}
				}
			}
			index = new boolean[chars.length()];
			boolean temp = true;
			for(int k = 0;k < indexOfWords.length ;k++) {
				temp &=indexOfWords[k];
			}
			if(temp == true) {
				res += i.length();
			}
		}
		return res;
	}
}
