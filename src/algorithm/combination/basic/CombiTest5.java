package algorithm.combination.basic;
/*
 * 오류
 */
import java.util.ArrayList;

public class CombiTest5 {
	
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
		nCr(0,0,new ArrayList<String>());
		System.out.println(T);
	}
	private static void nCr(int cnt, int start,ArrayList<String> list) {
		if (R == cnt) {
			T ++;
			System.out.println(list.toString());
			return;
		}
		for (int i = 0; i < N; i++) {
			if (b[i]) {continue;}
			b[i] = true;
			list.add((i+1)+"");
			nCr(cnt+1,i+1,list);
			list.remove((i+1)+"");
			b[i] = false;
		}
	}

}
