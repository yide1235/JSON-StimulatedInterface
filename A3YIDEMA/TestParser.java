 
 
 
 
 //-----------------------------------------
     // NAME		: yide ma 
     // STUDENT NUMBER	: 7796951
     // COURSE		: COMP 2150
     // INSTRUCTOR	: GordBoyer
     // ASSIGNMENT	: assignment 3
     // QUESTION	:       
     // 
     // REMARKS: What is the purpose of this program?
     //a test class for testing purpose.
     //
     //-----------------------------------------


//for compile:
//javac -cp .:junit-4.13-beta-2.jar TestParser.java
//for run:
//java -cp .:junit-4.13-beta-2.jar:hamcrest-2.1.jar org.junit.runner.JUnitCore TestParser


import static org.junit.Assert.*;

import org.junit.Test;

import jdk.jfr.Timestamp;

public class TestParser {

   @Test
   public void testCreate(){

	JObject a=new JObject();
       assertEquals("",a.toString());

   }
	
	
	
	
	@Test
	public void testJObjectAdd1() {//test a single boolean add.
		
		JObject a=new JObject(new List());
		
		a.addKeyValue(new JValue(ValueEnum.STRING,"\"myd\""), new JValue(ValueEnum.BOOL,true));
		
	
		
		//should be equal to this: { "myd" : true }
		String shouldBe="{ \"myd\" : true }";
		assertEquals(shouldBe,a.toString());
		
		
	}
	
	@Test
	public void testJObjectAdd2() {//test a single double type add.
		
		JObject a=new JObject(new List());
		
		a.addKeyValue(new JValue(ValueEnum.STRING,"\"myd\""), new JValue(ValueEnum.DOUBLE,3.1415));
		
		
		//should be equal to this: { "myd" : 3.1415 }
		String shouldBe="{ \"myd\" : 3.1415 }";
		assertEquals(shouldBe,a.toString());
		
		
	}
	
	@Test
	public void testJObjectAdd3() {//test a JObject that contains a JOBject.
		
		JObject a=new JObject(new List());
		JObject contained=new JObject();
		contained.addKeyValue(new JValue(ValueEnum.STRING,"\"name\""), new JValue(ValueEnum.STRING,"this is a contained JObject."));
		a.addKeyValue(new JValue(ValueEnum.STRING,"\"myd\""), contained);
	

		String shouldBe="{ \"myd\" : { \"name\" : this is a contained JObject. } }";
		assertEquals(shouldBe,a.toString());
		
		
	}
	
	@Test
	public void testJObjectAdd4() {//test a JObject that contains a JArray.
		
		JObject a=new JObject(new List());
		
		JObject contain1=new JObject();
		contain1.addKeyValue(new JValue(ValueEnum.STRING,"\"name\""), new JValue(ValueEnum.STRING,"\"111\""));
		
		JObject contain2=new JObject();
		contain2.addKeyValue(new JValue(ValueEnum.STRING,"\"name\""), new JValue(ValueEnum.STRING,"\"222\""));
		
		
		JArray contain=new JArray();
		contain.addValue(contain1);
		contain.addValue(contain2);
		
		a.addKeyValue(new JValue(ValueEnum.STRING,"\"arrayis\""), contain);
	
		
		
		//the result should in this way.
		String shouldBe="{ \"arrayis\" : [ { \"name\" : \"111\" } , { \"name\" : \"222\" } ] }";
		
		assertEquals(shouldBe,a.toString());
		
		
	}
	
	@Test
	public void testJObjectGetvalue() {//test the getValue method in JObject.
		
		JObject a=new JObject();
		
		a.addKeyValue(new JValue(ValueEnum.STRING,"\"key\""), new JValue(ValueEnum.STRING,"\"this should be returned\""));
		
		
		//should return in this way, because it return a Pair Object in this case.
		//so it called the toString of a Pair Object, so it should print in following String.
		String result="\"key\" : \"this should be returned\"";
		
		
		
		
		JValue goIn=new JValue(ValueEnum.STRING,"\"key\"");
	
		
	
		assertEquals(result,a.getValue(goIn).toString());
		
		
	}
	
