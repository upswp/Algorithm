package algorithm.linkedlist;

public class Node {

	// 데이터 필드
	String data;
	// 링크 필드
	Node link;
	
	public Node(String data, Node link) {
		super();
		this.data = data;
		this.link = link;
	}

	
	public Node(String data) {
		super();
		this.data = data;
	}



}