package algorithm_gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1600_말이되고픈원숭이 {

	static int K;
	static int H, W, ans;
	static int map[][];

	static int[] dr = { 0, 0, 1, -1 };
	static int[] dc = { 1, -1, 0, 0 };
	static int[] sdr = { -2, -1, 1, 2, 2, 1, -1, -2 };
	static int[] sdc = { 1, 2, 2, 1, -1, -2, -2, -1 };
	

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		K = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());

		map = new int[H][W];

		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < W; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

//		for (int i = 0; i < H; i++) {
//			for (int j = 0; j < W; j++) {
//				System.out.print(map[i][j]+" ");
//			}
//			System.out.println();
//		}

		ans = -1;
		bfs();
		System.out.println(ans);
	}

	static void bfs() {
		boolean[][][] visit = new boolean[H][W][K + 1];
		visit[0][0][0] = true;

		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(0, 0, 0));

		int time = 0;
		while (!queue.isEmpty()) {

			int size = queue.size();

			for (int s = 0; s < size; s++) {
				Point now = queue.poll();

				if (now.r == H - 1 && now.c == W - 1) {
					ans = time;
					return;
				}

				for (int d = 0; d < 8; d++) {
					int nr = now.r + sdr[d];
					int nc = now.c + sdc[d];
					int nk = now.k + 1;

					if (nr >= 0 && nr < H && nc >= 0 && nc < W && map[nr][nc] == 0 && nk <= K && !visit[nr][nc][nk]) {
						queue.add(new Point(nr, nc, nk));
						visit[nr][nc][nk] = true;
					}//if end
				}// for end

				for (int d = 0; d < 4; d++) {
					int nr = now.r + dr[d];
					int nc = now.c + dc[d];
					int nk = now.k;

					if (nr >= 0 && nr < H && nc >= 0 && nc < W && map[nr][nc] == 0 && !visit[nr][nc][nk]) {
						queue.add(new Point (nr,nc,nk));
						visit[nr][nc][nk] = true; 
					}//if end
				}// for end
			}//size for end
			time ++;
		}//while end
	}//bfs end

	static class Point {
		int r;
		int c;
		int k;

		public Point(int r, int c, int k) {
			super();
			this.r = r;
			this.c = c;
			this.k = k;
		}
	}
}
