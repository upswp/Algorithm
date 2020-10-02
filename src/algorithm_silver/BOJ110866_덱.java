package algorithm_silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;
/**
 * BOJ 110866 덱
 * @author Park Sangwoo
 * @since 2020-10-02
 */
public class BOJ110866_덱 {

	public static void main(String[] args) throws Exception {
		/*초기화*/
		Deque<Integer> deque = new LinkedList<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		/*초기화*/
		
		int cnt = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < cnt; i++) {
			st = new StringTokenizer(br.readLine());
			String a = st.nextToken();
			
			if (a.equals("push_back")) {
				int b = Integer.parseInt(st.nextToken());
				deque.addLast(b);
				
			} else if (a.equals("push_front")) {
				int b = Integer.parseInt(st.nextToken());
				deque.addFirst(b);
				
			} else if (a.equals("pop_front")) {
				System.out.println(deque.isEmpty() ? -1 : deque.pop());
				
			} else if (a.equals("pop_back")) {
				System.out.println(deque.isEmpty() ? -1 : deque.removeLast());
				
			} else if (a.equals("size")) {
				System.out.println(deque.size());
				
			} else if (a.equals("empty")) {
				System.out.println(deque.isEmpty() ? 1 : 0);
				
			} else if (a.equals("front")) {
				System.out.println(deque.isEmpty() ? -1 : deque.peek());
				
			} else if (a.equals("back")) {
				System.out.println(deque.isEmpty() ? -1 : deque.peekLast());
			}
		}
	}
}