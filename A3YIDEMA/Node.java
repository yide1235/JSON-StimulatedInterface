



// CLASS: Node
     //
     // Author: yide ma, 7796951
     //
     // REMARKS: What is the purpose of this class? 
     //  give Node class for linked list.
     //-----------------------------------------


public class Node {

	
	
	private Value value;
	
	private Node next;
	
	
	
	
	public Node() {
		this.value=null;this.next=null;
	}
	
	public Node(Value item) {
		this.value=item;this.next=null;
	}
	
	
	public Value getValue() {
		return this.value;
	}
	
	public Node getNext() {
		
		return this.next;
	}
	
	public void setNext(Node a) {
		this.next=a;
	}
	

	//compares if two node are equal.
	public boolean equals(Node a) {
		
		
		boolean result=false;
		
		if(this.toString().equals(a.toString())) {
			result=true;
		}
		
		return result;
	}
	
	
	

	public String toString(){

		String result=value.toString()+" , ";


		return result;
		
		
	}
	

	//for testing purpose method.
	public void print() {
		System.out.println(this.toString());
	}
	
	

	
}
