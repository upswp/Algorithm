package algorithm_silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * BOJ 1012 유기농배추
 * @author Park Sangwoo
 * @since 2020-10-11
 */
public class BOJ1012_유기농배추_bfs {
	static int T, M, N, K, map[][],cnt;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		T = Integer.parseInt(br.readLine());		//Testcase
		for (int testcase = 0; testcase < T; testcase++) {
			st = new StringTokenizer(br.readLine()," ");
			M = Integer.parseInt(st.nextToken());	//가로길이 배추밭의 가로길이 M(1 ≤ M ≤ 50)
			N = Integer.parseInt(st.nextToken());	//세로길이 N(1 ≤ N ≤ 50)
			K = Integer.parseInt(st.nextToken());	//배추가 심어져 있는 위치의 개수 K(1 ≤ K ≤ 2500)
			map = new int [N][M];
			cnt = 1;
			
			//K줄에는 배추의 위치 X(0 ≤ X ≤ M-1), Y(0 ≤ Y ≤ N-1)
			for (int k = 0; k < K; k++) {
				st = new StringTokenizer(br.readLine()," ");
				int y = Integer.parseInt(st.nextToken());	//배추 위치 x	
				int x = Integer.parseInt(st.nextToken());	//배추 위치 y
				map[x][y] = 1;
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] == 1) {
						bfs(i,j,++cnt);
					}
				}
			}
			System.out.println(cnt-1);
		}
	}
	
	//사방탐색 BFS
	static int dr [] = {0,0,1,-1};
	static int dc [] = {1,-1,0,0};
	public static void bfs(int r, int c, int cnt) {
		Queue<int []> que = new LinkedList<int []>();
		que.offer(new int[] {r,c});
		map[r][c] = cnt;
		while(!que.isEmpty()) {
			int [] curr = que.poll();
			int cr = curr[0];
			int cc = curr[1];
			for (int d = 0; d < 4; d++) {
				int nr = cr + dr[d];
				int nc = cc + dc[d];
				if (check(nr,nc)) continue;
				if (map[nr][nc] == 1) {
					map[nr][nc] = cnt;
					que.offer(new int[] {nr,nc});
				}
			}
		}
	}

	private static boolean check(int nr, int nc) {
		if (nr < 0 || nr >=N || nc<0 || nc >=M) {
			return true;
		}else return false;
	}
}
