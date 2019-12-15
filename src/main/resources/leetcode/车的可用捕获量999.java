package com.algorithm.leetcode;

public class 车的可用捕获量999 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	 public static int numRookCaptures(char[][] board) {
		 	int res = 0;
		 	int t = 0 ,k = 0;
	        for(int i = 0;i <= board.length;i++) {
	        	for(int j = 0 ;j < board[0].length ; j ++) {
	        		if(board[i][j] == 'R') {
	        			t = i;
	        			k = j;
	        		}
	        	}
	        }
	        for(int i = t + 1 ; i <= board.length; i ++ ) {
	        	if(board[i][k] == '.') {
	        		
	        	}else if(board[i][k] == 'B') {
	        		break;
	        	}else if(board[i][k] == 'p') {
	        		res++;
	        		break;
	        	}
	        }
	        for(int i = t - 1 ; i >= 0; i -- ) {
	        	if(board[i][k] == '.') {
	        		
	        	}else if(board[i][k] == 'B') {
	        		break;
	        	}else if(board[i][k] == 'p') {
	        		res++;
	        		break;
	        	}
	        }
	        for(int j = k + 1 ; j < board[0].length; j ++ ) {
	        	if(board[t][k] == '.') {
	        		
	        	}else if(board[t][j] == 'B') {
	        		break;
	        	}else if(board[t][j] == 'p') {
	        		res++;
	        		break;
	        	}
	        }
	        for(int j = k - 1 ; j >= 0; j -- ) {
	        	if(board[t][k] == '.') {
	        		
	        	}else if(board[t][j] == 'B') {
	        		break;
	        	}else if(board[t][j] == 'p') {
	        		res++;
	        		break;
	        	}
	        }
	        return res;
	    }
}
