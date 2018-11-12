package smallclaimspkg;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Step2 {

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
		txtUsername.sendKeys(Constant.DefUsername);
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
		
		// Click the Resolve Button
		driver.findElement(By.xpath("//button[@id='primaryUAButton']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='item-des' and contains(.,'By continuing this process')]")));
		
		// Complete Form2.1
		driver.findElement(By.xpath("//span[@class='item-des' and contains(.,'By continuing this process')]")).click();
		driver.findElement(By.xpath("//span[@class='item-des' and contains(.,'By checking this box')]")).click();
		driver.findElement(By.xpath("//button[@id='submitForm']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[1]/div[@class='accordion-heading' and 1]/a[@class='accordion-toggle collapsed' and 1]/u[1]")));
		
		// Complete Form2.3
		driver.findElement(By.xpath("//button[@id='submitForm']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='item-des' and contains(.,'Propose a different solution')]")));
		
		// Complete Form2.4
		//driver.findElement(By.xpath("//span[@class='item-des' and contains(.,'Accept')]")).click();
		driver.findElement(By.xpath("//span[@class='item-des' and contains(.,'Propose a different solution')]")).click();
		//driver.findElement(By.xpath("//span[@class='item-des' and contains(.,'Communicate directly with')]")).click();
		driver.findElement(By.xpath("//button[@id='submitForm']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@name='sc_paymentOfferToClose']")));
		
		// Complete Form2.5
		WebElement txtPaymentOfferToClose = driver.findElement(By.xpath("//*[@name='sc_paymentOfferToClose']"));
		WebElement txtClosePayFairnessDesc = driver.findElement(By.xpath("//*[@name='sc_closePayFairnessDesc']"));
		txtPaymentOfferToClose.sendKeys("700");
		txtClosePayFairnessDesc.sendKeys("My company can repair the fence for cheaper.");
		driver.findElement(By.xpath("//button[@id='submitForm']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class='controlLabel' and contains(.,'Will you make the payment')]/following-sibling::div[@class='row']/descendant::span[contains(.,'No')]")));
		
		// Complete Form2.8(a)
		//driver.findElement(By.xpath("//p[@class='controlLabel' and contains(.,'Will you make the payment')]/following-sibling::div[@class='row']/descendant::span[contains(.,'Yes')]")).click();
		driver.findElement(By.xpath("//p[@class='controlLabel' and contains(.,'Will you make the payment')]/following-sibling::div[@class='row']/descendant::span[contains(.,'No')]")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@name='fulton_paymentLatestDate']")));
		WebElement txtPaymentLatestDate = driver.findElement(By.xpath("//*[@name='fulton_paymentLatestDate']"));
		txtPaymentLatestDate.sendKeys("02-28-2019");
		//driver.findElement(By.xpath("//p[@class='controlLabel' and contains(.,'Can you pay')]/following-sibling::div[@class='row']/descendant::span[contains(.,'Yes')]")).click();
		driver.findElement(By.xpath("//p[@class='controlLabel' and contains(.,'Can you pay')]/following-sibling::div[@class='row']/descendant::span[contains(.,'each week')]")).click();
		//driver.findElement(By.xpath("//p[@class='controlLabel' and contains(.,'Can you pay')]/following-sibling::div[@class='row']/descendant::span[contains(.,'every two weeks')]")).click();
		//driver.findElement(By.xpath("//p[@class='controlLabel' and contains(.,'Can you pay')]/following-sibling::div[@class='row']/descendant::span[contains(.,'every three weeks')]")).click();
		//driver.findElement(By.xpath("//p[@class='controlLabel' and contains(.,'Can you pay')]/following-sibling::div[@class='row']/descendant::span[contains(.,'each month')]")).click();
		//driver.findElement(By.xpath("//p[@class='controlLabel' and contains(.,'Can you pay')]/following-sibling::div[@class='row']/descendant::span[contains(.,'every two months')]")).click();
		//driver.findElement(By.xpath("//p[@class='controlLabel' and contains(.,'Can you pay')]/following-sibling::div[@class='row']/descendant::span[contains(.,'every three months')]")).click();
		
		WebElement element = driver.findElement(By.xpath("//p[@class='controlLabel' and contains(.,'Can you pay')]/following-sibling::div[@class='row']/descendant::span[contains(.,'every three months')]"));
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
		
		WebElement txtDefPaymentAddress1 = driver.findElement(By.xpath("//*[@name='fulton_defPayment_Address1']"));
		WebElement txtDefPaymentCity = driver.findElement(By.xpath("//*[@name='fulton_defPayment_City']"));
		WebElement txtDefPaymentState = driver.findElement(By.xpath("//*[@name='fulton_defPayment_State']"));
		WebElement txtDefPaymentZip = driver.findElement(By.xpath("//*[@name='fulton_defPayment_ZipCode']"));
		txtDefPaymentAddress1.sendKeys(Constant.Addr1);
		txtDefPaymentCity.sendKeys(Constant.AddrCity);
		txtDefPaymentState.sendKeys(Constant.AddrState);
		txtDefPaymentZip.sendKeys(Constant.AddrZip);
		driver.findElement(By.xpath("//button[@id='submitForm']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@name='fulton_eachPaymentAmount']")));
		
		// Complete Form2.8(b)
		WebElement txtEachPaymentAmount = driver.findElement(By.xpath("//*[@name='fulton_eachPaymentAmount']"));
		WebElement txtEachPaymentDayOfWeek = driver.findElement(By.xpath("//*[@class='form-control input-lg no-rad formSingleList']"));
		txtEachPaymentAmount.sendKeys("28");
		txtEachPaymentDayOfWeek.sendKeys("Friday");
		driver.findElement(By.xpath("//button[@id='submitForm']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[2]/div[@class='row form-group' and 1]/div[@class='col-sm-4' and 1]/label[@class='btn modria-btn decline-btn' and 1]")));

		// Complete Form2.9
		driver.findElement(By.xpath("//button[@id='submitForm']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='item-des' and contains(.,'Yes')]")));
		
		// Complete Form2.10
		driver.findElement(By.xpath("//span[@class='item-des' and contains(.,'Yes')]")).click();
		//driver.findElement(By.xpath("//span[@class='item-des' and contains(.,'No')]")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='item-des' and contains(.,'I understand that if')]")));
		driver.findElement(By.xpath("//span[@class='item-des' and contains(.,'I understand that if')]")).click();
		WebElement txtSignatureDef = driver.findElement(By.xpath("//*[@name='sc_fullNameSignatureDef']"));
		txtSignatureDef.sendKeys(Constant.DefSignature);
		driver.findElement(By.xpath("//button[@id='submitForm']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[1]/div[@class='accordion-heading' and 1]/a[@class='accordion-toggle collapsed' and 1]/u[1]")));
		
		// Complete Form2.11
		driver.findElement(By.xpath("//button[@id='submitForm']")).click();
		
		// Close browser
        //driver.close();
	}

}
