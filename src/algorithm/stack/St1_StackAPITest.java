package algorithm.stack;

import java.util.Stack;

public class St1_StackAPITest {

	public static void main(String[] args) {
		
		//< > 제네릭 - 자료구조의 무슨형태의 자료형을 넣을건지 넣는 장소
		Stack<String> stack = new Stack<String>();
		//사이즈와 비어있는 여부 확인
		System.out.println(stack.size()+"//"+stack.isEmpty());
		
		stack.push("신동엽");
		stack.push("유재석");
		stack.push("강호동");
		System.out.println(stack.size()+"//"+stack.isEmpty());
		System.out.println(stack.pop());
		System.out.println(stack.size());
		//맨 위의 값을 반환 , 삭제는 아님
		System.out.println(stack.peek());
		System.out.println(stack.size());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		//기존 스택의 양보다 많은 데이터를 삭제해서 EnptyStackException
		System.out.println(stack.pop());
		System.out.println(stack.size()+"//"+stack.isEmpty());
		
	}

}
