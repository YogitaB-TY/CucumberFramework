package hook;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import utility.Base;
import utility.PropertyFileReader;
import utility.WebDriverUtility;

public class Hook extends Base{
	Base base;
	public Hook(Base base) {
		this.base = base;
	}
	@Before
	public void initBrowser() throws Throwable {
		base.fileReader=new PropertyFileReader();
		base.webdriverUtil=new WebDriverUtility();
		String browserName=base.fileReader.getValueProperty("browser");
		if(browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			base.driver=new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			base.driver=new FirefoxDriver();
		}else {
			System.out.println("Browser name is Invalid: "+browserName);
		}
		base.webdriverUtil.maximizeScreen(base.driver).implicitWait(base.driver, 10);
		
	}
	@After
	public void quitBrowser(Scenario scenario) throws Throwable {
		if(scenario.isFailed()) {
			base.webdriverUtil.takeScreenshot(base.driver, scenario.getName());
			scenario.attach(base.webdriverUtil.takeScreenshot(base.driver), "image/png", scenario.getName());
		}
		base.driver.close();
	}
	
	


}
