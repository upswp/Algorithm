package algorithm.queue;

import java.util.LinkedList;
import java.util.Queue;

public class QueueTest {

	public static void main(String[] args) {

		Queue<Integer> que = new LinkedList<>();
		// push
		que.offer(2);
		que.offer(3);
		que.offer(1);
		// 빌때 까지!
		while (!que.isEmpty()) {
			int a = que.poll();
			que.peek(); // 삭제되지 않고 확인만 한다.
			System.out.print(a + " ");
		}
		System.out.println();
		// int a=que.poll();

	}
}