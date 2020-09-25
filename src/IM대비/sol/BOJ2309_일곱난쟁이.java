package IM대비.sol;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Samsung SW역량 테스트 IM대비 BOJ 2309 난쟁이	
 * 
 * @author Park Sangwoo
 * @since 2020-09-24
 */
public class BOJ2309_일곱난쟁이 {

	static int N = 9, R = 7;
	static int arr[], ans[];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		arr = new int [9];
		ans = new int [7];
		for (int i = 0; i < 9; i++) {
			arr[i] = sc.nextInt();
		}
		nCr(0,0);
	}
	public static void nCr(int cnt, int start) {
		if (cnt == R) {
			int sum = 0;
			for (int i = 0; i < R; i++) {
				sum += ans[i];
			}
			if (sum ==100) {
				Arrays.sort(ans);
				for (int i = 0; i < R; i++) {
					System.out.println(ans[i]);
				}
			}
			return;
		}
		for (int i = start; i < N; i++) {
			ans[cnt] = arr[i];
			nCr(cnt+1, i+1);
		}
			
	}

}
