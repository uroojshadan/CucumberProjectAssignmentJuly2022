package pages;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class NewAccountPage {
	WebDriver driver;

	@FindBy(how = How.XPATH, using = "//div/h5[text()='Add New Account']")
	WebElement NEWACCOUNTPAGE_HEADER;
	@FindBy(how = How.XPATH, using = "//input[@id='account']")
	WebElement ACCOUNT_TITLE_ELEMENT;
	@FindBy(how = How.XPATH, using = "//input[@id='description']")
	WebElement DESCRIPTION_ELEMENT;
	@FindBy(how = How.XPATH, using = "//input[@id='balance']")
	WebElement INITIAL_BALANCE_ELEMENT;
	@FindBy(how = How.XPATH, using = "//input[@id='account_number']")
	WebElement ACCOUNT_NUMBER_ELEMENT;
	@FindBy(how = How.XPATH, using = "//input[@id='contact_person']")
	WebElement CONTACT_PERSON_ELEMENT;
	@FindBy(how = How.XPATH, using = "//input[@id='contact_phone']")
	WebElement CONTACT_PHONE_ELEMENT;
	@FindBy(how = How.XPATH, using = "//input[@id='ib_url']")
	WebElement INTERNET_BANKINGURL_ELEMENT;
	@FindBy(how = How.XPATH, using = "//button[text()=' Submit']")
	WebElement SUBMIT_BUTTON_ELEMENT;
	@FindBy(how = How.XPATH, using = "//tbody/tr/td[1]")
	List<WebElement> LISTOFACCOUNTS_ELEMENT;
	@FindBy(how= How.XPATH , using="//div[@id='page-wrapper']/div[3]/div[1]") 
	WebElement MESSAGE_ELEMENT;

	public NewAccountPage(WebDriver driver) {
		this.driver = driver;
	}

	public int generateRandomNumber(int boundaryNo) {
		Random rn = new Random();
		int randomNo = rn.nextInt(boundaryNo);
		return randomNo;

	}

	String uniqueName;

	public void enterAccountTitle(String name) {
		int random = generateRandomNumber(9999);
		uniqueName = name + random;
		ACCOUNT_TITLE_ELEMENT.sendKeys(uniqueName);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public void enterDescription(String descriptionText) {
		DESCRIPTION_ELEMENT.sendKeys(descriptionText);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void enterInitialBalance(String balanceAmount) {
		INITIAL_BALANCE_ELEMENT.sendKeys(balanceAmount);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public void enterAccountNumber(String accountNo) {
		int random = generateRandomNumber(999);
		ACCOUNT_NUMBER_ELEMENT.sendKeys(accountNo + random);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void enterContactPerson(String contactPersonName) {
		CONTACT_PERSON_ELEMENT.sendKeys(contactPersonName);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void enterContactPersonPhone(String contactPersonPhone) {
		CONTACT_PHONE_ELEMENT.sendKeys(contactPersonPhone);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public void enterInternetBankingURL(String internetBankingUrl) {
		INTERNET_BANKINGURL_ELEMENT.sendKeys(internetBankingUrl);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void clickOnSubmitButton() {
		SUBMIT_BUTTON_ELEMENT.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/*Validating that the new customer added is in  List Of Accounts table
	 * 
	 * When a new account is created it gets added at the bottom of accounts table
	 * on this page hence we are getting all the names from the table in a list and
	 * then iterating through last 10 elements to see if a match is found between
	 * the name of the account just added. int
	 * size=LISTOFACCOUNTS_ELEMENT.size()-1;-->since size or no of entries will be
	 * size -1 because list index starts at 0. in for loop we are starting from last
	 * entry upto last entry-10(last 10 entries)
	 * 
	 * public boolean validateAccountCreated() { 
	 * boolean match = false;// for assertion on NewAccountStepDefinition.java class
	 * int size = LISTOFACCOUNTS_ELEMENT.size() - 1; 
	 * for (int i = size; i >= size -10; i--) { 
	 * if(uniqueName.equalsIgnoreCase(LISTOFACCOUNTS_ELEMENT.get(i).getText())) {
	 * match = true; break; 
	 * } 
	 * } 
	 * return match;
	 * }
	 */
	
	//Validating by seeing the success message that "account created successfully"
	public String getMessage() {
		String message=MESSAGE_ELEMENT.getText();
		return message;
	}

}
