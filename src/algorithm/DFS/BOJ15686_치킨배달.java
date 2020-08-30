package algorithm.DFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * BOJ 15686 치킨배달
 * 
 * @author Park Sangwoo
 * @use nCr, memoization
 * @since 2020-08-31
 */
public class BOJ15686_치킨배달 {
	static class Point {
		int r;
		int c;

		public Point() {
			super();
		}

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}

	static int calc(Point p1, Point p2) {
		return Math.abs(p1.r - p2.r) + Math.abs(p1.c - p2.c);
	}

	static ArrayList<Point> houses;
	static ArrayList<Point> chickens;
	static boolean[] v;
	static int[] select;
	static int[][] map;
	static int result;
	static int N, M;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		houses = new ArrayList<>();
		chickens = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) {
					houses.add(new Point(i, j));
				} else if (map[i][j] == 2) {
					chickens.add(new Point(i, j));
				}
			}
		}
		v = new boolean[chickens.size()];
		select = new int[chickens.size()];
		result = Integer.MAX_VALUE;
		for (int i = 0; i < chickens.size(); i++) {
			v[i] = true;
			nCr(i, 0);
			v[i] = false;
		}
		System.out.println(result);
	}

	public static void nCr(int start, int depth) {
		select[depth] = start;
		if (depth == M - 1) {
			int sum = 0;
			int dist = 0;
			for (int i = 0; i < houses.size(); i++) {
				int min = Integer.MAX_VALUE;
				for (int j = 0; j < M; j++) {
					dist = calc(houses.get(i), chickens.get(select[j]));
					min = Math.min(min, dist);
				}
				sum += min;
			}
			result = Math.min(result, sum);
			return;
		}
		for (int i = start; i < chickens.size(); i++) {
			if (v[i]) {
				continue;
			}
			v[i] = true;
			nCr(i, depth + 1);
			v[i] = false;
		}
	}
}
