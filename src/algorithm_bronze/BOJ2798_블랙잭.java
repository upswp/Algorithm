package algorithm_bronze;

import java.util.Scanner;

/**
 * SSAFY BOJ 2798
 * 
 * 블랙잭
 * 
 * @author Park Sangwoo
 * @since 2020-08-17
 */
public class BOJ2798_블랙잭 {
	static int N, M, R, MAX;
	static int[] nums;
	static int[] res;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		R = 3;
		MAX = -1;
		nums = new int[N];
		res = new int[R];
		for (int i = 0; i < N; i++) {
			nums[i] = sc.nextInt();
		}
		
		nCr(0, 0);
		
		System.out.println(MAX);

	}

	private static void nCr(int cnt, int start) { 
		if (cnt == R) {
			if (res[0] + res[1] + res[2] <= M && res[0] + res[1] + res[2] > MAX) {
				MAX = res[0] + res[1] + res[2];
			}
			return;
		}
		for (int i = start; i < N; i++) {
			res[cnt] = nums[i];
			nCr(cnt + 1, i + 1);
		}
	}

}
