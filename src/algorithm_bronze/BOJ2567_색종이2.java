package algorithm_bronze;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * SSAFY BOJ
 * 
 * 색종이 2
 * 
 * @author Park Sangwoo
 * @since 2020-08-16
 */
public class BOJ2567_색종이2 {
	static int[][] map;
	static int N;
	static int[] dr = { 0, 0, 1, -1 };
	static int[] dc = { 1, -1, 0, 0 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		map = new int[101][101];
		N = sc.nextInt();
		int cnt = 0;
		// 색종이 갯수만큼 색종이 영역을 1로 초기화
		for (int t = 0; t < N; t++) {
			int x = sc.nextInt(); // x좌표
			int y = sc.nextInt();// y좌표

			for (int i = x; x < x + 10; x++) {
				for (int j = y; y < y + 10; y++) {
					map[i][j] = 1;
				}
			}
		}
//		bfs(, j, cnt);
		for (int i = 1; i <= 100; i++) {
			for (int j = 1; j <= 100; j++) {
//					print();
			}
		}
		System.out.println(cnt);
	}

	private static int bfs(int i, int j, int cnt) {
				if (map[i][j] == 1) {
					for (int d = 0; d < 4; d++) {
						int r = i + dr[d];
						int c = j + dc[d];
						// 경계값 체크
						if (check(r, c)) {
							cnt++;
						}
					}
				}
		return cnt;
	}
	private static boolean check(int r, int c) {
		if (r < 100 && r > 0 && c < 100 && c > 0 && map[r][c] == 0) {
			return true;
		} else
			return false;
	}
	private static void print() {
		for (int i = 0; i < 101; i++) {
			for (int j = 0; j < 101; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
		
	}
}
