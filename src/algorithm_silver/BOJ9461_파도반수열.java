package algorithm_silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * BOJ 9461 파도반 수열
 * @author Park Sangwoo
 * @since 2020-10-07
 */
public class BOJ9461_파도반수열 {
	static int T;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		long [] dp = new long [101]; // 1<=N<=100
		dp[1] = 1;
		dp[2] = 1;
		dp[3] = 1;
		dp[4] = 2;
		dp[5] = 2;
		
		for (int i = 6; i < dp.length; i++) {
			dp[i] = dp[i-5] + dp[i-1];
			// 3	6-3,4,5		6-1,2
			// 4	7-4,5		6-1
			// 5	8-5			8-1
			// 7	9-5			9-1
			// 9
		}
		
		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			System.out.println(dp[N]);
		}
	}
}
