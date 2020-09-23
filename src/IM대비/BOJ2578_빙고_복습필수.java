package IM대비;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Samsung SW역량 테스트 IM대비 BOJ 2578 빙고
 * 
 * @author Park Sangwoo
 * @since 2020-09-23
 */
public class BOJ2578_빙고_복습필수 {
	static int[][] map;
	static int[] check;
	static int cnt;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new int[5][5];
		check = new int[25];

		for (int i = 0; i < 5; i++) {
			String input[] = br.readLine().split(" ");
			for (int j = 0; j < 5; j++) {
				map[i][j] = Integer.parseInt(input[j]);
			}
		}

		for (int i = 0, k = 0; i < 5; i++) {
			String input[] = br.readLine().split(" ");
			for (int j = 0; j < 5; j++, k++) {
				check[k] = Integer.parseInt(input[j]);
			}
		}
		System.out.println(checkBinggo());
	}

	private static int checkBinggo() {
		int cnt = 0;
		for (int i = 0; i < 25; i++) {
			for (int a = 0; a < 5; a++) {
				for (int b = 0; b < 5; b++) {
					if (map[a][b] == check[i]) {
						map[a][b] = 0;
						cnt += check(a,b);
						if (cnt>=3) return i+1;
					}
				}
			}
		}

		return 0;
	}
	private static int[] dr = {-1,0,-1,1,-1,1,0,1};
	private static int[] dc = {0,-1,-1,-1,1,1,1,0};

	private static int check(int a, int b) {
		int cnt = 0;
		for (int d = 0; d < 4; d++) {
			if (checkLine(a,b,d) + checkLine(a,b,7-d) == 4) cnt++; 
		}
		return cnt;
	}

	private static int checkLine(int a, int b, int d) {
		int nr = a, nc = b, tmp = 0;
		while(true) {
			nr += dr[d];
			nc += dc[d];
			if (nr >=0 && nr <5 &&nc>= 0 && nc<5 && map[nr][nc] ==0) tmp++;
			else break;
		}
		return tmp;
	}

}