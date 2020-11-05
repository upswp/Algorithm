package algorithm_silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ3187_양치기꿍 {

	static int R, C, K, V;
	static char map[][];
	static boolean visited[][];

	static int dr[] = { -1, 0, 1, 0 };
	static int dc[] = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		visited = new boolean[R][C];

		for (int i = 0; i < R; i++) {
			char input[] = br.readLine().toCharArray();
			for (int j = 0; j < C; j++) {
				map[i][j] = input[j];
			}
		}

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if ((map[i][j] == 'k' || map[i][j] == 'v')&& !visited[i][j]) { /*!visited[i][j] 진입시 조건 추가 꼭 해주기*/
					bfsFence(i, j);
				}
			}
		}
		sb.append(K).append(" ").append(V);
		System.out.print(sb);
		br.close();
	}

	static void bfsFence(int r, int c) {
		Queue<Point> que = new LinkedList<>();
		int countK = 0;
		int countV = 0;
		if (map[r][c] =='k') {
			countK = 1;
		}else {
			countV = 1;
		}
		visited[r][c] = true;
		que.add(new Point(r, c));
		
		while (!que.isEmpty()) {
			Point now = que.poll();
			int cr = now.r;
			int cc = now.c;
			for (int d = 0; d < 4; d++) {
				int nr = cr + dr[d];
				int nc = cc + dc[d];
				if (!check(nr, nc) && !visited[nr][nc] && map[nr][nc] == '.') {
					visited[nr][nc] = true;
					que.add(new Point(nr, nc));
				} else if (map[nr][nc] == 'k' && !visited[nr][nc] && !check(nr, nc)) {
					visited[nr][nc] = true;
					countK+=1;
					que.add(new Point(nr, nc));
				} else if (map[nr][nc] == 'v' && !visited[nr][nc] && !check(nr, nc)) {
					visited[nr][nc] = true;
					countV+=1;
					que.add(new Point(nr, nc));
				} 
			}// end d
		}// end que
		
		if (countV < countK) {
			countV = 0;
			K += countK;
		}
		else {
			countK = 0;
			V += countV;
		}
	}
	
	static boolean check(int nr, int nc) {
		if (nr < 0 && nr >= R && nc < 0 && nc >= C)
			return true;
		else
			return false;
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
