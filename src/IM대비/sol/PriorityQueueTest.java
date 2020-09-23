package IM대비.sol;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

// 1715 카드정렬하기
/**
 * 
 * @author taeheeKim
 *
 */
public class PriorityQueueTest {

	static PriorityQueue<Integer> pq ;
	public static void main(String[] args) throws Exception {
		
		// 직접 Comparator 구현
		/*
		pq = new PriorityQueue<Integer>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return Integer.compare(o2, o1); // 오버플로우, 언더플로우 방지 : 데이터에 음수,양수 섞일때
				// return o2-o1;
			}
		});
		*/
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Comparator.reverseOrder()); // 원소인 Comparable의 비교결과를 반대로 다시 처리해주는 Comparator를 이용
		
		int a;
		for (int i = 0; i < 10; i++) {
			a = (int)(Math.random()*50)+1;
			System.out.println("in :"+a);
			pq.offer(a);
		}
		while(!pq.isEmpty()) {
			System.out.println(pq.poll());
		}
	}

}
















