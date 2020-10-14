

// CLASS: JObject
     //
     // Author: yide ma, 7796951
     //
     // REMARKS: What is the purpose of this class? 
	 //   implements interface JSONObject, Value..
	 //
     //-----------------------------------------




//implementation of JSONObject..
public class JObject implements JSONObject, Value{

	private List objectList;//this is a linked list that full of pair objects.
	//this object contains a linked list that each node contains a pair.
	//JArray object contains a linked list that each node contains a JObject object.
	


	private JObjectIter Jone;
	//this instance variable is for traversing the curr node in the list of 
	




	public JObject() {
		objectList=new List();
		Jone=new JObjectIter();	
	}

	
	
	
	public JObject(List a) {
		objectList=a;
		
		Jone=new JObjectIter();
		
		this.Jone.setNode(this.objectList.getTop());
	}




	
	public List getList() {
		
		return this.objectList;
	}
	
	
	
	
	
	@Override
	public void addKeyValue( Value key, Value v) {
		//the format of addkeyValue has to be : key + value. key is a value type which 
		//dynamic type is a Value that contains a string.
	
		  String a=key.toString();
		  objectList.add(new Node(new Pair(a,v)));
		  
		  
		  
		  if(this.objectList.getTop().getNext()==null) {
			  this.Jone.setNode(this.objectList.getTop());
		  }

			  
		  //wrong code right here..........(if use the JObjectIter to record which node is currently in,
		  //then below code is useful........
//			  if(this.objectList.getTop().getNext()==null) {
//				  this.Jone=new JObjectIter(this.objectList.getTop());
//				  
//			  }
//			  else {//the list in the JObject contains more than one pair.
//				  
//				  this.Jone.setNode(this.Jone.getNode().getNext());
//			  }
			  
		  
		  
        
		
		
	}



	  
	@Override
	public Value getValue (Value key) 
	//receive a string and return to its pair value object.
	{
		
		
		Node temp=this.objectList.find(new Node(new JValue(ValueEnum.STRING,key.toString())));

		Value result=temp.getValue();
		
		
		
		
		return result;
		
		
	}
	
	
	
	
	  
	 @Override
	 public JSONIter iterator () {
		 
		 
		return this.Jone;
	}

	 
	 
	 
	 
	@Override
	public boolean equals(Value v) {//this value v should be a JObject.
		
		JObject temp=(JObject)v;
		return this.objectList.equals(temp.getList());
		
	}
	
	
	
	//a test method.
	public void print() {
		this.objectList.print();
	}
	
	
	//toString method for a JObject object.
	public String toString() {
		String result="";
		if(this.objectList.toString()!=" ") {
		
		result+="{ ";
		result+=objectList.toString();
		
		result=result.substring(0, result.length()-3);
		result+=" }";
		
		}
		else {
			result="";//if the list in this JObject is empty.
		}
		
		return result;
	}
	
	
	
	
	public Value find(String tokens) {
		Value result=null;
		
		boolean foundIndex=false;
		for(int i=0;i<tokens.length();i++) {
			if(tokens.charAt(i)=='[') {
				foundIndex=true;
			}
		}
		
		if(foundIndex) {
			//found the value by using key, then pass the
			//value into the find method in JArray.
			
			String keyWithoutIndex="";
			
			//want to know the key of the first JArray object.
			int recordFirstEdge=0; int i=0;
			while(true) {
				if(tokens.charAt(i)=='[') {
					recordFirstEdge=i;
					break;
				}i++;
			}
			
			//so the key now should be substring char at from 0 to recordFirstEdge.
			
			keyWithoutIndex=tokens.substring(0,recordFirstEdge);
			
			//now lets find the JArray Value.
			
			Node curr0=this.objectList.getTop();
			while(curr0!=null) {
				Pair temp0=(Pair)curr0.getValue();
				String temp10=temp0.getKey().substring(1,temp0.getKey().length()-1);
				if(temp10.equals(keyWithoutIndex)) {
					result=temp0.getValue();break;
				}
				else {
					curr0=curr0.getNext();
				}
				
				
			}
			//so now the type should be JArray.
		//	System.out.println("hiiiiiiii"+result.getClass()); //for test if here can get JArray.
			
			//now result is JArray object.
//			System.out.println(tokens);   //for testing purpose..
			
			if(result instanceof JArray) {
			JArray result1=(JArray)result;
			
			result=result1.find(tokens);//this method here only could return null, or JObject or JValue.
			//cause using recurrsion in JArray class.
		
			}
			else {
				result=null;
			}
			
			
			
			
			
		}
		else {
		

		
		Node curr=this.objectList.getTop();
		
		while(curr!=null) {
			
			Pair temp=(Pair)curr.getValue();
			
		//a little deal with Strings. 
			String temp1=temp.getKey().substring(1,temp.getKey().length()-1);
	
			if(temp1.equals(tokens)) {
				result=temp.getValue();break;
				
			}
			else {
				curr=curr.getNext();
			}
			
			
		}
		
		}//end of not find index in tokens.
		
		
		

	
		return result;
		
		
		
		
	}
	
	
	
	
   
	
	
	
}