	@Test
	public void testJObjectEqual() {//equals in JObject is easy to implement
		
		JObject a1=new JObject();
		
		a1.addKeyValue(new JValue(ValueEnum.STRING,"\"key\""), new JValue(ValueEnum.STRING,"\"this should be returned\""));
		
		
		JObject a2=new JObject();
		
		a2.addKeyValue(new JValue(ValueEnum.STRING,"\"key\""), new JValue(ValueEnum.STRING,"\"this should be returned\""));
		
		
		boolean result=a1.equals(a2);
		
		assertEquals(true,result);
		
	}
	
	
	
	
	@Test
	public void testRead1() {
		
		
		String para="{ \"name\" : \"Anne Vestor\" }";
		
		
		
		JSONParser a=new JSONParser();
		JSONObject a1=a.read(para);
		
		assertEquals(para, a1.toString());
		
	}
	
	
	
	@Test
	public void testRead2() {//test a JObject that contains a integer
		
		
		String para="{ \"name\" : 0 }";
		
		
		
		JSONParser a=new JSONParser();
		JSONObject a1=a.read(para);
		
		
	
		assertEquals(para, a1.toString());
		
	}
	
	
	@Test
	public void testRead3() {//test a JObject that contains a double
		
		
		String para="{ \"name\" : 1.1 }";
		
		
		
		JSONParser a=new JSONParser();
		JSONObject a1=a.read(para);
		
		assertEquals(para, a1.toString());
		
	}
	
	
	@Test
	public void testRead4() {//test a JObject that contains a boolean
		
		
		String para="{ \"name\" : true }";
		
		
		
		JSONParser a=new JSONParser();
		JSONObject a1=a.read(para);
		
		assertEquals(para, a1.toString());
		
	}
	
	
	
	
	
	
	
	@Test
	public void testRead5() {//test for a JOBject that contains 3 pairs.
		String para="{ \"myd\" : \"mxy\" , \"myd1\" : \"mxy\" , \"myd2\" : \"mxy2\" }";
		
		JSONParser a=new JSONParser();
		JSONObject a1=a.read(para);
		
		assertEquals(para, a1.toString());
		
		
	}
	
	
	
	
	
	
	@Test
	public void testRead6() {
		//test a JObject contains an array
		
		
		
		String para="{ \"name\" : \"Anne Vestor\" , \"portfolio\" : [ { \"name\" : \"BTC\" , \"quantity\" : 3 } , { \"name\" : \"ETH\" , \"quantity\" : 5 } ] }";
		
		JSONParser a=new JSONParser();
		
		JSONObject a1=a.read(para);
				
	    assertEquals(para, a1.toString());
		
		
		
		
		
		
		
	}
	
	
	
	@Test
	public void testRead7() {//test for a JOSNOBject that contains a JArray in it which contains a JArray in it.
		

	       String para="{ \"name\" : \"Anne Vestor\" , \"portfolio\" : [ [ 3 , { \"name\" : \"ETH\" , \"quantity\" : 5 } ] , { \"name\" : \"ETH\" , \"quantity\" : 5 } ] }";
		
		
	       JSONParser a=new JSONParser();
	       JSONObject a1=a.read(para);
	       
	       assertEquals(para,a1.toString());
	       
	       
	       
	       
	       
		
	}
	

	@Test 
	public void testQuery1() {//test if success in only one.
		
		String para="{ \"name\" : \"Anne Vestor\" }";
		
		
	      
		JQuery o= (JQuery) JSONFactory.getJSONQueryManager();
	      o.loadJSON(para);
	      //o containing this JObject now.
	      
	      
	      
	      String shouldBe="\"Anne Vestor\"";
	      //expected result.....
	      
	      
	      
	      assertEquals(shouldBe,o.getJSONValue("name").toString());
		
		
	}
	
	
//this method gives result of fails because it cannot found name in
//the String para.
	// @Test 
	// public void testQuery2() {//this method should give false result.
		
