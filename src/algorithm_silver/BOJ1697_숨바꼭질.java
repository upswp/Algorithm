package algorithm_silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1697_숨바꼭질 {
	
	static class Point{
		int move;
		int second;
		public Point(int move, int second) {
			super();
			this.move = move;
			this.second = second;
		}
	}
	
	static int N , K;
	static int max = 100001;
	static boolean [] visit = new boolean [max];
	static int [] road = new int [max];
	static Point tmp ;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		Queue<Point> que = new LinkedList<Point>();
		que.add(new Point(N,0));
		road[N] = 0;
		visit[N] = true;
		int [] cal = {1,-1,2};
		while(!que.isEmpty()) {
			tmp = que.poll();
			if (tmp.move == K) {
				System.out.println(tmp.second);
				return;
			}
			int move = 0;
			for (int d = 0; d < 3; d++) {
				if (d == 2) {
					move = tmp.move * cal[d];
				}else {
					move = tmp.move + cal[d];
				}
				if (check(move)) {
					visit[move]= true;
					road[move] = road[N]+1;
					que.add(new Point(move,tmp.second+1));
				}
			}
		}
	}
	public static boolean check(int move) {
		if (move >= 0 && move <= 100000 && visit[move] ==false) {
			return true;
		}else return false;
	}
	

}
