

// CLASS: JArray
     //
     // Author: yide ma, 7796951
     //
     // REMARKS: What is the purpose of this class? 
	 //    implements interface JSONArray.
	 //
     //-----------------------------------------



//a class for implementation of JSONArray...
public class JArray implements JSONArray,Value{
//------>>>>>>what it does is just contains a linked list of implementation of Values.	
	
	private List objectArray;
	private JArrayIter jArrayIter;
	
	public JArray() {
		objectArray=new List();
		jArrayIter=null;
		
	}
	
	public JArray(List a) {
		
		this.objectArray=a;
        jArrayIter=new JArrayIter(a.getTop());

	}
	
	public List getList() {
		
		return this.objectArray;
	}
	
	
	
	
//compare each node in the list is equal.
	@Override
	public boolean equals(Value v) {
		
		
		JArray temp=(JArray)v;
		
		
		return this.objectArray.equals(temp.getList());
		
		
		   
	}
	
	

	@Override
	public void addValue(Value v) {//the purpose of this method is to 
		//add a Value to the list of this.
		//so a value can be a boolean, string, number, object, array.
		 
	    
		
		objectArray.add(new Node(v));
		
		
		
		
	}
	
	
	

	@Override
	public JSONIter iterator() {
		
		
		
		return this.jArrayIter;
		
		
	}
	
	
	public String toString() {
		
		String result="[ ";
		result+=this.objectArray.toString();
		result=result.substring(0, result.length()-3);
		result+=" ]";
		return result;
		
		
	}


   //return responding index Value in this JArray object.
	public Value find(String tokens ) {//just reminder that key here must contains indexes.
		//this method must be recursively cause maybe there are 
		//nested JArrays.
		//reminder that JArray is full of Value which could be 
		//JObject, JArray, JValue(integer double String boolean).
		
		Value result=this;//this result could be JObject or JValue when returned
		//cause using recursion for this JArray.find.
		//initialize it with itself.
		//so at the beginning result is just the JArray.
		
		//now deal with the string.
		
		//how we gonna do is to separate the key part and the index part.
		//there are maybe more than one parameters, so need to a help method
		//to do it recursively.
		
		
		//so like "porfolio[0][0]" should have 2 results;
		//one is called partA that is "portfolio", one is partB which is "[0][0]";
		//following is the way to do it.
		
	       int recordIndex=0;
	       for(int i=0;i<tokens.length();i++) {
	    	   if(tokens.charAt(i)=='[') {
	    		   recordIndex=i;break;
	    	   }
	       }
	     
	       
	       String partA=tokens.substring(0, recordIndex);
	       String partB=tokens.substring(recordIndex, tokens.length());

	       //now String partB is something like "[0][0]" 
	       //pass is as a parameter to do thing recursively.
	       JArray result1=(JArray)result;

	       
	       result=result1.findHelper(partB);
          
	 
		
		  
       
		return result;
		
	}
	
	public Value findHelper(String partB) {
		//partB is like"[0][1]"
		Value result=null;
		
		//find first stuff in partB which should be 0.
		//rhen delete the first [], and pass the left to recursion.
		
		
		if(partB.length()>0) {
			
			
			
			result=this;
		int end=0;
		
		int i=0; 
		while(true) {

			if(partB.charAt(i)==']') {
				end=i;
				break;
			}
			i++;
			
		}
	
		int indexPass=Integer.parseInt(partB.substring(1, end));
	
		//now get the positoin of JArray this.
		Node curr=this.objectArray.getTop();
		int find=0;
		while(find!=indexPass) {
			
		  
		  curr=curr.getNext();
		  find++;
		  
		}
		

		
		if(curr!=null) {
		//now get stuff in curr node.
		   Value temp1=curr.getValue();
		  
		   
		    if(temp1 instanceof JValue||temp1 instanceof JObject) {
		    	
		    	result=temp1;
		    	
		    	
		    	
		    	  String rap1=partB.substring(end+1, partB.length());
		    	
		    	  //incase of if the first index is right, but it has the second one
		    	  //when it returns a JOBject or JValue. so delete the next [] and compare it with 0.

		
				if(rap1.length()>0) {
					//it shouldnt bigger than 0.
					result=null;
					
				}
		    	  
		    	  
		    	  
		    	  
		    	  
		    	  
		    	
			
		   }
		    
		   else if(temp1 instanceof JArray){
			   String rap=partB.substring(end+1, partB.length());
			   if(rap.length()>0) {
			      JArray temp11=(JArray)temp1;
			       result=temp11.findHelper(partB.substring(end+1, partB.length()));
			   }
			   
			   else {
				   result=temp1;
			   }
			   
			   
		    }
		
		
		}
		else {
			result=null;
		}
		
		
		
		
		}

		
		
		
		
		
		return result;
	}
	
	

	
	
}
