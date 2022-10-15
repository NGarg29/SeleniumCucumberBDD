package pages;

import org.openqa.selenium.By;

public class GmailPage {
	protected By EmailId = By.name("identifier");
	protected By EmailNext = By.cssSelector("#identifierNext");
	protected By Password = By.cssSelector("input[type = password]");
	protected By PasswordNext = By.cssSelector("#passwordNext");
	protected By ComposeButton = By.cssSelector("div.aic > div > div");
	protected By ToInput = By.xpath("//div[@name = 'to']//input");
	protected By SubjectInput = By.name("subjectbox");
	protected By TextBody = By.cssSelector("div.editable");
	protected By SendButton = By.xpath("//*[contains(@data-tooltip, 'Send')]");
	protected By SentFolder = By.xpath("//a[contains(@href, '#sent')]");
	protected By SubjectInMail = By.xpath("(//table[@role = 'grid']//tbody)[2]/tr[1]//span[@class='bog']");
	
}
