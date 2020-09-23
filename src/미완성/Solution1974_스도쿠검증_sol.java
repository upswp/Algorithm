package 미완성;

import java.util.Scanner;

public class Solution1974_스도쿠검증_sol {

	static int[][] map = new int[9][9];
	static int[] visit = new int[10]; // 9 + 1
	static int result;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			result = 1;
			// row
			for (int i = 0; i < 9; i++) {
				init();
				for (int j = 0; j < 9; j++) {
					visit[map[i][j]]++;
				}
				if (!check()) {
					result = 0;
					break;
				}
			}
			if (result == 0) {
				System.out.println("#" + tc + " " + result);
				continue;
			}
			// col
			for (int i = 0; i < 9; i++) {
				init();
				for (int j = 0; j < 9; j++) {
					visit[map[j][i]]++;
				}
				if (!check()) {
					result = 0;
					break;
				}
			}
			if (result == 0) {
				System.out.println("#" + tc + " " + result);
				continue;
			}
			// 3x3
			outer: for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					init();
					// 3x3
					for (int r = i * 3; r < i * 3 + 3; r++) {
						for (int c = j * 3; c < j * 3 + 3; c++) {
							visit[map[r][c]]++;
						}
					}
					if (!check()) {
						result = 0;
						break outer;
					}
				}
			}
			System.out.println("#" + tc + " " + result);
		}
		sc.close();
	}
	static boolean check() {
		for (int i = 1; i <= 9; i++) {
			if (visit[i] == 0)
				return false;
		}
		return true;
	}
	static void init() {
		for (int i = 1; i <= 9; i++) {
			visit[i] = 0;
		}
	}
}
