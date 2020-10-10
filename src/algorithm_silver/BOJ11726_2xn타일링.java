package algorithm_silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
/**
 * BOJ 11726 2xn타일링
 * @author Park Sangwoo
 * @since 2020-10-10
 */
public class BOJ11726_2xn타일링 {
	
	static int N;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		long dp[] = new long [1001];		//첫째 줄에 n이 주어진다. (1 ≤ n ≤ 1,000)
		
		dp[0] = 1;
		dp[1] = 1;
		dp[2] = 2;
		
		for (int i = 3; i < dp.length; i++) {
			dp[i] = dp[i-1] + dp[i-2];
			dp[i] %= 10_007;				//직사각형을 채우는 방법의 수를 10,007로 나눈 나머지를 출력한다.
		}
		
		N = Integer.parseInt(br.readLine());
		System.out.println(dp[N]);
	}
}
