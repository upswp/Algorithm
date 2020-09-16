package algorithm_silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * BOJ 2805 나무자르기
 * 
 * @author Park Sangwoo
 * @since 2020-09-16
 */
public class BOJ2805_나무자르기 {
	static int N, tree[];
	static long res, M;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Long.parseLong(st.nextToken());
		tree = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			tree[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(tree);
		long end = tree[tree.length -1];
		long start = 0;

		while (start <= end) {
			long mid = (start + end) / 2;
			long sum = 0;
			for (int i = 0; i < tree.length; i++) {
				sum += tree[i] - mid > 0? tree[i]-mid : 0;
			}
			if (sum < M) {
				end = mid -1;
			}else {
				res = mid;
				start = mid +1;
			}
		}
		System.out.println(res);
	}
}
