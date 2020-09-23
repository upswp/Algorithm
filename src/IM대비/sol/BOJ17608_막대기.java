package IM대비.sol;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;


// 17608 막대기 
// 스택 활용 
/**
 * 
 * @author taeheeKim
 *
 */
public class BOJ17608_막대기 {

	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		
		Stack<Integer> stack = new Stack<Integer>(); 
		for (int i = 0; i < N; i++) {
			int height = Integer.parseInt(in.readLine());
			// 이전에 있는 막대기가 나보다 높이가 같거나 낮으면 나에의해 가려지므로 모두 제거
			while(!stack.isEmpty() && stack.peek() <= height) stack.pop();
			
			stack.push(height);
		}
		System.out.println(stack.size());
	}

}
