package com.algorithm.leetcode;

public class ��������1025 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		System.out.print(divisorGame(N));
	}
	public static boolean divisorGame(int N) {
        boolean res = false;
        int i = 0;
        boolean l = false;
        while(true){
            i++;
            for(int k = 1 ; k < N  ;k++){
                if(k > 0 &&k<N&&N%k==0){
                    N = N - k;
                    l = true;
                    break;
                }
                
            }
            if(i%2==1 && l == false){
               res = false;
                break;
            }else if(i%2==0 && l == false){
                res = true;
                break;
            }
            
            l = false;
            
        }
        return res;
    }

}
