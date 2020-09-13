package algorithm.permutation.basic;

import java.util.Arrays;

public class PermTest1 {

	static boolean [] b;
	static int r,n;
	static int [] nums;
	public static void main(String[] args) {
		n = 5;
		r = 3;
		//숫자저장
		nums = new int[r];
		
		b= new boolean[n];
		
		nPr(0);
	}

	public static void nPr (int cnt) {
		if(r == cnt ) {
			//end 조건 입력
			System.out.println(Arrays.toString(nums));
			return ;
		}
		for (int i = 0; i < n; i++) {
			if(b[i]) {
				continue;
			}
			
			b[i] = true;
			nums[cnt]= (i+1);			
			nPr(cnt+1);
			b[i]=false;
		}
		
	}
}
