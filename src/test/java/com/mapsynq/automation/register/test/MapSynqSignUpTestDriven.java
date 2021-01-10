package com.mapsynq.automation.register.test;

import static org.testng.AssertJUnit.assertTrue;
import java.io.File;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.mapsynq.automation.helper.TestBase;
import com.mapsynq.automation.helper.UtilClass;
import com.mapsynq.automation.pages.HomePage;
import com.mapsynq.automation.pages.profile.UserRegistrationPage;

public class MapSynqSignUpTestDriven extends TestBase {

	private static Logger Log = Logger.getLogger(MapSynqSignUpTestDriven.class);
	public String firstName, lastName, dob, email, password;
	public HomePage homePage;
	public UserRegistrationPage userRegistrationPage;
	
	@DataProvider(name = "SignUpData")  
	public static Object[][] credentialsFromExcel() throws Exception {
		
		String workingDir = System.getProperty("user.dir");
		Log.info("Current Working directory : " + workingDir);
		String defaultConfigPath = workingDir+File.separator+"src"+File.separator+"main"+File.separator+"resources"+File.separator+"test.xlsx";
		Object[][] testObjArray = UtilClass.getTableArray(defaultConfigPath,"Sheet2");
        return testObjArray;
	}

	@BeforeClass
	public void setup()
	{
		userRegistrationPage = new UserRegistrationPage(driver);
	}

	@Test(priority = 1, dataProvider="SignUpData")
	public void accountSignUp(String firstName, String lastName, String dob, String email, String password) throws Exception {
		userRegistrationPage.setFirstName(firstName).setLastName(lastName).clickGenderOption()
							.setDOB(dob).setEmail(email).setPassword(password).setConfirmPassword(password)
							.clickAgreeCheckBox().clickSubmit();

		assertTrue("Problem in Sign Up", userRegistrationPage.getMessage().contains("Incorrect"));
	}

}
