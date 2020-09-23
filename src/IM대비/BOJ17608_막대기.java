package IM대비;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
/**
 * Samsung SW역량 테스트 IM대비 BOJ 17608 막대기
 * 
 * @author Park Sangwoo
 * @since 2020-09-23
 */
public class BOJ17608_막대기 {
	static int N;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		Stack<Integer> stack = new Stack<Integer>();
		
		for (int i = 0; i < N; i++) {
			int top = Integer.parseInt(br.readLine());
			/*
			 * 1.stack이 비어있지 않을때 까지 반복.
			 * 2.stack의 첫번째 값이 (peek) 들어오는  top값보다 같거나 작으면 pop(peek값을)
			 */
			while(!stack.isEmpty() && stack.peek()<=top) {	
				stack.pop();
			}
			stack.add(top);//결론적으로 stack에는 큰 top값들만 들어간다.
		}
		System.out.println(stack.size());
	}
}
