package algorithm_gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Solution1249_보급로_sol {
	
	static int T,N, map[][],dist [][];
	static int dr[] = {-1,0,1,0};
	static int dc[] = {0,1,0,-1};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new int [N][N];
			dist = new int [N][N];
			
			for (int i = 0; i < N; i++) {
				char [] input = br.readLine().toCharArray();
				for (int j = 0; j < N; j++) {
					map[i][j] = input[j] -'0';
					dist[i][j] = Integer.MAX_VALUE/1000;  // 최대값으로 채우기.
				}
			}
			
			bfs();
			
			sb.append("#").append(tc).append(" ").append(dist[N-1][N-1]).append("\n");
		}
		System.out.print(sb);
	}
	static void bfs() {
		Queue<Point> que = new LinkedList<>();
		que.add(new Point(0,0));
		dist[0][0] = 0;
		
		while(!que.isEmpty()) {
			Point now =  que.poll();
			int cr = now.r;
			int cc = now.c;
			//최소시간이지 최단거리가 아님!!
//			if (cr==N-1 && cc==N-1) {
//				break;
//			}
			for (int d = 0; d < 4; d++) {
				int nr = cr + dr[d];
				int nc = cc + dc[d];
				if (!check(nr,nc)) continue;
				
				if (dist[nr][nc] > dist[cr][cc]+map[nr][nc] ) {
					dist[nr][nc] = dist[cr][cc]+map[nr][nc] ;
					que.add(new Point(nr,nc));
				}
			}
		}
	}
	
	static boolean check(int nr,int nc) {
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
