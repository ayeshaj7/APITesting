Project Title – Validate the API output

Description – The purpose of the project is to validate the API output and confirm the output meets the acceptance criteria.

Prerequisites

- Eclipse – Script Editor that can be download (the latest version) from internet.
- Json Jar – Add as an external jar to build the logics with the API response. This can be downloaded from internet (the latest version).
- Test NG – Add as a library to validate the acceptance criteria. This can be downloaded from internet (the latest version).

Installing

- Install latest Eclipse version.
- Add Json jar as an external jar to build path.
- Add TestNG as a library to build path.

Running the tests – Execute the TestNG test case (“ValidateAPIOutput.java”) in Eclipse in order to validate the test results of the test case. As a prerequisites, set the run configuration to the "Suit" with "testing.xml" file and run the test case.

Break down in to end to end tests – This test case is verifying whether the below acceptance criteria is met.

- Acceptance criteria 1 – The Name is mapped properly to “Carbon credits”.
- Acceptance criteria 2 – The CanRelist is mapped properly to “true”.
- Acceptance criteria 3 – The promotion element name is mapped properly to “Gallery” and the promotion description that contains the text “2x larger image”.

In order to validate the above acceptance criteria the below approach is taken.

Step 1 – Created a java class “ConvertToJavaObject” that creates a Json object that convert to Java object. So that API response can be validate aganist the acceptance criteria. This class consists with 4 methods that can be used in the TestNG test case.

- Method 1 (“getJsonoutput”) - This creates a connection to the API and check whether the response code is set with 200. This scans API output and store in to a string that can be used in the other methods for validations.
- Method 2 (“getName”) – This creates a Json object from method 1 and returns the “Name” property value.
- Method 3 (“getCanRelist”) – This creates a Json object from method 1 and returns the “CanRelist” property value.
- Method 4 (“getPromotions”) – This creates a Json object from method 1 and returns an integer flag after validating the promotion element “name” and “description” is set with the required values by looping through the promotion elements list. Further, the description was validated after removing the new line character.

Step 2 - Cteated a property file to read the URL from an external file.

Step 3 – Created a TestNG test case “ValidateAPIOutput” that uses assertions for validations of the API output. The “testing.xml” file was created to hold the test data as an external file which helps to avoid the hard coding of test data in the test case. This test case contains 3 tests that validate the above acceptance criteria. The “BeforeClass” was used to create an instance from “ConvertToJavaObject” class that runs as a common section for all 3 test cases.

- Test 1 (“validateName”) - This calls the method 2 in “ConvertToJavaObject” class and use assertion to compare the API output value with the parameterized test data.
- Test 2 (“validateCanRelist”) - This calls the method 3 in “ConvertToJavaObject” class and use assertion to compare the API output value with the parameterized test data.
- Test 3 (“validatePromotions”) - This calls the method 4 in “ConvertToJavaObject” class and use assertion to compare the integer flag that returns after validating the API output value with the parameterized test data.

Author – Ayesha Jayawardena
