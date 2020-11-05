package algorithm_gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ14716_현수막 {

	static int N, M, map[][];
	static int dr[] = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int dc[] = { 0, 1, 1, 1, 0, -1, -1, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int cnt = 1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1) {
					cnt++;
					bfs(i, j, cnt); // 좌표r, c , count
				}
			}
		}

		System.out.println(cnt - 1);
	}

	static void bfs(int r, int c, int count) {
		Queue<Point> que = new LinkedList<>();
		que.add(new Point(r, c));
		map[r][c] = count;
		while (!que.isEmpty()) {
			Point now = que.poll();
			int cr = now.r;
			int cc = now.c;
			for (int d = 0; d < 8; d++) {
				int nr = cr + dr[d];
				int nc = cc + dc[d];
				if (nr >= 0 && nr < N && nc >= 0 &&+ nc < M && map[nr][nc] == 1) {
					map[nr][nc] = count;
					que.add(new Point(nr, nc));
				}
			}
		}

	}

	static class Point {
		int r;
		int c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}

}
