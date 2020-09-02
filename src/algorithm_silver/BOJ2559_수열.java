package algorithm_silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ 2559 수열
 * @author Park Sangwoo
 * @since 2020-09-01
 */
public class BOJ2559_수열 {
	static int N, K;
	static int sum, max;
	static int [] sequence;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		N = Integer.parseInt(st.nextToken());
		
		K = Integer.parseInt(st.nextToken());
		sequence = new int [N];
		max = Integer.MIN_VALUE;
		
		st = new StringTokenizer(br.readLine().trim());
		for (int i = 0; i < N; i++) {
			sequence[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i <= N-K; i++) {
			sum =0;
			for (int j = i; j <K+i; j++) {
				sum += sequence[j];
			}
			max = Math.max(max, sum);
		}
		System.out.println(max);
	}

}
