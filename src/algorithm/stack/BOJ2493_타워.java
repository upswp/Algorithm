package algorithm.stack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;
/**
 * SSAFY BOJ 2493
 * @author Park Sangwoo
 * @since 2020-09-13
 */
public class BOJ2493_타워{
	static class tower{
		int height;
		int position;
		public tower(int height, int position) {
			this.height = height;
			this.position = position;
		}
	}
	
	private static int T ;
	public static void main(String[] args) throws Exception{
		
		Stack<tower> stack = new Stack<tower>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		T = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		for (int t = 1; t <= T; t++) {
			int stackTop = Integer.parseInt(st.nextToken());
			while(!stack.isEmpty()) {
				if(stack.peek().height >=stackTop) {
					bw.write(stack.peek().position + " ");
					break;
				}
				else {
					stack.pop();
				}
			}
			if(stack.isEmpty()) {
				bw.write("0"+" ");
			}
				stack.push(new tower(stackTop,t));
		}
		bw.flush();
        br.close();
        bw.close();
		
	}

}
