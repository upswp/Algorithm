package algorithm_bronze;
import java.util.Scanner;

public class BOJ2839_설탕배달 {
	static int T, M;
	static int min;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		T = sc.nextInt();
//		for (int t = 0; t < T; t++) {
			M = sc.nextInt();
			min = Integer.MAX_VALUE;
			recursion(0,0);
			System.out.println(min == Integer.MAX_VALUE?-1:min);
//		}
	}

	public static void recursion(int sum, int cnt) {
		if (sum > M) {
			return;
		}
		if (sum == M) {
			min = Math.min(min, cnt);
			return;
		}
		recursion(sum+3, cnt+1);
		recursion(sum+5, cnt+1);
	}
}
