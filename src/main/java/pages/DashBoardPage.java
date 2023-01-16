package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class DashBoardPage {

	WebDriver driver;

	@FindBy(how = How.XPATH, using = "//span[text()='Bank & Cash']")
	WebElement BANKANDCASHONDASHBOARD_ELEMENT;
	@FindBy(how = How.XPATH, using = "//a[text()='New Account']")
	WebElement NEWACCOUNTONDASHBOARD_ELEMENT;

	public DashBoardPage(WebDriver driver) {
		this.driver=driver;	
	}

	public void clickOnBankAndCash() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		BANKANDCASHONDASHBOARD_ELEMENT.click();
	}

	public void clickOnNewAccount() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		NEWACCOUNTONDASHBOARD_ELEMENT.click();
	}
}
