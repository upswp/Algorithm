package algorithm_gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * SSAFY BOJ 10026
 * 
 * @author Park Sangwoo
 * @since 2020-09-11
 * @use DFS
 */
public class BOJ10026_적록색약 {
	static int N;
	static char map[][];
	static boolean visit[][];
	static int res1,res2;
	static int cr [] = {0,0,-1,1};
	static int cc [] = {1,-1,0,0};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		visit = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			char[] input = br.readLine().toCharArray();
			for (int j = 0; j < N; j++) {
				map[i][j] = input[j];
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (visit[i][j] == false) {
					res1++;
					char tmp = map[i][j];
					dfs(i,j,tmp);
				}
			}
		}
	}

	public static void dfs(int r, int c, char tmp) {
		visit[r][c] = true;
		for (int d = 0; d < 4; d++) {
			int dr = r +cr[d];
			int dc = c+ cc[d];
			if (check(dr,dc))continue;
			if ()
		}
	}
}
