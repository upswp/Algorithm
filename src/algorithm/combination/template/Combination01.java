package algorithm.combination.template;

import java.util.Arrays;


public class Combination01 {
	
	static int [] A = {1,2,3,4,5};
	static int N, R,count;
	static boolean []v;
	
	public static void main(String[] args) {
		count = 0;
		N = A.length;
		R = 3;
		v = new boolean[N];
		nCr(0, 0,new int[R]); 						
		System.out.println(count);
	}
	
	static void nCr(int cnt, int start ,int [] A) { 
		if (R == cnt ) {
			count++;
			System.out.println(Arrays.toString(A));
			return ;
		}
		
		for (int i = start; i < N; i++) {
			A[cnt] = i+1;
			nCr(cnt+1, i+1, A);
		}
	}
}
