package algorithm.subset.template;

import java.util.ArrayList;
import java.util.Arrays;


public class SubSet01 {
	
	static int [] A = {1,2,3,4,5};
	static int N, R,count;
	static boolean []v;
	
	public static void main(String[] args) {
		count = 0;
		N = A.length;
		R = 3;
		v = new boolean[N];
		subset(0,0,new ArrayList<String>()); 						
		System.out.println(count);
	}
	
	/**
	 * subset
	 * 
	 * @param cnt 횟수
	 * @param sum 합
	 * @param list 담을 list
	 */
	static void subset(int cnt, int sum,ArrayList<String> list) {
		if (cnt == N) {
			count++;
			System.out.println(Arrays.toString(list.toArray()));
			System.out.println(sum);
			return ;
		}
		
		list.add(""+(A[cnt]));
		subset(cnt+1, sum+A[cnt], list);
		list.remove(""+(A[cnt]));
		subset(cnt+1, sum, list);
	}
}

