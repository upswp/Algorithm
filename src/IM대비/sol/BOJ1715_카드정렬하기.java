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
public class BOJ1715_카드정렬하기 {

	static PriorityQueue<Integer> pq ;
	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		pq = new PriorityQueue<Integer>();
		for (int i = 0; i < N; i++) {
			pq.offer(Integer.parseInt(in.readLine()));
		}
		
		System.out.println(getAnswer());
	}

	private static int getAnswer() {
		int cnt = 0,temp;
		while(pq.size()>1) {
			// 가장 크기가 작은 두개의 묶음 뽑기
			temp = pq.poll() + pq.poll();
			cnt += temp;
			// 새로 합쳐진 묶음 다시 넣기
			pq.offer(temp);
		}
		return cnt;
	}
}
















