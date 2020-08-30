package algorithm.permutation;

import java.util.Scanner;
/**
 * SWEA 1247
 * 최적경로
 * @author Park Sangwoo
 * @use Permutation
 * @since 2020-08-30
 */
public class Solution1247_최적경로 {

	static int T, N, min;
	static int[][] map;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int t = 0; t < T; t++) {
			N = sc.nextInt();
			map = new int[N + 2][2];
			map[0][0] = sc.nextInt();
			map[0][1] = sc.nextInt();

			map[N + 1][0] = sc.nextInt();
			map[N + 1][1] = sc.nextInt();

			for (int i = 0; i < N + 1; i++) {
				for (int j = 0; j < 2; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			min = Integer.MAX_VALUE;
			nPr(0, new boolean[N], map[0][0], map[0][0], 0);
			System.out.println("#" + t + " " + min);
		}
	}

	private static void nPr(int cnt, boolean[] b, int br, int bc, int sum) {
		if (cnt == N) {
			sum += Math.abs(br - map[N + 1][0]) + Math.abs(bc - map[N + 1][1]);
			min = Math.min(sum, min);
			return;
		}
		for (int i = 0; i < N; i++) {
			if (!b[i]) {
				b[i] = true;
				nPr(cnt + 1, b, map[i + 1][0], map[i + 1][1],
						sum + Math.abs(br - map[i + 1][0]) + Math.abs(bc - map[i + 1][1]));
				b[i] = false;
			}
		}
	}

}
