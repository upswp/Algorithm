package algorithm.linkedlist;

public class SimpleLinkedList {
	
	private Node head;
	
	public void addFirstNode(String data) {
		Node  newNode = new Node(data, head);
		head = newNode;
		
	}
	
	public void printList() {
		for (Node currNode = head; currNode !=null; currNode = currNode.link) {
			System.out.print(currNode.data+"\t");
		}
		System.out.println();
	}
}
