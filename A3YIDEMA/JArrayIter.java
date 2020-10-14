

// CLASS: JArrayIter
     //
     // Author: yide ma, 7796951
     //
     // REMARKS: What is the purpose of this class? 
	 //        implements interface JSONIter
	 //
     //-----------------------------------------

public class JArrayIter implements JSONIter{

	private Node Jcurr;
	//only contains a node.
	
	
	
	public JArrayIter() {
		
		this.Jcurr=null;
		
	}
	
	public JArrayIter(Node Jcurr1) {
		
		Jcurr=Jcurr1;

	}
	
	
	public Node getNode() {
		return this.Jcurr;
	}
	
	public void setNode(Node a) {
		this.Jcurr=a;
		
	}

	
	
	@Override
	public boolean hasNext() {
		boolean result=false;
		
		if(Jcurr.getNext()!=null) {
			result=true;
			
			
		}
		
		
		
		// TODO Auto-generated method stub
		return result;
	}
	

	@Override
	public Value getNext() {
		
		
		
		
	      return Jcurr.getNext().getValue();//get Item from for next node
	}
	
	
	
	
	
	
	public Node getNextNode() {
		
		return this.Jcurr.getNext();
	}
	
	
	
	
	

}
