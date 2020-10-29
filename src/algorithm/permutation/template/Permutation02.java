package algorithm.permutation.template;

import java.util.Arrays;


/**
 * [binary counting을 이용한 순열]
 * 
 * 1 2 4 8 16 -> 부분집합 1<<5 : 32개
 * binary counting
 * 1 2 1+2 4 1+4 2+4 1+2+4 8 1+8 2+8 1+2+8 4+8 ~
 * 00001 00010 00011 00100 00101 ...
 * 
 * 00101에 1이 있니? 00101 & 1 -> 1
 * 
 */
public class Permutation02 {
	
	static int [] A = {1,2,3,4,5};
	static int N, R,count;
	static boolean []v;
	
	public static void main(String[] args) {
		count = 0;
		N = A.length;
		R = 3;
		v = new boolean[N];
		nPr(0, 0,new int[R]); 						//flag 사용
		System.out.println(count);
	}
	
	static void nPr(int cnt, int flag ,int [] A) { 
		if (R == cnt ) {
			count++;
			System.out.println(Arrays.toString(A));
			return ;
		}
		
		for (int i = 0; i < N; i++) {
			if ((flag & (1<<i)) !=0) continue;		//핵심
			A[cnt] = (i+1);
			nPr(cnt+1, (flag|1 <<i), A);			//핵심
		}
	}
}
