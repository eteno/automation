package smallclaimspkg;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Step1 {

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
    		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='primaryUAButton']")));
    		
    		// Click the resolve button
    		driver.findElement(By.xpath("//button[@id='primaryUAButton']")).click();
    		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[1]/div[@class='modria-components checkbox overlay-p' and 1]/label[@class='item-des-label' and 1]")));
    		
    		// Complete Form1.1
    		driver.findElement(By.xpath("//div[1]/div[@class='modria-components checkbox overlay-p' and 1]/label[@class='item-des-label' and 1]")).click();
    		driver.findElement(By.xpath("//div[2]/div[@class='modria-components checkbox overlay-p' and 1]/label[@class='item-des-label' and 1]")).click();
    		driver.findElement(By.xpath("//button[@id='submitForm']")).click();
    		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[1]/div[@class='accordion-heading' and 1]/a[@class='accordion-toggle collapsed' and 1]/u[1]")));
    		
    		// Complete Form1.3
    		driver.findElement(By.xpath("//button[@id='submitForm']")).click();
    		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[1]/div[@class='modria-components radio overlay-p' and 1]/label[@class='item-des-label' and 1]")));
    		
    		// Complete Form1.x
    		driver.findElement(By.xpath("//div[1]/div[@class='modria-components radio overlay-p' and 1]/label[@class='item-des-label' and 1]")).click();
    		// driver.findElement(By.xpath("//div[2]/div[@class='modria-components radio overlay-p' and 1]/label[@class='item-des-label' and 1]")).click();
    		driver.findElement(By.xpath("//button[@id='submitForm']")).click();
    		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='sc_totalDesiredPaymentAmount']")));
    		
    		
    		// Complete Form1.4
    		WebElement txtTotalAmount = driver.findElement(By.xpath("//input[@name='sc_totalDesiredPaymentAmount']"));
    		WebElement txtPlAmountFair = driver.findElement(By.xpath("//*[@name='sc_paymentFairnessDescription']"));
    		txtTotalAmount.sendKeys("1000");
    		txtPlAmountFair.sendKeys("The cost of the fence is actually $2000.00, however I am only asking for half the amount.");
    		driver.findElement(By.xpath("//button[@id='submitForm']")).click();
    		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@name='sc_lowestOfferAutoAccept']")));
    		
    		// Complete Form1.5
    		WebElement txtLowestOffer = driver.findElement(By.xpath("//*[@name='sc_lowestOfferAutoAccept']"));
    		driver.findElement(By.xpath("//*[@name='sc_lowestOfferAutoAccept']")).clear();
    		txtLowestOffer.sendKeys("800");
    		driver.findElement(By.xpath("//button[@id='submitForm']")).click();
    		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@name='fulton_userPayment_dateAcceptance']")));
    		
    		// Complete Form1.6
    		WebElement txtPayLatestDate = driver.findElement(By.xpath("//*[@name='fulton_userPayment_dateAcceptance']"));
    		WebElement txtPayAddr1 = driver.findElement(By.xpath("//*[@name='sc_userPayment_Address1']"));
    		WebElement txtPayAddrCity = driver.findElement(By.xpath("//*[@name='sc_userPayment_City']"));
    		WebElement txtPayAddrState = driver.findElement(By.xpath("//*[@name='sc_userPayment_State']"));
    		WebElement txtPayAddrZip = driver.findElement(By.xpath("//*[@name='sc_userPayment_ZipCode']"));
    		txtPayLatestDate.sendKeys("12-31-2018");
    		txtPayAddr1.sendKeys(Constant.Addr1);
    		txtPayAddrCity.sendKeys(Constant.AddrCity);
    		txtPayAddrState.sendKeys(Constant.AddrState);
    		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//*[@name='sc_userPayment_ZipCode']")));
    		txtPayAddrZip.sendKeys(Constant.AddrZip);
    		driver.findElement(By.xpath("//button[@id='submitForm']")).click();
    		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[2]/div[@class='row form-group' and 1]/div[@class='col-sm-4' and 1]/label[@class='btn modria-btn decline-btn' and 1]")));
	
    		// Complete Form1.7
    		driver.findElement(By.xpath("//button[@id='submitForm']")).click();
    		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[1]/div[@class='modria-components radio overlay-p' and 1]/label[@class='item-des-label' and 1]")));
	
    		// Complete Form1.8
    		driver.findElement(By.xpath("//div[1]/div[@class='modria-components radio overlay-p' and 1]/label[@class='item-des-label' and 1]")).click();
    		//driver.findElement(By.xpath("//div[2]/div[@class='modria-components radio overlay-p' and 1]/label[@class='item-des-label' and 1]")).click();
    		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='item-des' and contains(.,'I understand that the amount')]")));
    		driver.findElement(By.xpath("//span[@class='item-des' and contains(.,'I understand that the amount')]")).click();
    		driver.findElement(By.xpath("//span[@class='item-des' and contains(.,'I understand that if')]")).click();
    		WebElement txtPlSignature = driver.findElement(By.xpath("//input[@name='sc_offerPtfSignature']"));
    		txtPlSignature.sendKeys(Constant.PtfSignature);
    		driver.findElement(By.xpath("//button[@id='submitForm']")).click();
    		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[1]/div[@class='accordion-heading' and 1]/a[@class='accordion-toggle collapsed' and 1]/u[1]")));
    		
    		// Complete Form1.9
    		driver.findElement(By.xpath("//button[@id='submitForm']")).click();
	
    		// Close browser
        //driver.close();
		
	}

}
