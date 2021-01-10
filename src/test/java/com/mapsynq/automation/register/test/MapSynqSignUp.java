package com.mapsynq.automation.register.test;

import static org.testng.AssertJUnit.assertTrue;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.mapsynq.automation.helper.TestBase;
import com.mapsynq.automation.pages.HomePage;
import com.mapsynq.automation.pages.profile.UserRegistrationPage;

public class MapSynqSignUp extends TestBase {

	public String firstName, lastName, dob, email, password;
	public HomePage homePage;
	public UserRegistrationPage userRegistrationPage;

	@Parameters({"firstName", "lastName" , "dob", "email", "password"})
	@BeforeClass
	public void setup(String firstName, String lastName, String dob, String email, String password)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.email = email;
		this.password = password;
		userRegistrationPage = new UserRegistrationPage(driver);
	}

	@Test
	public void accountSignUp() throws Exception {
		//userRegistrationPage = homePage.clickRegisterLink();

		userRegistrationPage.setFirstName(firstName).setLastName(lastName).clickGenderOption()
							.setDOB(dob).setEmail(email).setPassword(password).setConfirmPassword(password)
							.clickAgreeCheckBox().clickSubmit();
		
		assertTrue("Problem in Sign Up", userRegistrationPage.getMessage().contains("Incorrect"));
	}

}
