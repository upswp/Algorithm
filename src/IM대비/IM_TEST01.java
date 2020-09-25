package IM대비;

import java.util.Scanner;
/**
 * SSAFY Samsumg SW 역량 Test <IM등급>
 * @author Park Sangwoo
 * @since 2020-09-25
 */
public class IM_TEST01 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int K = sc.nextInt();

			int signal[] = new int[N];
			int password[] = new int[K];
			boolean visitSignal[] = new boolean[N];
			boolean visitPW[] = new boolean[K];
			// 입력 시작
			for (int i = 0; i < signal.length; i++) {
				signal[i] = sc.nextInt();
			}

			for (int i = 0; i < password.length; i++) {
				password[i] = sc.nextInt();
			}
			// 입력 끝

			for (int i = 0; i < K; i++) {
				for (int j = 0; j < N; j++) {
					if (!visitSignal[j]) {
						visitSignal[j] = true;
						if (signal[j] == password[i]) {
							visitPW[i] = true;
							break;
						}
					}
				}
			}
			int res = 0;
			for (int i = 0; i < K; i++) {
				if (visitPW[i]) {
					res = 1;
				} else {
					res = 0;
				}
			}

			if (res == 1) {
				System.out.println("#" + t + " " + 1);
			} else {
				System.out.println("#" + t + " " + 0);
			}
		}
	}

}