	// 	String para="{ \"name\" : \"Anne Vestor\" }";
		
		
	      
	//         JQuery o= (JQuery) JSONFactory.getJSONQueryManager();
	//       o.loadJSON(para);
	//       //o containing this JObject now.
	      
	      
	      
	//       String shouldBe="\"Anne Vestor\"";
	//       //expected result.....
	      
	      
	      
	//       assertEquals(shouldBe,o.getJSONValue("name1").toString());
	
		
		
	// }




	//test for array boundary cannot show here.cause it  throws error.
	

	@Test 
	public void testQuery3() {//test if sucess if we have an array.
		
		String para="{ \"portfolio\" : [ 3 , { \"name\" : \"ETH\" , \"quantity\" : 5 } ] }";
		
		
	      
		JQuery o= (JQuery) JSONFactory.getJSONQueryManager();
	      o.loadJSON(para);
	      //o containing this JObject now.
	      
	      
	      
	      String shouldBe="\"ETH\"";
	      //expected result.....
	     
	      
	      
	      assertEquals(shouldBe,o.getJSONValue("portfolio[1].name").toString());
		
		
	}
	

	@Test 
	public void testQuery4() {//test if sucess if we have an array.
		
		String para="{ \"portfolio\" : [ 3 , { \"name\" : \"ETH\" , \"quantity\" : 5 } ] }";
		
		
	      
		JQuery o= (JQuery) JSONFactory.getJSONQueryManager();
	      o.loadJSON(para);
	      //o containing this JObject now.
	      
	      
	      
	      String shouldBe="3";
	      //expected result.....
	      
	      
	      
	      assertEquals(shouldBe,o.getJSONValue("portfolio[0].name").toString());
	      
		
		
	}
	
	
	//if put "portfolio[2]" as the query, it just report error. so hard to show that if the array 
	//index is over the boundary then it should throw exceptions.
	
	
	
	
	
	
	
	
	
	@Test 
	public void testQuery5() {
		
		String para="{ \"myd\" : { \"name\" : \"Anne Vestor\" , \"portfolio\" : [ 3 , { \"name\" : \"ETH\" , \"quantity\" : 5 } ] } }";
		
		

	      
	      JQuery o= (JQuery) JSONFactory.getJSONQueryManager();
	      o.loadJSON(para);
	      //o containing this JObject now.
	      
	      
	      
	      String shouldBe="5";
	      assertEquals(shouldBe,o.getJSONValue("myd.portfolio[1].quantity").toString());
		
		
	}
	
	
	
	@Test 
	public void testQuery6() {
		
		String para="{ \"portfolio\" : [ [ 3 , { \"name\" : [ true , 3 ] , \"quantity\" : 5 } ] , { \"name\" : \"ETH\" , \"quantity\" : 5 } ] }";
		
		

	      
	      JQuery o= (JQuery) JSONFactory.getJSONQueryManager();
	      o.loadJSON(para);
	      //o containing this JObject now.
	      
	      
	      
	      String shouldBe="[ true , 3 ]";
	      assertEquals(shouldBe,o.getJSONValue("portfolio[0][1].name").toString());
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	@Test 
	public void testQuery7() {//situation for a JArray contains a JArray that contains a JArray.
		
		String para="{ \"portfolio\" : [ [ 3 , { \"name\" : [ true , 3 ] , \"quantity\" : 5 } ] , { \"name\" : \"ETH\" , \"quantity\" : 5 } ] }";
		
		

	      
	      JQuery o= (JQuery) JSONFactory.getJSONQueryManager();
	      o.loadJSON(para);
	      //o containing this JObject now.
	      
	      
	      
	      String shouldBe="3";
	      assertEquals(shouldBe,o.getJSONValue("portfolio[0][1].name[1]").toString());
		//situation for input "portfolio[1][1]" will throw IllegalStateException , because portfolio got a JObject.
	      //but portfolio[0][1] works. you can test it.
		
	}
	
	
	
	
	
	

}
