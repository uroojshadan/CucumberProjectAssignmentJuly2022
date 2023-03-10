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

public class NewAccountStepDefinition extends TestBase {

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
	public void user_enters_the_in_the_field(String userInfo, String field) {
		if (field.equalsIgnoreCase("username")) {
			loginPage.enterUserName(userInfo);
		} else if (field.equalsIgnoreCase("password")) {
			loginPage.enterPassword(userInfo);
		} else{
			System.out.println("Entered information "+userInfo+" is invalid");
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
		} else {
			System.out.println("Button: "+button+" does not exist");
		}

		// switch case
		/*
		 * switch(button) { 
		 * case "signIn":
		 * loginPage.clickOnSignInButton(); 
		 * break; 
		 * case "bankCash":
		 * dashboardPage.clickOnBankAndCash(); 
		 * break; 
		 * case "newAccount":
		 * dashboardPage.clickOnNewAccount(); 
		 * break; 
		 * case "submit":
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
		} else if (field.equalsIgnoreCase("initialBalance")) {
			newaccountPage.enterInitialBalance(textEntry);
		} else if (field.equalsIgnoreCase("accountNumber")) {
			newaccountPage.enterAccountNumber(textEntry);
		} else if (field.equalsIgnoreCase("contactPerson")) {
			newaccountPage.enterContactPerson(textEntry);
		} else if (field.equalsIgnoreCase("Phone")) {
			newaccountPage.enterContactPersonPhone(textEntry);
		} else if (field.equalsIgnoreCase("internetBankingURL")) {
			newaccountPage.enterInternetBankingURL(textEntry);
		} else {
			System.out.println("Entered text :"+textEntry+" is invalid");
		}

		// switch case
		/*
		 * switch (field) 
		 * { 
		 * case "accountTitle":
		 * newaccountPage.enterAccountTitle(textEntry); 
		 * break; 
		 * case "description":
		 * newaccountPage.enterDescription(textEntry); 
		 * break; 
		 * case "initialBalance":
		 * newaccountPage.enterInitialBalance(textEntry); 
		 * break;
		 * case "accountNumber":
		 * newaccountPage.enterAccountNumber(textEntry); 
		 * break; 
		 * case "contactPerson":
		 * newaccountPage.enterContactPerson(textEntry); 
		 * break; 
		 * case "Phone":
		 * newaccountPage.enterContactPersonPhone(textEntry); 
		 * break; 
		 * case "internetBankingURL": 
		 * newaccountPage.enterInternetBankingURL(textEntry);
		 * break;
		 * 
		 * default: System.out.println("Invalid field"); }
		 */
	}

	@Then("^User should be able to validate account created successfully$")
	public void user_should_be_able_to_validate_account_created_successfully() {
//		boolean result=newaccountPage.validateAccountCreated();
//		Assert.assertTrue("Account Not Created", result);
		String expectedText = "Account Created Successfully";
		String actualText = newaccountPage.getMessage();
		Assert.assertTrue("Account Not Created", actualText.contains(expectedText));

	}

	@After
	public void tearDown() {
		driver.close();
		driver.quit();
	}

}
