package algorithm_silver;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ1697_숨바꼭질2 {

	static int max = 100001;
	static int[] road = new int[max];
	static boolean[] visit = new boolean[max];

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 수빈이의 위치
		int K = sc.nextInt(); // 동생의 위치

		for (int i = 0; i < max; i++) {
			road[i] = i;
		}

		Queue<Integer> q = new LinkedList<>();
		q.add(N);
		road[N] = 0;
		visit[N] = true;

		int[] cal = { 1, -1, 2 };
		while (!q.isEmpty()) {
			int num = q.poll();
			int move = 0;
			for (int i = 0; i < 3; i++) {
				if (i == 2) {
					move = num * cal[i];
				} else {
					move = num + cal[i];
				}

				if (-1 < move && move <= 100000 && visit[move] == false) {
					visit[move] = true;
					road[move] = road[num] + 1;
					if (move == K)
						break;
					q.add(move);
				}

			}
		}

		System.out.println(road[K]);

	}

}