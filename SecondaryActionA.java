package smallclaimspkg;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SecondaryActionA {

	public static void main(String[] args) {
		// Set driver and URL
		System.setProperty("webdriver.chrome.driver","/Users/erik.teno/selenium-java-3.14.0/chromedriver");
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver,10);
		driver.manage().window().setSize(new Dimension(2560, 1440));
				    		
		// Launch browser and direct it to the Base URL
		driver.get(Constant.SiteURL);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()[contains(.,'Log In')]]")));
		driver.findElement(By.xpath("//a[text()[contains(.,'Log In')]]")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='uid']")));
		WebElement txtUsername = driver.findElement(By.xpath("//input[@name='uid']"));
		WebElement txtPassword = driver.findElement(By.xpath("//input[@name='password']"));
		txtUsername.sendKeys(Constant.PtfUsername);
		txtPassword.sendKeys(Constant.Password);
		driver.findElement(By.xpath("//input[@id='validate']")).click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.navigate().to(Constant.DisputeURL);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='SECONDARY_A']/span[1]")));
		
		// Click Request Help from Mediator User Action
		driver.findElement(By.xpath("//a[@id='SECONDARY_A']/span[1]")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='item-des' and contains(.,'Work with a mediator')]")));
		
		// Complete Form A.1 Information about Mediators
		driver.findElement(By.xpath("//span[@class='item-des' and contains(.,'Work with a mediator')]")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='item-des' and contains(.,'I understand that mediation')]")));
		driver.findElement(By.xpath("//span[@class='item-des' and contains(.,'I understand that mediation')]")).click();
		driver.findElement(By.xpath("//span[@class='item-des' and contains(.,'The mediation services provided')]")).click();
		driver.findElement(By.xpath("//span[@class='item-des' and contains(.,'I understand that if I need legal')]")).click();
	
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//span[@class='item-des' and contains(.,'I agree not to subpoena')]")));
		
		driver.findElement(By.xpath("//span[@class='item-des' and contains(.,'I agree not to subpoena')]")).click();
		driver.findElement(By.xpath("//span[@class='item-des' and contains(.,'I will not hold the Justice Center')]")).click();
		driver.findElement(By.xpath("//span[@class='item-des' and contains(.,'I acknowledge that, by my participation')]")).click();
		driver.findElement(By.xpath("//span[@class='item-des' and contains(.,'If full financial disclosure is relevant')]")).click();
		
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//span[@class='item-des' and contains(.,'I understand that once I sign')]")));
		driver.findElement(By.xpath("//span[@class='item-des' and contains(.,'I understand that once I sign')]")).click();
		WebElement txtPtfSignature = driver.findElement(By.xpath("//input[@name='fulton_consentMediatorSignature']"));
		txtPtfSignature.sendKeys(Constant.PtfSignature);
		driver.findElement(By.xpath("//button[@id='submitForm']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[1]/div[@class='accordion-heading' and 1]/a[@class='accordion-toggle collapsed' and 1]/u[1]")));
		
		// Complete Form A.3 What's Next?
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//div[1]/div[@class='accordion-heading' and 1]/a[@class='accordion-toggle collapsed' and 1]/u[1]")));
		driver.findElement(By.xpath("//button[@id='submitForm']")).click();
		
		// Close browser
        //driver.close();
		
		
	}

	
}
