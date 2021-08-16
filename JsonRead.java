package Question;

import java.io.FileReader;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JsonRead {
	
	public static void main(String[] args) {
	      JSONParser parser = new JSONParser();
	      try {
	         Object obj = parser.parse(new FileReader("/Users/apple/Documents/Java/New document 1.json"));
	         JSONObject jsonObject = (JSONObject)obj;
	         
	         JSONArray subjects = (JSONArray)jsonObject.get("type");
	         
	         System.out.println("type:");
	         Iterator iterator = subjects.iterator();
	         while (iterator.hasNext()) {
	            System.out.println(iterator.next());
	         }
	      } catch(Exception e) {
	         e.printStackTrace(); 
	      }
	   }


}
