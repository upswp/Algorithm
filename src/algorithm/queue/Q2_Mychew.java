package algorithm.queue;

import java.util.LinkedList;
import java.util.Queue;

public class Q2_Mychew {


	public static void main(String[] args) {

		Queue<int[]> queue = new LinkedList<int[]>();
		int N = 20;
		// person== new face 대상
		int person = 1;

		// queue에 배열 객체 계속 추가
		queue.offer(new int[] { person, 1 });

		// 마이쮸의 개수가 남이있을때까지 반복
		while (N > 0) {
			// 줄 서 있는 첫번째 사람에게 마이쮸 주기
			// 비어있지 않을 경우에만 준다.체크
			if (!queue.isEmpty()) {
				// 일차원 배열에 queue값 대입
				int[] p = queue.poll();

				// 지금 남아있는 마이쮸의 개수가 남아있는 사람보다 같거나 크면 원하는만큼 주고 아닐경우 남아있는 개수를 준다.
				int availableCnt = (N >= p[1]) ? p[1] : N;
				N -= availableCnt;
				if (N == 0) { // 마지막 마이쮸가 포함된 상황(더이상 마이쮸가 없음)
					System.out.println("마지막 마이쮸 가져간 사람:" + p[0] + ",가져간 개수" + availableCnt);
				} else {
					System.out.println(p[0] + "번이" + availableCnt + "개수만큼 가져갑니다. 남은개수: " + N);

					++p[1];
					queue.offer(p);// 다시 줄서기
					queue.offer(new int[] { ++person, 1 });// 새로운 사람 번호 먼저 증가 시키고 마이쮸 갯수는 무조건 1개로 고정
				}

			}
		}

	}

}
