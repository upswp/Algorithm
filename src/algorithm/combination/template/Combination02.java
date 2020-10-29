package algorithm.combination.template;

import java.util.Arrays;


/**
 * [파스칼의 삼각형]
 * nCr = n-1Cr-1 + n-1Cr
 */
public class Combination02 {
	
	static int [] A = {1,2,3,4,5};
	static int N, R,count;
	static boolean []v;
	
	public static void main(String[] args) {
		count = 0;
		N = A.length;
		R = 3;
		v = new boolean[N];
		nCr(N, R,new int[R]); 						
		System.out.println(count);
	}
	
	static void nCr(int n, int r,int [] A) {
		/*
		 * 조건넣어주며 예외처리 실시.
		 */
		if (n<r) return;
		
		if (r == 0) {
			count++;
			System.out.println(Arrays.toString(A));
			return ;
		}
		
		/*
		 * 파스칼의 삼각형을 이용하여
		 * for문 없이 재귀사용하여 사용
		 */
		A[r-1] = n;
		nCr(n-1,r-1,A);
		nCr(n-1,r,A);
	}
}
