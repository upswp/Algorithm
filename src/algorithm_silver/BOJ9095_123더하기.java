package algorithm_silver;

import java.util.Scanner;

public class BOJ9095_123더하기 {
	static int T, N;
	static int dp[] = new int[11];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		dp[1] = 1; // 초기 값 초기화
		dp[2] = 2;
		dp[3] = 4;
		for (int j = 4; j < 11; j++) { // 4부터 반복
			dp[j] = dp[j - 3] + dp[j - 2] + dp[j - 1]; // 점화식
			// 4 	4-3			4-2			4-1
			// 4     1			2			3
			// 4	 1	+		2		+	4
		}
		for (int i = 0; i < T; i++) {
			int N = sc.nextInt();
			System.out.println(dp[N]);
		}
	}
}
// 4 
// 1 1 1 1 
// 1 2 1
// 2 1 1 
// 1 1 2
// 2 2
// 3 1
// 1 3

