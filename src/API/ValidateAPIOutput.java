package API;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class ValidateAPIOutput {

	//Validate whether the first acceptance criteria of name is matched properly
	@Test
	void ValidateName() {	
		try{
			ConvertToJavaObject obj= new ConvertToJavaObject();
			String output=obj.GetName();
			
			System.out.println(output);
			Assert.assertEquals("Name is not set as expected.", "Carbon credits", output);
			
		}catch (Exception e) {		
			e.printStackTrace();}
	}
	
	//Validate whether the second acceptance criteria of CanRelist is matched properly
	@Test
	void ValidateCanRelist() {	
		try{
			ConvertToJavaObject obj= new ConvertToJavaObject();
			boolean output=obj.GetCanRelist();	
			
			System.out.println(output);
			Assert.assertEquals("Can Relist is not set as expected.", true, output);
			
		}catch (Exception e) {		
			e.printStackTrace();}
	}
	
	//Validate whether the third acceptance criteria of promotion name is matched properly and description contains the string value
	@Test
	void ValidatePromotions() {	
		try{
			ConvertToJavaObject obj= new ConvertToJavaObject();
			int output= obj.GetPromotions();
			
			System.out.println(output);
			Assert.assertEquals("Promotion Name related to correct discription is not found.",1, output);
			
		}catch (Exception e) {		
			e.printStackTrace();}
	}
}
