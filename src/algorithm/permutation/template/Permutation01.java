package algorithm.permutation.template;

import java.util.ArrayList;
import java.util.Arrays;

public class Permutation01 {
	
	static int [] A = {1,2,3,4,5};
	static int N, R,count;
	static boolean []v;
	
	public static void main(String[] args) {
		count = 0;
		N = A.length;
		R = 3;
		v = new boolean[N];
		nPr(0, new ArrayList<String>());
		System.out.println(count);
	}
	
	static void nPr(int cnt, ArrayList<String> list) { // list를 이용하여 출력.
		if (R == cnt ) {
			count++;
			System.out.println(Arrays.toString(list.toArray()));
			return ;
		}
		
		for (int i = 0; i < N; i++) {
			if (v[i]) continue;
			v[i] = true;			//backtracking
			list.add(""+(i+1));		//backtracking, String형식으로 하기위해서 (""+(i+1))
			nPr(cnt+1, list);
			list.remove(""+(i+1));	//backtracking
			v[i] = false;			//backtracking
			
		}
	}
}

