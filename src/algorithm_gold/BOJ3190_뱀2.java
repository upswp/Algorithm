package algorithm_gold;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class BOJ3190_뱀2 {

	static class Snake{ // 뱀 위치
		int r;
		int c;
		public Snake() {}
		public Snake(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
	static class Turn{ 	// 방향 D = 1 L = 3
		int time;
		int dir;
		public Turn() {}
		public Turn(int time, int dir) {
			super();
			this.time = time;
			this.dir = dir;
		}
	}
	static int cnt;
	static int N,K,L;
	static int map[][];
	static ArrayList<Snake> snakes = new ArrayList<>();
	static ArrayList<Turn>  turns = new ArrayList<>();
	
	static int [] dr = {0,1,0,-1};
	static int [] dc = {1,0,-1,0};
	
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		//테두리 때문에 +2
		map = new int [N+2][N+2];
		for (int i = 0; i < N+2; i++) {
			Arrays.fill(map[i],2);
		}
		for (int i = 1; i < N+1; i++) {
			for (int j = 1; j < N+1; j++) {
				map[i][j] = 0;
			}
		}
		for (int i = 0; i < K; i++) {
			int r = sc.nextInt();
			int c = sc.nextInt();
			map[r][c] = 1; // 사과는 1
		}
		
		L = sc.nextInt();
		for (int i = 0; i < L; i++) {
			int x = sc.nextInt();
			char cdir = sc.next().charAt(0);
			int dir = cdir=='D'?1:3;
			
			turns.add(new Turn(x,dir));
		}
		
		cnt = 0;
		solve(1,1,0);
		System.out.println(cnt);
		
	}
	
	static void solve(int cr, int cc, int cdir) {
		snakes.add(new Snake(cr,cc));
		int turn = 0;

		for (int i = 1; i < 10000; i++) {
			cnt++;
			int nr = cr + dr[cdir];
			int nc = cc+ dc[cdir];
			if (isFinish(nr, nc)) return;
			if(map[nr][nc] == 1) {
				map[nr][nc] = 0;
				snakes.add(new Snake(nr,nc));
			}else {
				snakes.add(new Snake(nr,nc));
				snakes.remove(0);
			}
			
			cr = nr;
			cc = nc;
			if (turn < L) {
				if (cnt == turns.get(turn).time) {
					//방향바꾸기.
					cdir = (cdir + turns.get(turn).dir) % 4;
					turn++;
				}
			}
		}
		
		
		
	}
	
	public static boolean isFinish(int r, int c) {
		if(!isIn(r,c)) return true;
		for (int i = 0; i < snakes.size(); i++) {
			Snake snake = snakes.get(i);
			if (snake.r == r && snake.c == c) return true;
		}
		return false;
	}
	
	
	
	public static boolean isIn(int r, int c) {
		return r>=1 && r<=N && c>=1 && c<=N;
	}
}