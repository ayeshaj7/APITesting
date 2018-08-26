package API;

import org.testng.Assert;
import org.testng.annotations.*;

public class ValidateAPIOutput {

	private ConvertToJavaObject convertToJavaObject;
	
	@BeforeClass
    public void setup(){
		convertToJavaObject = new ConvertToJavaObject();
    }
	
	//Validate whether the first acceptance criteria of name is matched properly
	@Test
	@Parameters(value= {"FullName"})
	public void validateName(String FullName) {	
		try{
			String output=convertToJavaObject.getName();
			
			System.out.println(output);
			Assert.assertEquals(output, FullName, "Name is not set as expected.");
			
		}catch (Exception e) {		
			e.printStackTrace();}
	}
	
	//Validate whether the second acceptance criteria of CanRelist is matched properly
	@Test
	@Parameters(value= {"CanRelist"})
	void validateCanRelist(boolean CanRelist) {	
		try{
			boolean output=convertToJavaObject.getCanRelist();	
			
			System.out.println(output);
			Assert.assertEquals(output, CanRelist, "Can Relist is not set as expected.");
			
		}catch (Exception e) {		
			e.printStackTrace();}
	}
	
	//Validate whether the third acceptance criteria of promotion name is matched properly and description contains the string value
	@Test
	@Parameters(value= {"PromotionName", "PromotionDescription"})
	void validatePromotions(String PromotionName, String PromotionDescription) {	
		try{
			int output= convertToJavaObject.getPromotions(PromotionName, PromotionDescription);
			
			System.out.println(output);
			Assert.assertEquals(output, 1,"Promotion Name related to correct description is not found.");
			
		}catch (Exception e) {		
			e.printStackTrace();}
	}
}
