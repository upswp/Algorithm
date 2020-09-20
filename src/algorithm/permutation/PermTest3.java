package algorithm.permutation;
/*
 * 오류
 */
public class PermTest3 {
	
	static int N,R;
	static int [] num;
	static int [] a;
	static int T ;
	static boolean [] b;
	
	public static void main(String[] args) {
		
		a = new int[] {1,2,3,4,5};
		b= new boolean[N];
		N = a.length;
		R = 3;
		T = 0;
		
		num = new int[R];
		nPr(0);
		System.out.println(T);
	}
	private static void nPr(int cnt) {
		if (cnt == R) {
			T ++;
			return;
		}
		for (int i = 0; i < N; i++) {
			if (b[i]) {continue;}
			b[i] = true;
			nPr(cnt+1);
			b[i] = false;
		}
	}

}
