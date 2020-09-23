package IM대비;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Samsung SW역량 테스트 IM대비 BOJ 2309 일곱난쟁이
 * 
 * @author Park Sangwoo
 * @since 2020-09-22
 */
public class BOJ2309_일곱난쟁이 {
	static int N = 9, R = 7;
	static int arr[], ans[];
	static boolean visit[];

	public static void main(String[] args) {
		// 입력 시작
		Scanner sc = new Scanner(System.in);
		arr = new int[N];
		visit = new boolean[N];
		ans = new int[R];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		nCr(0, 0);
	}

	public static void nCr(int cnt, int start) {
		if (cnt == R) {
			int sum = 0;
			for (int i = 0; i < R; i++) {
				sum += ans[i];
			}
			if (sum == 100) {
				Arrays.sort(ans);
				for (int i = 0; i < ans.length; i++) {
					System.out.println(ans[i]);
				}
			}
			return;
		}
		for (int i = start; i < N; i++) {
			ans[cnt] = arr[i];
			nCr(cnt + 1, i + 1);
		}
	}
}
