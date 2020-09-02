package algorithm.BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/**
 * SSAFY BOJ 7576
 * 토마토
 * 
 * @author Park Sangwoo
 * @since 2020-08-26
 */
public class BOJ7576_토마토 {
	// 철수는 창고에 보관된 토마토들이 며칠이 지나면 다 익게 되는지, 그 최소 일수를 알고 싶어 한다.
	static int Answer;
	static int N, M;
	static Point[][] box; // 토마토가 들어간 위치
	static Queue<Point> que; // 내가 오늘 볼 토마토들
	static int[] di = { -1, 1, 0, 0 }; // 상하좌우
	static int[] dj = { 0, 0, -1, 1 };
	static int countTomato, boxcount; // 익은토마토 갯수, 토마토가 있는 박스의 수

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		que = new LinkedList<Point>();

		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());	//read
		N = Integer.parseInt(st.nextToken());	//read
		countTomato = 0;
		boxcount = N * M; //초기화

		box = new Point[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());	//read //세로 라인 갯수만큼 잘르겠다.
			for (int j = 0; j < M; j++) {
				box[i][j] = new Point(i, j, Integer.parseInt(st.nextToken())); // 읽은 수 만큼 값을 넣겠다.
				if (box[i][j].getValue() == 1) {
					que.offer(box[i][j]);
					countTomato++;
				}
				if (box[i][j].getValue() == -1) {
					boxcount--;
				}

			}
		}

		Answer = 0;
		
		
		//전체 토마토가 다 익어있는 상황
		if (que.size() == N * M) {
			Answer = 0;
			System.out.println(Answer);
			return;
		}

		while (!que.isEmpty()) {
			int qsize = que.size(); // 첫날 익어있는 토마토의 갯수
			for (int q = 0; q < qsize; q++) { //qsize를 통해서 늘어나는 탐색할 토마토의 수 ex ) 1->2->3 등등 
				Point p = que.poll(); //큐에 들어있는 애들을 순차적으로 날짜에 맞게 갯수 맞추어 뽑아냄.
				for (int d = 0; d < 4; d++) {
					int ni = di[d] + p.getPoint()[0];
					int nj = dj[d] + p.getPoint()[1];
					if (check(ni, nj) && box[ni][nj].getValue() == 0) { // ni,nj 주변토마토의 좌표
						box[ni][nj].setValue(); // 토마토를 익게함.
						que.offer(box[ni][nj]);//다음 탐색할 토마토들을 큐에 넣어줌.
						countTomato++;// 지금까지 익은 토마토의 갯수들을 카운트
					}
				}
			}
			Answer++; // 날짜 카운트
		}

		if (countTomato != boxcount) {
			Answer = -1;
			System.out.println(Answer);
			return;
		}
		System.out.println(Answer - 1); // 마지막날은 다 익었으니까 그 다음날을 더해줄 필요가 없으므로 카운트를 빼줌.
	}

	public static class Point {
		int i, j;
		int value;

		public Point(int i, int j, int value) {
			super();
			this.i = i;
			this.j = j;
			this.value = value;
		}

		public int[] getPoint() {
			return new int[] { i, j };
		}

		public int getValue() {
			return value;
		}

		public void setValue() {
			this.value = 1;
		}
	}

	public static boolean check(int i, int j) {
		if (i >= N || i < 0 || j >= M || j < 0) //테두리 밖으로 나갈 경우를  false
			return false;
		else // 사용할 수 있는 범위 실제 범위
			return true;
	}
}