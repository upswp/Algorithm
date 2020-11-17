package algorithm_gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ4811_알약 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		long dp[] = new long[31];
		dp[0] = 1;
		dp[1] = 1;
		dp[2] = 2;
		
		for (int i = 3; i < 31; i++) {
			long ans = 0;
			for (int j = 0; j < i; j++) {
				ans += dp[j] * dp[i-1-j];
			}
			dp[i] = ans;
		}
		
		while(true) {
			int N = Integer.parseInt(br.readLine());
			
			if(N == 0) {
				break;
			}
			sb.append(dp[N] +"\n");
		}
		System.out.print(sb);
	}
}
