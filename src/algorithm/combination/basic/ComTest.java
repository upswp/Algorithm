package algorithm.combination.basic;

import java.util.Scanner;

public class ComTest {

	static int N,R;
	static int nums[];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		R = sc.nextInt();
		
		nums = new int [N];
		for (int i = 0; i < N; i++) {
			nums[i] = sc.nextInt();
		}
		nCr(0,0);
	}

}
