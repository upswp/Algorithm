package algorithm_gold;

import java.util.Scanner;

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
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		sc.nextLine();
		map = new char[N][N];
		visit = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			String s = sc.nextLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = s.charAt(j);
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
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 'G') {
					map[i][j] = 'R';
				}
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				visit[i][j] =false;
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (visit[i][j] == false) {
					res2 ++;
					char tmp = map[i][j];
					dfs(i, j, tmp);
				}
			}
		}
		System.out.println(res1 + " " + res2);
	}

	public static void dfs(int r, int c, char tmp) {
		visit[r][c] = true;
		for (int d = 0; d < 4; d++) {
			int dr = r +cr[d];
			int dc = c+ cc[d];
			if (!check(dr,dc))continue;
			if (map[dr][dc] == tmp && visit[dr][dc] ==false) {
				visit[dr][dc] = true;
				dfs(dr, dc, tmp);
			}
		}
	}

	private static boolean check(int dr, int dc) {
		if (dr < 0 || dc< 0 || dr>=N || dc>= N) {
			return false;
		}else return true;
	}
}
