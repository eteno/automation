package smallclaimspkg;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SecondaryActionA5 {

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
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='item-des' and contains(.,'Create an agreement')]")));
				
		// Complete Form A-5.1 Mediation in Progress
		driver.findElement(By.xpath("//span[@class='item-des' and contains(.,'Create an agreement')]")).click();
        	driver.findElement(By.xpath("//button[@id='submitForm']")).click();
        	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='sc_totalPayAmount']")));
        	
        	// Complete Form A-5.2 Mediated Solution - Amount
        	WebElement txtTotalPayAmount = driver.findElement(By.xpath("//*[@name='sc_totalPayAmount']"));
        	txtTotalPayAmount.sendKeys("850");
        	driver.findElement(By.xpath("//button[@id='submitForm']")).click();
        	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@name='fulton_userPayment_medit_paymentLatestDate']")));
        	
        	// Complete Form A-5.3 Mediated Solution - Payment Terms
        	WebElement txtPaymentLatestDate = driver.findElement(By.xpath("//*[@name='fulton_userPayment_medit_paymentLatestDate']"));
    		txtPaymentLatestDate.sendKeys("02-28-2019");
    		driver.findElement(By.xpath("//span[@class='item-des' and contains(.,'each week')]")).click();
    		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//*[@name='sc_userPayment_Address1']")));
    		WebElement txtDefPaymentAddress1 = driver.findElement(By.xpath("//*[@name='sc_userPayment_Address1']"));
    		WebElement txtDefPaymentCity = driver.findElement(By.xpath("//*[@name='sc_userPayment_City']"));
    		WebElement txtDefPaymentState = driver.findElement(By.xpath("//*[@name='sc_userPayment_State']"));
    		WebElement txtDefPaymentZip = driver.findElement(By.xpath("//*[@name='sc_userPayment_ZipCode']"));
    		txtDefPaymentAddress1.sendKeys(Constant.Addr1);
    		txtDefPaymentCity.sendKeys(Constant.AddrCity);
    		txtDefPaymentState.sendKeys(Constant.AddrState);
    		txtDefPaymentZip.sendKeys(Constant.AddrZip);
    		driver.findElement(By.xpath("//button[@id='submitForm']")).click();
    		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@name='fulton_userPayment_medit_eachPaymentAmount']")));
    		WebElement txtPaymentAmount = driver.findElement(By.xpath("//*[@name='fulton_userPayment_medit_eachPaymentAmount']"));
    		txtPaymentAmount.sendKeys("70.83");
    		WebElement dropDayOfWeek = driver.findElement(By.xpath("//*[@label='Which day of the week will Donnie send the payment?']"));
        dropDayOfWeek.sendKeys("Friday");
        driver.findElement(By.xpath("//button[@id='submitForm']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='item-des' and contains(.,'Yes. Send the agreement')]")));
    		
        	// Complete Form A-5.4 Review Agreement
        driver.findElement(By.xpath("//span[@class='item-des' and contains(.,'Yes. Send the agreement')]")).click();	
        driver.findElement(By.xpath("//button[@id='submitForm']")).click();
        
        // Close browser
        //driver.close();
	}

	
}
