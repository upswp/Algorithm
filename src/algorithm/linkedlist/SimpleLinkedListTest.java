package algorithm.linkedlist;

public class SimpleLinkedListTest {

	public static void main(String[] args) {
		
		SimpleLinkedList list = new SimpleLinkedList();
		
		list.addFirstNode("이동욱");
		list.printList();
		list.addFirstNode("이지아");
		list.printList();
		list.addFirstNode("김재환");
		list.printList();
	}

}
