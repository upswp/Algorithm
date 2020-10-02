package algorithm_silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;
/**
 * BOJ 10828 스택
 * @author Park Sangwoo
 * @since 2020-10-03
 */
public class BOJ10828_스택 {

	static int N, num;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String input = st.nextToken();
			if (input.equals("push")) {
				int num = Integer.parseInt(st.nextToken());
				stack.add(num);
			}
			else if (input.equals("pop"))System.out.println(stack.isEmpty()?-1:stack.pop());
			else if (input.equals("size"))System.out.println(stack.size());
			else if (input.equals("empty"))System.out.println(stack.isEmpty()?1:0);
			else if (input.equals("top"))System.out.println(stack.isEmpty()?-1:stack.peek());
		}
	}

}
