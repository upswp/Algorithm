package algorithm.permutation;
/*
 * 오류
 */
import java.util.ArrayList;

public class PermTest4 {
	
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
		nPr(0,new ArrayList<String>());
		System.out.println(T);
	}
	private static void nPr(int cnt ,ArrayList<String> list) {
		if (R == cnt) {
			T ++;
			System.out.println(list.toString());
			return;
		}
		for (int i = 0; i < N; i++) {
			if (b[i]) {continue;}
			b[i] = true;
			list.add((i+1)+"");
			nPr(cnt+1,list);
			list.remove((i+1)+"");
			b[i] = false;
		}
	}

}
