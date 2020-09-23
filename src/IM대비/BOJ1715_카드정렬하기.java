package IM대비;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ1715_카드정렬하기 {
	
	static int N ;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		for (int i = 0; i < N; i++) {
			int input = Integer.parseInt(br.readLine());
			pq.offer(input);
		}
		int tmp=0,cnt=0;
		while(pq.size()>1) {
			tmp = pq.poll() + pq.poll();
			cnt += tmp;
			pq.offer(tmp);
		}
		System.out.println(cnt);
	}

}
