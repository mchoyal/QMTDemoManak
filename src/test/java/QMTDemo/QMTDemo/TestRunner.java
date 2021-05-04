package QMTDemo.QMTDemo;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = { "json", "json:target/cucumber.json" }, features = { "D:\\ManakProjectData\\ON\\eclipse_ws_ON24\\QMTDemo\\src\\test\\java\\QMTDemo\\QMTDemo\\qmt_demo.feature" }, strict = true)

public class TestRunner {
	static WebDriver driver;
	@BeforeClass
	public static void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver","D:\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		System.out.println("Driver created!!!");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
        driver.get("https://wccqa.on24.com/webcast/login");
        System.out.println("Tital is = "+driver.getTitle());
	}

	@AfterClass
	public static void tearDown() throws Exception {
		driver.close();
		driver.quit();
		System.out.println("Driver closed!!!");
	}
}