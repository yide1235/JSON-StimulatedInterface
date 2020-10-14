


// CLASS: JValue
     //
     // Author: yide ma, 7796951
     //
     // REMARKS: What is the purpose of this class? 
     //  implements interface Value.
     //-----------------------------------------

/*a class that implements Value
so a Value could be 5 types:
1.JValue with boolean object.
2.JValue with int object.
3.JValue with double object
4.JValue with string object.
5.JObject.
6.JArray.
*/
public class JValue implements Value{
    //a JValue could be 
	//1.boolean 2.string 3.number(without quotation) 
	
	
	//situation of boolean string number
	private ValueEnum type;
	private Object o;
	//this is a unit, when this JValue is a type of
	//boolean string in double, then initialize this JValue
	//object with its type: ValueEnum... and a dynamic object
	//that can be cast to object format of boolean, string,number .
	
	
	

	
	
	public ValueEnum getType() {
		return this.type;
	}
	
	public Object getObject() {
		return this.o;
	}
	
	
	

	
	
	
	public JValue(ValueEnum  a,Object o) {
		
		if(a.equals(ValueEnum.BOOL)) {
			type=ValueEnum.BOOL;
		}
		else if(a.equals(ValueEnum.STRING)){
			type=ValueEnum.STRING;
		}
		else if(a.equals(ValueEnum.INT)) {
			type=ValueEnum.INT;
		}
		else if(a.equals(ValueEnum.DOUBLE)) {
			type=ValueEnum.DOUBLE;
		}
		this.o=o;

		
		
		
	}//constructor that contains a boolean or string or number.
	

	
	
	
	
	@Override
	public boolean equals(Value v) {
       
		boolean result=false;
		
		
		
		if(v.toString().equals(this.toString())) {
			
			
			result=true;
		}

		
		
		return result;
	}
	
	@Override
	public String toString() {
		String result="";
	
		       
				result=""+o.toString();
			

		
		
		return result;
	}
	
	
	
	

	
	
	
}
