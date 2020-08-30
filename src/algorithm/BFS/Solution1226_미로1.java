package algorithm.BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * SWEA 1226 미로 1
 * 
 * @author Park Sangwoo
 * @use BFS
 * @since 2020-08-31
 */
public class Solution1226_미로1 {

	static int T = 10;
	static int map[][];
	static int dr[] = { -1, 1, 0, 0 };
	static int dc[] = { 0, 0, 1, -1 };
	static int visit[][];
	static int cnt, startR, startC, endR, endC;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int t = 1; t <= T; t++) {
			br.readLine();
			map = new int[16][16];
			visit = new int[16][16];
			for (int i = 0; i < 16; i++) {
				char[] input = br.readLine().toCharArray();
				for (int j = 0; j < 16; j++) {
					map[i][j] = input[j] - '0';
				}
			}
			// 시작점과 끝점 잡기.
			for (int r = 0; r < 16; r++) {
				for (int c = 0; c < 16; c++) {
					if (map[r][c] == 2) {
						startR = r;
						startC = c;
					} else if (map[r][c] == 3) {
						endR = r;
						endC = c;
					}
				}
			}
			cnt = 0;
			Queue<Point> que = new LinkedList<Point>();
			que.offer(new Point(startR, startC));
			visit[startR][startC] = 1;
			while (!que.isEmpty()) {
				Point pt = que.poll();
				for (int d = 0; d < 4; d++) {
					int nr = pt.r + dr[d];
					int nc = pt.c + dc[d];
					if (endR == nr && endC == nc) {
						cnt = 1;
						break;
					}
					if (!check(nr, nc)) {
						continue;
					}
					if (map[nr][nc] == 0 && visit[nr][nc] == 0) {
						que.offer(new Point(nr, nc));
						visit[nr][nc] = 1;
					}
				}
			}
			System.out.println("#" + t + " " + cnt);
		}
	}

	public static boolean check(int nr, int nc) {
		if (nr >= 0 && nr < 16 && nc >= 0 && nc < 16) {
			return true;
		} else
			return false;
	}

	private static class Point {
		int r;
		int c;

		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

}
