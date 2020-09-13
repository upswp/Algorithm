package algorithm.queue;

import java.util.LinkedList;

public class Q1_QueueAPITest {

	public static void main(String[] args) {
		
		//LinkedList 는 Queue와 Deque를 지원하기때문에 구분해야한다. 
		LinkedList<String> queue = new LinkedList<String>();
		System.out.println(queue.size()+"//"+queue.isEmpty());
		
		//Queue offer : 
		queue.offer("이동욱");
		queue.offer("이지아");
		queue.offer("김태희");
		
		System.out.println(queue.size()+"//"+queue.isEmpty());
		System.out.println(queue.poll());
		System.out.println(queue.poll());
		System.out.println(queue.peek());
		System.out.println(queue.size()+"//"+queue.isEmpty());
	}

}
