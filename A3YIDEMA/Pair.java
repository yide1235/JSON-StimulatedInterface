



// CLASS: Pair
     //
     // Author: yide ma, 7796951
     //
     // REMARKS: What is the purpose of this class? 
	 //  provide JObject class a structure that 
	 // each JObject contains a Pair.
     //-----------------------------------------



public class Pair implements Value{
//a class that gives JObject a structure is a
//Pair that the frist one is a String key value,
//the second one is the implementation of 
//Value, which could be JValue type or JObject,
//or JArray.



	
	private String key;
	private Value value;
	
	public Pair() {
		this.key=null;this.value=null;
	}
	
	
	public Pair(String key, Value value) {
		this.key=key;
		this.value=value;
	}
	
	
	
	public String getKey() {
		return this.key;
	}

//this.key is a JValue that the instance varibale
//in it is a String.
	
	
	public Value getValue() {
		
		return this.value;
	}

	//get the Value from this Object, that 
	//could be a JObject, JArray, or JValue
	//(could be string, int , double, boolean.)
	
	
	
	
	public String toString() {
		
		String result="";
		result+=this.key+" "+": "+this.value;
		
		return result;
	}
//a toString method that return the toString 
//information 

	
	
	
	//a compare method to know if the
	//two Pairs are equal.
	@Override
	public boolean equals(Value v) {
		
		boolean result=false;
		
		if(v instanceof Pair) {
		//need to dynamic cast to get the stuff form v.
		Pair v1=(Pair)v;
		if(this.key.equals(v1.getKey())) {
			
		 if(this.value.equals(v1.getValue())) {
			 
			 result=true;
		 }
		}
		
		
		}
		
		
		return result;
	}
	
	
	

}
