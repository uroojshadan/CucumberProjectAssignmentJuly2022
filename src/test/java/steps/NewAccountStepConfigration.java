package steps;

import org.openqa.selenium.support.PageFactory;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;
import pages.DashBoardPage;
import pages.LoginPage;
import pages.NewAccountPage;
import pages.TestBase;

public class NewAccountStepConfigration extends TestBase {

	LoginPage loginPage;
	DashBoardPage dashboardPage;
	NewAccountPage newaccountPage;

	@Before
	public void setUp() {
		initDriver();
		loginPage = PageFactory.initElements(driver, LoginPage.class);
		dashboardPage = PageFactory.initElements(driver, DashBoardPage.class);
		newaccountPage = PageFactory.initElements(driver, NewAccountPage.class);
	}

	@Given("^User is on the techfios login page$")
	public void user_is_on_the_techfios_login_page() {
		driver.get("https://techfios.com/billing/?ng=admin/");
	}

	@When("^User enters the \"([^\"]*)\" in the \"([^\"]*)\" field$")
	public void user_enters_the_in_the_field(String username_OR_password, String field) {
		if (field.equalsIgnoreCase("username")) {
			loginPage.enterUserName(username_OR_password);
		} else if (field.equalsIgnoreCase("password")) {
			loginPage.enterPassword(username_OR_password);
		}
	}

	@When("^User clicks on \"([^\"]*)\"$")
	public void user_clicks_on_button(String button) {

		if (button.equalsIgnoreCase("signIn")) {
			loginPage.clickOnSignInButton();
		} else if (button.equalsIgnoreCase("bankCash")) {
			dashboardPage.clickOnBankAndCash();
		} else if (button.equalsIgnoreCase("newAccount")) {
			dashboardPage.clickOnNewAccount();
		} else if (button.equalsIgnoreCase("submit")) {
			newaccountPage.clickOnSubmitButton();
		}

		// switch case
		/*
		 * switch(button.toUpperCase()) { 
		 * case "SIGNIN":
		 * loginPage.clickOnSignInButton(); 
		 * break; 
		 * case "BANKCASH":
		 * dashboardPage.clickOnBankAndCash(); 
		 * break; 
		 * case "NEWACCOUNT":
		 * dashboardPage.clickOnNewAccount(); 
		 * break; 
		 * case "SUBMIT":
		 * newaccountPage.clickOnSubmitButton(); 
		 * break; 
		 * default:
		 * System.out.println("No such button"); 
		 * }
		 */
	}

	@Then("^User should land on Dashboard page$")
	public void user_should_land_on_Dashboard_page() {
		String actualTitle = loginPage.getPageTitle();
		String expectedTitle = "Dashboard- iBilling";
		Assert.assertEquals(expectedTitle, actualTitle);
	}

	@Then("^User enters \"([^\"]*)\" in the \"([^\"]*)\" field in accounts page$")
	public void user_enters_in_the_field_in_accounts_page(String textEntry, String field) {

		if (field.equalsIgnoreCase("accountTitle")) {
			newaccountPage.enterAccountTitle(textEntry);
		} 
		else if (field.equalsIgnoreCase("description")) {
			newaccountPage.enterDescription(textEntry);
		} 
		else if (field.equalsIgnoreCase("initialBalance")) {
			newaccountPage.enterInitialBalance(textEntry);
		} 
		else if (field.equalsIgnoreCase("accountNumber")) {
			newaccountPage.enterAccountNumber(textEntry);
		} 
		else if (field.equalsIgnoreCase("contactPerson")) {
			newaccountPage.enterContactPerson(textEntry);
		} 
		else if (field.equalsIgnoreCase("Phone")) {
			newaccountPage.enterContactPersonPhone(textEntry);
		} 
		else if (field.equalsIgnoreCase("internetBankingURL")) {
			newaccountPage.enterInternetBankingURL(textEntry);
		}

		// switch case
		/*
		 * switch (field.toUpperCase()) { 
		 * case "ACCOUNTTITLE":
		 * newaccountPage.enterAccountTitle(textEntry); 
		 * break; 
		 * case "DESCRIPTION":
		 * newaccountPage.enterDescription(textEntry); 
		 * break; 
		 * case "INITIALBALANCE":
		 * newaccountPage.enterInitialBalance(textEntry); 
		 * break; 
		 * case "ACCOUNTNUMBER":
		 * newaccountPage.enterAccountNumber(textEntry); 
		 * break; 
		 * case "CONTACTPERSON":
		 * newaccountPage.enterContactPerson(textEntry); 
		 * break; 
		 * case "PHONE":
		 * newaccountPage.enterContactPersonPhone(textEntry); 
		 * break; 
		 * case "INTERNETBANKINGURL": newaccountPage.enterInternetBankingURL(textEntry);
		 * break; 
		 * 
		 * default:
		 * System.out.println("Invalid entry");
		 * }
		 */
	}

	@Then("^User should be able to validate account created successfully$")
	public void user_should_be_able_to_validate_account_created_successfully() {
		String expectedText="Account Created Successfully";
		String actualText=newaccountPage.getMessage();
		Assert.assertTrue("Account Not Created", actualText.contains(expectedText));
	
	}
	

	@After
	public void tearDown() {
		driver.close();
		driver.quit();
	}

}
