package algorithm_gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * BOJ 1987 알파벳
 * @author Park Sangwoo
 * @since 2020-10-18
 * @use dfs  , 백트래킹
 */
public class BOJ1987_알파벳 {

	static int R, C, cnt,res;
	static int map[][];
	static boolean visit[];
	static int dr[] = { 0, 0, 1, -1 };
	static int dc[] = { 1, -1, 0, 0 };

	public static void main(String[] args) throws Exception {
		/* 초기화 및 input */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		visit = new boolean[26];
		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j) - 'A'; // A = 0, B = 1, C = 2...
			}
		}
		/* 초기화 및 input */

		/* DFS */
		res = 0;
		dfs(0, 0, 1);
		System.out.println(res);

	}

	public static void dfs(int r, int c,int cnt) {
		if(res < cnt)res=cnt;
		if(cnt == 26) return;
		visit[map[r][c]] = true;
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if (!check(nr, nc) && !visit[map[nr][nc]]) {
				visit[map[nr][nc]] = true;
				dfs(nr, nc, cnt+1);
				visit[map[nr][nc]] = false;
			}
		}
	}

	public static boolean check(int nr, int nc) {
		if (nr < 0 || nr >= R || nc < 0 || nc >= C) return true;
		else return false;
	}
}
