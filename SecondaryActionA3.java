package smallclaimspkg;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SecondaryActionA3 {

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
		txtUsername.sendKeys(Constant.MedUsername);
		txtPassword.sendKeys(Constant.Password);
		driver.findElement(By.xpath("//input[@id='validate']")).click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.navigate().to(Constant.DisputeURL);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='primaryUAButton']")));
				
		// Click Resolve Button
		driver.findElement(By.xpath("//button[@id='primaryUAButton']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='item-des' and contains(.,'Post this welcome message')]")));
				
		// Complete Form A-3 Post a Welcome Message to the Parties
		driver.findElement(By.xpath("//span[@class='item-des' and contains(.,'Post this welcome message')]")).click();
        	driver.findElement(By.xpath("//button[@id='submitForm']")).click();
				
        	// Close browser
        //driver.close();
	}

	
}
