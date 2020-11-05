package algorithm_gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ3055_탈출 {

	static class Point {
		int r;
		int c;
		int len;

		public Point(int r, int c,int len) {
			super();
			this.r = r;
			this.c = c;
			this.len = len;
		}
	}

	static int R, C, time = 0, ans;
	static int Dr,Dc;
	static char map[][];
	static boolean visited[][];
	static String impossible = "KAKTUS";
	static Queue<Point> water = new LinkedList<Point>();
	static Queue<Point> queueS = new LinkedList<Point>();
	static int dr[] = { -1, 1, 0, 0 };
	static int dc[] = { 0, 0, -1, 1 };
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		ans = Integer.MAX_VALUE;
		map = new char[R][C];
		visited = new boolean[R][C];
		/* 입력 및 S와 물이 차있는 곳 찾 */
		for (int i = 0; i < R; i++) {
			String input = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = input.charAt(j);
				if (map[i][j] == '*') {
					water.add(new Point(i, j , 0));
				}
				if (map[i][j] == 'S') {
					queueS.add(new Point(i, j, 0));
				}
				if (map[i][j] == 'D') {
					Dr = i;
					Dc = j;
				}
			}
		}
		/* 입력 및 S와 물이 차있는 곳 찾기 */
		
		/*두더지 움직이기*/
		simulS();
			
		if (ans == Integer.MAX_VALUE) {
			System.out.println(impossible);
		}else System.out.println(ans);
		br.close();
	}

	static void simulW() {
		int size = water.size();
		for (int s = 0; s < size; s++) {
			Point now = water.poll();
			for (int d = 0; d < 4; d++) {
				int cr = now.r + dr[d];
				int cc = now.c + dc[d];
				if (!check(cr, cc)) continue;
				if (map[cr][cc] == '.' || map[cr][cc] =='S') {
					water.add(new Point(cr, cc,0));
					map[cr][cc] = '*';
				}
			}
		}
	}

	static void simulS() {
		while (!queueS.isEmpty()) {
			/*비버 움직이기 전에 물 움지기이기*/
			simulW();
			int size = queueS.size();
			for (int s = 0; s < size; s++) {
				Point now = queueS.poll();
				visited[now.r][now.c] = true; 
				for (int d = 0; d < 4; d++) {
					int nr = now.r + dr[d];
					int nc = now.c + dc[d];
					if (!check(nr, nc)) continue;
					if (!visited[nr][nc]  && (map[nr][nc] == '.')) {
						visited[nr][nc] = true;
						map[nr][nc] = 'S';
						map[now.r][now.c] = '.';    /*visited를 안써도 됨 어차피 S로 전부 되면 S가 다시 못돌아가니까*/
						queueS.add(new Point (nr,nc,now.len+1));
//						print();
//						System.out.println();
					}
					else if(nr== Dr && nc== Dc) ans = Math.min(ans, now.len+1); /*위치 바꾸니까 되네?*/
				}
			}
		}
	}
	static boolean check(int r, int c) {
		if (r >= 0 && r < R && c >= 0 && c < C) {
			return true;
		}
		return false;
	}
	
	static void print() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}
}
