


// CLASS: JObjectIter
     //
     // Author: yide ma, 7796951
     //
     // REMARKS: What is the purpose of this class? 
	 //
	 // implements interface JSONIter.
     //-----------------------------------------

public class JObjectIter implements JSONIter

{

	
	private Node Jcurr;
	
	//so this class contains two instance variables, one is 

	
	public JObjectIter() {
		
		this.Jcurr=null;
		
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

     
		
		
		
		// TODO Auto-generated method stub
		
	}
	
	
	public Node getNextNode() {
		
		return this.Jcurr.getNext();
	}
	
	
	
	
	
	
	

}
