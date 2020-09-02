package algorithm_bronze;

import java.util.Scanner;

/**
 * SSAFY BOJ 1592
 * 
 * 영식이와 친구들
 * 
 * @author Park Sangwoo
 * @since 2020-08-17
 */
public class BOJ1592_영식이와친구들 {

	static int N, M, L;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		L = sc.nextInt();

		int arr[] = new int[N];

		int cnt = 0;
		int index = 0;
		while (true) {
			arr[index]++; //공 받은 해당 index의 값을 올려주기.
			if (arr[index] == M) {
				break;
			}
			// 짝수일때 반시계방향
			if (arr[index] % 2 == 0) {
				if (index - L < 0) {
					index = index - L + N;
				} else {
					index = index - L;
				}
				// 홀수일때 시계방향
			} else if (arr[index] % 2 == 1) {
				if (index + L >= N) {
					index = index + L - N;
				} else {
					index = index + L;
				}
			}
			cnt++;
		}
		System.out.println(cnt);
	}

}
