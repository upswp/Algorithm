package algorithm_silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * BOJ 10845 큐
 * 
 * @author Park Sangwoo
 * @since 2020-10-02
 */
public class BOJ10845_큐 {
	static int N, num;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		Deque<Integer> que = new LinkedList<Integer>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String input = st.nextToken();
			if (input.equals("push")) {
				num = Integer.parseInt(st.nextToken());
				que.add(num);
			} else if (input.equals("pop"))
				System.out.println(que.isEmpty() ? -1 : que.pollFirst());
			else if (input.equals("size"))
				System.out.println(que.size());
			else if (input.equals("empty"))
				System.out.println(que.isEmpty() ? 1 : 0);
			else if (input.equals("front"))
				System.out.println(que.isEmpty() ? -1 : que.peekFirst());
			else if (input.equals("back"))
				System.out.println(que.isEmpty() ? -1 : que.peekLast());
		}
	}
}
