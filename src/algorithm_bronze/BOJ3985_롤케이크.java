package algorithm_bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ 3985 롤케이크
 * 
 * @author Park Sangwoo
 * @since 2020-09-02
 */
public class BOJ3985_롤케이크 {

	static int N, P;
	static int[] cake;
	static int[][] pick;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		P = Integer.parseInt(br.readLine());
		cake = new int[N];
		pick = new int[P][2];

		for (int i = 0; i < N; i++) {
			int start = 0;
			int end = 0;
			for (int j = 0; j < P; j++) {
				st = new StringTokenizer(br.readLine().trim());
				pick[i][0] = Integer.parseInt(st.nextToken());
				pick[i][1] = Integer.parseInt(st.nextToken());
				start = pick[j][0];
				end = pick[j][1];
			}

			int cnt = 0;
			for (int j = start; j < end; j++) {
				cake[j] = i;
				if (cake[j] != 0) {
					continue;
				}
			}
		}
	}
}
