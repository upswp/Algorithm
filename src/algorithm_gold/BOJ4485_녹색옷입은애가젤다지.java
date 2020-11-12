package algorithm_gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ4485_녹색옷입은애가젤다지 {
	
	static int N , visit[][], map[][];
	static int dr [] = {-1,0,1,0};
	static int dc [] = {0,1,0,-1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int cnt = 0;
		while(true) {
			N = Integer.parseInt(br.readLine());
			if (N == 0) {
				break;
			}
			map = new int [N][N];
			visit = new int [N][N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine()," ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					visit [i][j]= Integer.MAX_VALUE;
				}
			}
			
			bfs();
			
			cnt++;
			sb.append("Problem").append(" ").append(cnt).append(": ").append(visit[N-1][N-1]).append("\n");
		}
		System.out.print(sb);
	}
	
	static void bfs() {
		Queue<Point> que = new LinkedList<>();
		que.add(new Point(0,0));
		visit[0][0] = map[0][0];
		while(!que.isEmpty()) {
			Point now = que.poll();
			int cr = now.r;
			int cc = now.c;
			for (int d = 0; d < 4; d++) {
				int nr = cr + dr[d];
				int nc = cc + dc[d];
				if (!check(nr,nc)) continue; 
				if (visit[nr][nc] > visit[cr][cc]+map[nr][nc]) {
					visit[nr][nc] = visit[cr][cc]+map[nr][nc];
					que.add(new Point(nr,nc));
				}
			}
		}
	}
	
	static boolean check(int nr, int nc) {
		return nr>=0 && nr<N && nc>=0 && nc<N;
	}
	
	static class Point{
		int r;
		int c;
		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}

}
