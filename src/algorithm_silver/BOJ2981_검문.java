package algorithm_silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class BOJ2981_검문 {

	static PriorityQueue<Integer> pq;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int input[] = new int[N];
		int M = 2;
		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(input);

		pq = new PriorityQueue<Integer>();
		while (input[0] >= M) {
			int rest[] = new int[N];
			for (int i = 0; i < N; i++) {
				rest[i] = input[i] % M;
			}
			if (allElementsTheSame(rest)) {
				pq.add(M);
			}
			M++;
		}
		for (int i = 0; i < pq.size() + 1; i++) {
			if (!pq.isEmpty()) {
				System.out.print(pq.poll() + " ");
			}
		}
	}

	public static boolean allElementsTheSame(int[] array) {
		if (array.length == 0) {
			return true;
		} else {
			int first = array[0];
			for (int element : array) {
				if (element != first) {
					return false;
				}
			}
			return true;
		}
	}
}
