package algorithm.combination;

import java.io.BufferedReader;
import java.io.InputStreamReader;
/**
 * SWEA 4012
 * 요리사
 * @author Park Sangwoo
 * @use Combination
 * @since 2020-08-30
 */
public class Solution4012_요리사 {
	static int T, N, min;
	static int[][] choice;
	static boolean[] visit;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine().trim());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine().trim());
			choice = new int[N][N];
			visit = new boolean[N];
			min = Integer.MAX_VALUE;

			for (int i = 0; i < N; i++) {
				String[] input = br.readLine().split(" ");
				for (int j = 0; j < N; j++) {
					choice[i][j] = Integer.parseInt(input[j]);
				}
			}
			combination(0, 0);

			System.out.println("#" + t + " " + min);
		}
	}

	public static void combination(int cnt, int start) {
		if (start >= N) {
			return;
		}
		if (cnt == N / 2) {
			int A = 0;
			int B = 0;
			for (int i = 0; i < N; i++) {
				for (int j = i + 1; j < N; j++) {
					if (visit[i] != visit[j]) {
						continue;
					}
					if (visit[i]) {
						A += choice[i][j] + choice[j][i];
					} else {
						B += choice[j][i] + choice[i][j];
					}
				}
			}
			min = Math.min(min, Math.abs(A - B));
			return;
		}
		for (int i = start; i < N; i++) {
			visit[i] = true;
			combination(cnt + 1, i + 1);
			visit[i] = false;
		}
	}

}
