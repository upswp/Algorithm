package algorithm_gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution1953_탈주범검거 {

	static int N, M, R, C, L;
	static int[][] map;
	static int[][] visited;
	static int T;
	static int cnt;
	static int[] dr = { -1, 0, 0, 1 };
	static int[] dc = { 0, -1, 1, 0 };
	static int[][] block_hole = { {0}, // 0번 블럭 없음
			{0,1,2,3},
			{0,3},
			{1,2},
			{0,2},
			{2,3},
			{1,3},
			{0,1}};			;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			map = new int[N][M];
			visited = new int[N][M];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			} // end input
			cnt = 0;
			bfs();
			counting();
			System.out.println("#"+tc+" "+cnt);
		} // end test-case
		br.close();
	}
	static void counting() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(visited[i][j] > 0 && visited[i][j] < L+1) {
					cnt++;
				}
			}
		}
	}
	
	private static void bfs() {
		Queue<int[]> que = new LinkedList<>();
		que.add(new int [] {R,C,map[R][C],1}); //R, C , D(방향), 시간(time)
		visited[R][C] = 1; // 1 2 3 ->> 지나간 거리를 확인하기.
		while(!que.isEmpty()) {
			int [] cur = que.poll();
			int cr = cur[0];
			int cc = cur[1];
			int cd = cur[2];
			int ct = cur[3];
			if (ct == L) {
				return;
			}
			for (int d = 0; d < block_hole[cd].length; d++) {
				int dir = block_hole[cd][d]; // 다음방향
				int nr = cr + dr[dir];
				int nc = cc + dc[dir];
				if (!check(nr,nc)) continue;
				if (map[nr][nc] == 0) continue;
				if (visited[nr][nc]!=0) continue;
				//현방향 + 다음방향의 파이프 연결 가능여부
				int p = map[nr][nc]; // 다음방향
				if (dir == 0) {//위
					if(p==3 || p== 4 || p ==7) continue;
				}else if(dir == 1) {//
					if(p==2 || p== 6 || p ==7) continue;
				}else if(dir == 2) {//
					if(p==2 || p== 4 || p ==5) continue;
				}else if(dir == 3) {//
					if(p==3 || p== 5 || p ==6) continue;
				}
				
				visited[nr][nc] = visited[cr][cc] +1;
				que.add(new int [] {nr,nc,map[nr][nc],ct+1});
			}
		}
	}

	static boolean check(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < N;
	}

}