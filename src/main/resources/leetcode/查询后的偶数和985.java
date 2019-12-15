package com.algorithm.leetcode;

public class 查询后的偶数和985 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
		int[] res = new int[queries.length];
		for(int i = 0;i < queries.length;i++) {
			A[queries[i][1]] += queries[i][0];
			for(int j :A) {
				res[i] += j % 2 == 0?j:0;
			}
		}
		return res;
	}

}
