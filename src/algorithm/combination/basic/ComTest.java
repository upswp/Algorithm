package algorithm.combination.basic;

import java.util.Arrays;

public class ComTest {

	static int n, r;
	static char []nums;
	public static void main(String[] args) {
		n = 5;
		r = 3;
		nums=new char[3];
		nCr(0, 0);
	}

	private static void nCr(int cnt, int start) {
		if (cnt == r) {
			System.out.println(Arrays.toString(nums));
			return;
		}
		for (int i = start; i < n; i++) {
			nums[cnt] =(char) (i+'A');
			nCr(cnt+1,i+1);
		}
	}

}
