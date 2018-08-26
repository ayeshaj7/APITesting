package API;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;

public class ConvertToJavaObject {

	//Create a Json object to access the content of the API output
	private String getJsonOutput() throws Exception {
		try {
			URL url = new URL("https://api.tmsandbox.co.nz/v1/Categories/6327/Details.json?catalogue=false;");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");
			
			//Validate whether API output returns a success code
			if (conn.getResponseCode() != 200) 
			{
				throw new RuntimeException(" HTTP error code : " + conn.getResponseCode());
			}
			
			//Reads the API output and store in a string
			Scanner scan = new Scanner(url.openStream());
			String entireResponse = new String();
			while (scan.hasNext())
				entireResponse += scan.nextLine();
							
				scan.close();
				
				conn.disconnect();
			return entireResponse;
		} catch (MalformedURLException e) {
			e.printStackTrace();	
		} catch (IOException e) {		
			e.printStackTrace();
		}
		return null;	
	}
	
	//Read the value of the Name parameter and returns the corresponding value as a string value
	public String getName() throws Exception {	
		try {
			JSONObject obj = new JSONObject(getJsonOutput());
			String name = obj.getString("Name");
			
			return name;

		} catch (Exception e) {		
			e.printStackTrace();}
		return null;
	}
	
	//Read the value of the CanRelist parameter and returns the corresponding value as a boolean value
	@SuppressWarnings("null")
	public boolean getCanRelist() throws Exception {	
		try {
			JSONObject obj = new JSONObject(getJsonOutput());			
			boolean canRelist = obj.getBoolean("CanRelist");
			
			return canRelist;

		} catch (Exception e) {		
			e.printStackTrace();}
		return (Boolean) null;
	}
	
	//Read the value of the Name and description parameters under promotions section and returns an integer flag
	public int getPromotions(String PromotionName, String PromotionDescription) throws Exception {			
		try {
			JSONObject obj = new JSONObject(getJsonOutput());							
			JSONArray promotionArray = obj.getJSONArray("Promotions");
			
			int matchingCount=0;
			
			//Loop through the promotions to validate the promotion name and description
			for (int i = 0; i < promotionArray.length(); i++) {
				String promotionName = promotionArray.getJSONObject(i).getString("Name");
				String description = promotionArray.getJSONObject(i).getString("Description");	
				
				//Validate whether the promotion name is matching as per requirement
				//Validate the description contains the string value after removing the newlines
				if (promotionName.equalsIgnoreCase(PromotionName) && description.split("\\R")[1].contains(PromotionDescription)) 
				{
					matchingCount=matchingCount+1;
				}
			}
			return matchingCount;
		} catch (Exception e) {		
			e.printStackTrace();
		}
		return 0;
	}
}
