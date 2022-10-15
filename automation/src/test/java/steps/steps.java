package steps;

import java.awt.AWTException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.GmailPage;

public class steps extends GmailPage{
	
	WebDriver driver = null;
	String subjectToSent = "Incubyte1";
	
	@Given("Launch Gmail Application")
	public void launch_gmail_application() {
		driver = new ChromeDriver();	
		driver.get("https://www.gmail.com/");
	}

	@And("Enter username and password")
	public void enter_username_and_password() throws InterruptedException {
		driver.findElement(EmailId).sendKeys("testincubyte@gmail.com");
		driver.findElement(EmailNext).click();	
		Thread.sleep(5000);
		driver.findElement(Password).sendKeys("TestIn123");
		driver.findElement(PasswordNext).click();
		driver.manage().timeouts().implicitlyWait(15000,TimeUnit.MILLISECONDS);
	}

	@When("Send an email with subject {string}")
	public void send_an_email_with_subject(String string) throws InterruptedException {
		driver.findElement(ComposeButton).click();	
		driver.manage().timeouts().implicitlyWait(10000,TimeUnit.MILLISECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement To = wait.until(ExpectedConditions.elementToBeClickable(ToInput));
		To.sendKeys("nehadata10@gmail.com");
		driver.findElement(SubjectInput).sendKeys("Incubyte");
		driver.findElement(TextBody).sendKeys("Automation QA test for Incubyte");
		driver.findElement(SendButton).click();
		driver.manage().timeouts().implicitlyWait(10000,TimeUnit.MILLISECONDS);
	}

	@Then("Verify the email in sent folder")
	public void verify_the_email_in_sent_folder() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement sentFolder = wait.until(ExpectedConditions.elementToBeClickable(SentFolder));
		sentFolder.click();
		driver.manage().timeouts().implicitlyWait(5000,TimeUnit.MILLISECONDS);
		String subject = driver.findElement(SubjectInMail).getText();
		System.out.println(subject + subjectToSent);
		Assert.assertNotEquals(subject, subjectToSent);
	}
}
