


// CLASS: JSONFactory
     //
     // Author: yide ma, 7796951
     //
     // REMARKS: What is the purpose of this class? 
     //   implements interface JSONFactory
     //-----------------------------------------



//A class that tell the user what is the implement class name of all interface.
public class JSONFactory {
//this  class is for JSONParser.read method.
//cause JSONParser doesnt know the implementation
//class name of each interface.





	
	public static JSONObject getJSONObject() {

        return new JObject();
		 
	}
	
	
	
	public static JSONArray getJSONArray() {
		return new JArray();
		
		
	}
	
	
	
	
	public static Value getJSONValue(ValueEnum v, Object o) 
	//the second parameter is a java object whose dynamic type
	//is one of four concrete values in JSON object.
	{
	
		Value result = null;
		
		
       if(v.equals(ValueEnum.BOOL)) {
    	   
    	   result=new JValue(ValueEnum.BOOL,o);
       }
       
       
       else if(v.equals(ValueEnum.INT)) {
    	   result=new JValue(ValueEnum.INT,o);
       }
       
       
       else if(v.equals(ValueEnum.DOUBLE)) {
    	   result=new JValue(ValueEnum.DOUBLE,o);
       }
       
       
       else if(v.equals(ValueEnum.STRING)) {
    	   result=new JValue(ValueEnum.STRING,o);
       }
       
       
       return result;
		
		

		
		
	}
	
	
	
	public static JSONQueryManager getJSONQueryManager() {
		
		
		JQuery a=new JQuery();
		
		return a;
		
		
		
		
	}
	
	
	
	
	
	
	
}
