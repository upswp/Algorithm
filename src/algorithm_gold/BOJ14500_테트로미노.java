package algorithm_gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14500_테트로미노 {

	static int N, M, map[][];
	static int max = Integer.MIN_VALUE;
	static int dr[] = { -1, 0, 1, 0 };
	static int dc[] = { 0, 1, 0, -1 };
	static boolean visited[][];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				dfs2(i, j);
				dfs(i, j, map[i][j], 1);
			}
		}

		System.out.println(max);

	}
	static void dfs2(int r, int c) {
		for (int d = 0; d < 4; d++) {
			int sum = map[r][c]; 
			for (int i = 0; i < 4; i++) {
				if (d != i) {
					int nr = r + dr[i];
					int nc = c + dc[i];
					if (nr >= 0 && nr < N && nc >= 0 && nc < M ) {
						sum += map[nr][nc];
					}
				}
			}
			max = Math.max(max, sum);
		}
	}
	
	static void dfs(int r, int c, int sum, int count) {
		if (count == 4) {
			max = Math.max(max, sum);
			return;
		}
		visited[r][c] = true;			/*중요*/
		
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if (nr >= 0 && nr < N && nc >= 0 && nc < M && !visited[nr][nc]) {
				visited[nr][nc] = true;
				dfs(nr, nc, sum + map[nr][nc], count + 1);
				visited[nr][nc] = false;
			}
		}
		visited[r][c] = false;			/*중요*/
	}
}
