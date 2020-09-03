package algorithm_silver;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ1697_숨바꼭질3 {
	static class Point {
		int location;
		int time;

		public Point(int location, int time) {
			this.location = location;
			this.time = time;
		}
	}

	static Queue<Point> soo;
	static Point tmp;
	static int N, K;
	static int visited[];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		K = sc.nextInt();

		/*
		 * 
		 * visit배열을 만든다. 수빈이의 이동경로를 하나하나 기록할거다
		 */
		visited = new int[100001];

		// 수빈이 객체 만든다
		soo = new LinkedList<Point>();
		soo.add(new Point(N, 1)); // 수빈있는 곳을 스타트 점으로 큐에 넣어준다

		// 수빈이 지금 있는곳 방문체크 안해서 혼났다
		visited[N] = 1;

		// 수빈이가 더이상 갈 수가 없을때 끝낸다
		while (!soo.isEmpty()) {
			// 큐에있는 수빈이 원소 하나 가져온다
			tmp = soo.poll();
			/*
			 * 
			 * 혹시 수빈이가 동생이랑 만났다? 끝내버린다 static으로 선언해서 현시점 수빈이는 자동으로 기억된다
			 */
			if (tmp.location == K)
				break;

			/*
			 * 
			 * 좀 낚시 아닌 낚시인데, 100000까지는 값을 가질수있다 경계값에 꼭 포함시켜주자
			 * 
			 * 물론 해당 지점에 아무도 선수치지 않았어야한다. 누가 미리 왔었다면 난 이미 최단 경로로 오지 않았으니까 컷.
			 */
			if (tmp.location * 2 <= 100000 && visited[tmp.location * 2] == 0) {
				/*
				 * 
				 * 현재 시간을 visit배열에 기억해준다
				 */
				visited[tmp.location * 2] = tmp.time;
				// 다음 일할 수빈이를 큐에 추가시켜준다.
				soo.add(new Point(tmp.location * 2, tmp.time + 1));
			}
			/*
			 * 
			 * +1을 갔을 때의 수빈이를 큐에 넣어주려한다. 여기도 100000포함 안시켜줘서 혼났다
			 * 
			 */
			if (tmp.location + 1 <= 100000 && visited[tmp.location + 1] == 0) {
				visited[tmp.location + 1] = tmp.time;
				soo.add(new Point(tmp.location + 1, tmp.time + 1));
			}
			/*
			 * 
			 * -1을 갔을 때의 수빈이를 큐에 넣어주려한다.
			 */
			if (tmp.location - 1 >= 0 && visited[tmp.location - 1] == 0) {
				//
				visited[tmp.location - 1] = tmp.time;
				soo.add(new Point(tmp.location - 1, tmp.time + 1));
			}
		}

		System.out.println(tmp.time - 1);

	}
}