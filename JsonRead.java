package newpa;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Set;

import org.json.simple.*;
import org.json.simple.parser.JSONParser;




public class JsonRead {
	
	  public static void main(String args[]){
	    	JSONObject jsonObject = new JSONObject();
	    	String area = "";
	    	try {
	    		Object obj = new JSONParser().parse(new FileReader("/Users/apple/Documents/Java/new.json"));
	    		JSONObject jo = (JSONObject) obj;
	    		Set<String> keys=jo.keySet();        
	    		for (String s : keys) {
	    			JSONObject job = (JSONObject) jo.get(s);
	    			String type = job.get("type").toString(); 
	    			switch(type) {
	    			case "circle":
	    				long radius = (long) job.get("radius");
	    				area = Double.toString(3.14*radius*radius);
	    				jsonObject.put(s, area);
	    				break;
	    			case "rectangle":
	    				long length = (long) job.get("l");
	    				long breadth = (long) job.get("b");
	    				area = Double.toString(length*breadth);
	    				jsonObject.put(s, area);
	    				break;
	    			case "square":
	    				long side = (long) job.get("side");
	    				area = Double.toString(side*side);
	    				jsonObject.put(s, area);
	    				break;
	    			default:
	    				jsonObject.put(s, 0);
	    				break;
	    			}
               }
	    	try {
	    		FileWriter file = new FileWriter("/Users/apple/Documents/Java/output.json");
	    		file.write(jsonObject.toJSONString());
	    		file.close();
	    	} catch (IOException e) {
	    		e.printStackTrace();
	    	}
	    } catch(Exception e){
	           System.out.println("Error building JSON");
	           e.printStackTrace();
	             }
	             
	  }
}
