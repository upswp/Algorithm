package algorithm.combination;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * BOJ 15686 치킨배달
 * @author Park Sangwoo
 * @use nCr, memoization
 * @since 2020-08-31
 */
public class BOJ15686_치킨배달_memoization {
	static int N, M, res;
	static int[][] map, dist;
	static int[] select;
	static ArrayList<Point> chickens = new ArrayList<>();
	static ArrayList<Point> homes = new ArrayList<>();
	
	static class Point{
		int r;
		int c;
		public Point(int r, int s) {
			super();
			this.r = r;
			this.c = s;
		}
		public Point() {}
	}
	static int cal(Point p1, Point p2) {
		return Math.abs(p1.r - p2.r) + Math.abs(p1.c-p2.c);
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		dist = new int [14][101];
		map = new int [N][M];
		//====입력부분 START=====
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) {
					homes.add(new Point(i,j));
				}else if(map[i][j] == 2) {
					chickens.add(new Point(i,j));
				}
			}
		}
		//====입력부분 END=====
		//====메모이제이션START===== 
		select = new int [14];// 치킨집 방문여부
		for (int i = 0; i < chickens.size(); i++) {
			for (int j = 0; j < homes.size(); j++) {
				dist[i][j] = cal(chickens.get(i), homes.get(j));
			}
		}
		nCr(0,0);
		System.out.println(res);
	}

	private static void nCr(int cnt, int start) {
		if (cnt == M) {
			res = Math.min(res, solve());
		}
		//페업 시키지 않을 전체 치킨집 중 M개 고르기.
		for (int i = start; i < chickens.size(); i++) {
			select[cnt] = i;
			nCr(cnt+1, i+1);
			select[cnt] = 0;
		}
	}
	//집을 기준으로 가장 가까운 치킨집까지의 거리
	private static int solve() {
		int res = 0;
		for (int i = 0; i < homes.size(); i++) {
			int min = Integer.MAX_VALUE;
			for (int j = 0; j < chickens.size(); j++) {
				min = Math.min(min, dist[select[i]][j]);
			}
			//res: 치킨거리
			res += min;
		}
		return res;
	}
}
