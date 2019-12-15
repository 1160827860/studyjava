package com.algorithm.leetcode;

public class ������ʽ�������ӷ�989 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[]= {2,1,5};
		System.out.println(addToArrayForm(a, 806));
	}
    public static  List<Integer> addToArrayForm(int[] A, int K) {
    	Stack<Integer> p1=new Stack<Integer>();
         	List<Integer> p=new ArrayList<Integer>();
    	int n=K;
    	int i=A.length-1;
       while(n>0||i>=0) {
    	   if(i>=0) {
    		   n=A[i]+n;
    		   A[i]=(n)%10;
    	   }
    	   
      		p1.add((n)%10);
    	   n=n/10;
    	  i--;
       		
       }

      while(n>0) {
    	  p1.add(n%10);
    	  n/=10;
      }
        while(!p1.isEmpty()) {
        	p.add(p1.pop());
        }
        return p;
    }
}
