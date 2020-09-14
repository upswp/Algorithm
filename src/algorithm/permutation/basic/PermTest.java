package algorithm.permutation.basic;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Park Sangwoo
 *
 */
public class PermTest {
	static int N, R;
	static boolean[] visit;
	static int [] nums;
	static int [] ans;
	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		N = sc.nextInt();
		R = sc.nextInt();
		nums = new int[N];
		visit = new boolean [N];
		ans = new int [R];
		
		for (int i = 0; i < N; i++) {
			nums[i] = sc.nextInt();
		}
		nPr(0);
	}
	public static void nPr(int cnt) {
		if (cnt == R) {
			
		}
		for (int i = 0; i < N; i++) {
			if (!visit[i]) {
				ans[cnt] = nums[i];
				visit[cnt] = true;
				nPr(cnt+1);
				visit[cnt] = false;
			}
		}
	}
}