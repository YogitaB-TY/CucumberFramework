package utility;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.messages.internal.com.google.common.io.Files;

/**
 * This class contains all webdriver and WebElement actions 
 * @author Yogita
 *
 */
public class WebDriverUtility {
	/**
	 * This method used to take screen shot
	 * @param driver
	 * @param screenshotName
	 * @throws Throwable
	 */
	public void takeScreenshot(WebDriver driver,String screenshotName) throws Throwable {
		
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		File destination=new File(".\\screenshot\\"+screenshotName+".png");
		Files.copy(source, destination);
	}
	
	public byte[] takeScreenshot(WebDriver driver) throws Throwable {
		
		TakesScreenshot ts=(TakesScreenshot)driver;
		byte[] bytes=ts.getScreenshotAs(OutputType.BYTES);
		return bytes;
		
	}
	
	public void mouseHover(WebDriver driver,WebElement element) {
		
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();
	}
	
	public void mouseHoverAndClick(WebDriver driver,WebElement elementToMouseHover, WebElement elementToClick) {
		
		Actions act=new Actions(driver);
		act.moveToElement(elementToMouseHover).click(elementToClick).build().perform();
	}
	
	public void selectDropdown(WebElement element,int index) {
		Select sel=new Select(element);
		sel.selectByIndex(index);
	}
	public void selectDropdown(WebElement element,String visibleText) {
		Select sel=new Select(element);
		sel.selectByVisibleText(visibleText);
	}
	
	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	
	public void dismisAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	
	public void switchToFrame(WebDriver driver,int index) {
		
		driver.switchTo().frame(index);
	}
	
	public void switchToFrame(WebDriver driver,String idOrName) {

		driver.switchTo().frame(idOrName);
	}
	public void switchToFrame(WebDriver driver,WebElement element) {
		
		driver.switchTo().frame(element);
	}
	
	public WebDriverUtility maximizeScreen(WebDriver driver) {
		
		driver.manage().window().maximize();
		return this;
	}
	
	public WebDriverUtility implicitWait(WebDriver driver,long timeInSeconds) {
		
		driver.manage().timeouts().implicitlyWait(timeInSeconds, TimeUnit.SECONDS);
		return this;
	}

}
