


// CLASS: List
     //
     // Author: yide ma, 7796951
     //
     // REMARKS: What is the purpose of this class? 
     //  provided a linked list structure.
     //-----------------------------------------


//this is a linked list structure.
public class List {

	
	
	private Node top;
	
	public List() {
		this.top=null;
	}
	
	public List(Node a) {
		this.add(a);
	}
	
	
	public Node getTop() {
		return this.top;
	}
	


	//typical add method for  a linked list structure.
	public void add(Node a) {
		//add to the end.
		
		if(this.top==null) {
			this.top=a;
		}
		else {
			Node curr=this.top;
			
			while(curr.getNext()!=null) {
				curr=curr.getNext();
			}
			//now curr is the last one.
			curr.setNext(a);
		}
		
		
		
	}
	
	
	
	
	//this function is only used by JObject. so dynamic cast it..
	public Node find(Node a)//searching for a key i guess.
	{
		
		String shouldBe=a.toString().substring(0, a.toString().length()-2);
		//because when i write toString for a node, i added a " ," string in the end,
		//so delete it, then use indexOf to judge that if toString of a node is 
		//contained in the other toString of another node.
		
		
		Node result=null;
		
		
		Node curr=this.top;
	 
		if(this.top!=null) {
			
			while(curr!=null) {
				
				
		  
				
				if(curr.toString().indexOf(shouldBe.toString())!=-1) {
					result=curr;break;
				}
				
				else {
					curr=curr.getNext();
				}
				
				
					
				
				
			}
			
		}
		
		return result;
		
	}
	
	
	

	
	//travers each node in the list and compare them if
	//each node in this list is equal.
	public boolean equals(List v) {
		
		
		
		
		if(this.top!=null&&v.getTop()!=null) //two list of JObject are both not empty.
		{
			boolean result=true;
		
		Node curr=this.top;
		Node curr1=v.getTop();
		while(curr!=null&&curr1!=null) {
			if(!curr.equals(curr1)) {result=false;break;}
			  
			else {
				curr=curr.getNext();curr1=curr1.getNext();
			}
			
			if(curr==null&&curr1!=null) {result=false;break;}
			if(curr!=null&&curr1==null) {result=false;break;}
			
		}
		
		return result;
		
		}
		else {
			System.out.println("something is null");
			
			return false;
		}
	
		

		
		
		
	}
	
	
	
	
	public void print() //this method is for test purpose.
	{
		if(this.top==null) {
			System.out.println("this List is null.");
			
		}
		
		else {
			
			Node curr=this.top;
			while(curr!=null) {
				
				System.out.println(curr.getValue().toString());
				curr=curr.getNext();
				
			}
		}
	}
	


	//for give toString of a List class.
	public String toString() {
		
		String result="";
		
		if(this.top==null) {
			result=" ";
		}
		
		else {
			
			Node curr=this.top;
			
			while(curr!=null) {
				
				result+=curr.toString();
				curr=curr.getNext();
			}
			
		}
		
		
		return result;
	}
	
	
}
