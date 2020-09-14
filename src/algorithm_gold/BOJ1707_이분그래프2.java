package algorithm_gold;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ1707_이분그래프2 {
	static class Point { // 간선에 대한 두 정점의 정보
		int start;
		int end;
		boolean visit;

		public Point(int start, int end, boolean visit) {
			super();
			this.start = start;
			this.end = end;
			this.visit = visit;
		}

	}

	static int T;
	static int V, E;
	static Point pt;
	static int point[][];
	static boolean visit[];
	static ArrayList<Point> list = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null; // 입력시작
		T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine().trim());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			point = new int[E][2];
			visit = new boolean[V];

			for (int i = 0; i < E; i++) {
				String input[] = br.readLine().split(" ");
				for (int arr = 0; arr < 2; arr++) {
					point[i][0] = Integer.parseInt(input[0]); // 첫번째로 들어오는 애를 start
					point[i][0] = Integer.parseInt(input[1]); // 두번째로 들어오는 애를 end
					list.add(new Point(point[i][0], point[i][1], false)); // 각 간선의 정보를 point형식으로 list에 저장
				}
			} // 입력 끝
			for (int i = 0; i < list.size(); i++) {
				/*
				 * 리스트의 사이즈 만큼 반복하며 end값이 같을 경우 사이클이 발생하여 이분그래프의 조건이 형성되지 않으므로 list.get(i).end의
				 * 값을 기준으로 visit에 정점에 해당하는 index값을 입력하여 visit방문 여부를 체크해준다.
				 */
				if (!(list.get(i).visit && visit[list.get(i).end])) { // 입력된 간선의 정보를 조회하여 방문하지 않은 간선정보에 end값이
					list.get(i).visit = true; // 간선 정보 방문여부 체크
					visit[list.get(i).end] = true; // end정점에 왔다간적 있는지 체크
				}
			}
			for (int j = 0; j < list.size(); j++) {
				if (visit[list.get(j).end]) { // 해당 정점이 방문하려하면 사이클 발생
					System.out.println("NO");
				} else {					// 아닐경우 Yes
					System.out.println("YES");
				}

			}
		}
	}
}