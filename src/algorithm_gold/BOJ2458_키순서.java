package algorithm_gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2458_키순서 {

	static class Point{
		int r;
		int c;
		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
	
	static int N, M, map[][], input[][],cnt;
	static int dr [] = {0,0,-1,1};
	static int dc [] = {1,-1,0,0};
	static boolean visited[][];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		visited = new boolean[N+1][N+1];
		map = new int[N+1][N+1];
		input = new int[M][2];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			input[i][0] = Integer.parseInt(st.nextToken());
			input[i][1] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 1; i < N+1; i++) {
			for (int j = 1; j < N+1; j++) {
				for (int k = 0; k < M; k++) {
					if (i == input[k][0] && j == input[k][1]) {
						map[i][j] = 1;
						map[j][i] = 1;
					}
				}
			}
		}
		
		
		print();
		for (int i = 1; i < N+1; i++) {
			for (int j = 1; j < N+1; j++) {
				if (map[i][j] == 0 && !visited[i][j]) {
					findzero(i,j,0);
				}
			}
		}
		System.out.println(cnt);
	}
	
    private static void findzero(int r, int c, int countOne) {
    	visited[r][c] = true;
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if (!check(nr,nc)) continue;
			if (map[nr][nc] != 1) continue;
			++countOne;
		}
		if (countOne == 4) {
			cnt++;
			return;
		}
	}

	static boolean check(int r, int c) {
        if (r >= 1 && r < N+1 && c >= 1 && c < N+1) {
            return true;
        }
        return false;
    }
	
	private static void print() {
		for (int i = 1; i < N + 1; i++) {
			for (int j = 1; j < N + 1; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
}
