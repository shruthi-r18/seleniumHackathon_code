package seleniumHackathon;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class currencyConvertBasePage {
	
	public currencyConvertBasePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="midmarketFromCurrency")
	public WebElement fromCountry ;
	@FindBy(id="midmarketFromCurrency-listbox")
	public WebElement fromCountryList ;
	@FindBy(xpath="//div[text()='USD']")
	public WebElement selectUSA ;
	@FindBy(id="midmarketToCurrency")
	public WebElement toCountry;
	@FindBy(id="midmarketToCurrency-listbox")
	public WebElement toCountryList;
	@FindBy(xpath="//div[text()='INR']")
	public WebElement selectIndia;
	@FindBy(xpath="//button[@class=\"button__BaseButton-sc-1qpsalo-0 clGTKJ\" and text()='Convert']")
	public WebElement convertButton;
	
	public boolean launchApp(WebDriver driver, String sURL) {
		boolean isLaunchApp = false;
		driver.get(sURL);
		String sActualURL = driver.getCurrentUrl();

		if (sURL.equals(sActualURL)) {
			isLaunchApp = true;
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return isLaunchApp;
	}
	
	public boolean selectCountryFrom() {
		boolean isSelected =false;
		if(fromCountry.isDisplayed()) {
			fromCountry.click();
			isSelected=true;
		}else {
			System.out.println("select country_from list"); 
		}
		
		return isSelected;
	}
	public boolean selectCountryUSA() {
		boolean isSelected =false;
		if(fromCountryList.isDisplayed()) {
			if(selectUSA.isDisplayed()) {
				selectUSA.click();
			isSelected=true;
			}
		}else {
			System.out.println("select USA list"); 
		}
		
		return isSelected;
	}
	
	public boolean selectCountryTo() {
		boolean isSelected =false;
		if(toCountry.isDisplayed()) {
			toCountry.click();
			isSelected=true;
		}else {
			System.out.println("select country_to list"); 
		}
		
		return isSelected;
	}
	public boolean selectCountryIndia() {
		boolean isSelected =false;
		if(toCountryList.isDisplayed()) {
			if(selectIndia.isDisplayed()) {
				selectIndia.click();
			isSelected=true;
			}
		}else {
			System.out.println("select India list"); 
		}
		
		return isSelected;
	}
	public boolean clickConvertButton() {
		boolean isSelected =false;
		if(convertButton.isDisplayed()) {
			convertButton.click();
			isSelected=true;
		}else {
			System.out.println("select country_to list"); 
		}
		
		return isSelected;
	}
	
	
}
