


// CLASS: JQuery
     //
     // Author: yide ma, 7796951
     //
     // REMARKS: What is the purpose of this class? 
	 //  implements interface JSONQueryManager.
	 //
     //-----------------------------------------

public class JQuery implements JSONQueryManager{
	//this class is the implementation of JSONQueryManager.
	
	private JObject jobject;
	
	
	
	public JQuery() {
		jobject=null;
		
		
	}
	

	
	

	@Override
	public void loadJSON(String JSON) {
		
		// a method just simplely put the String into this object.
		JSONParser convert=new JSONParser();
		
		this.jobject=(JObject)convert.read(JSON);
		
		
	}




	@Override
	public Value getJSONValue(String query) throws IllegalStateException {

		if(this.jobject==null) {
			throw new IllegalStateException();
			
		}//if this.jobject is not initialized then just throw Exceptions.
		
		
		Value temp;//this is a variable to traverse the type for each loop.
		
		String tokens[]=query.split("\\.");
		//now tokens is a b c for a.b.c   
		
        //deal the first one is the special case,
		//so if the first tokens[0] contains [], then initialized temp with a JArray
       //call a help method to find if it contains [].
	
        temp=this.jobject;
        
		
       //separate the first one cause need to initialize it.
       
       
		int i=0;
		while(i<tokens.length)//each traverse of this loop is just for a single tokens[i].
		
		{
           //it wont return an JArray, cause the code like "name[0][1][2].."
			//will always returns a JObject or JValue.
		
			if(temp instanceof JObject) {
				temp=((JObject) temp).find(tokens[i]);
				
				
			}
			else if(temp instanceof JValue) {
				break;
			}

			
			i++;//controls tokens[i].
			
			
			
			
		}
		
		if(temp==null) {
			throw new IllegalStateException();
		}
		
		
		
		
		
		return temp;
		
		
		
		
	}
	
	
	
	//a help method shows if the tokens[i] contains
	//'[' and ']'.
	public boolean contains(String tokens) {
		boolean found=false;
		
		for(int i=0;i<tokens.length();i++) {
			
			if(tokens.charAt(i)=='[') {
				found=true;
			}
		}
		
		
		
		return found;
		
		
	}

	
	//a help method.
	public JObject get() {
		return this.jobject;
	}

}
