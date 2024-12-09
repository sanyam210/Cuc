package stepdefinitions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.ConfigReader;

public class Hooks {

    public String baseURL;
    public static ExtentReports extent;
    public static ThreadLocal<ExtentTest> test = new ThreadLocal<>();
    static Logger log = LogManager.getLogger("Hooks");
    public static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    
    
  public static WebDriver getDriver() {
	  return driver.get();
  }

    @Before
    public void setUp(Scenario scenario) {
        try {
        	if(extent==null) {
        		ExtentSparkReporter htmlReporter = new ExtentSparkReporter("ExtentReport.html");
        		extent = new ExtentReports();
                extent.attachReporter(htmlReporter);
                
        	}
        	String name = scenario.getName();
        	test.set(extent.createTest(name));
            log.info("Extent reporting initialized for scenario: ");
            baseURL = ConfigReader.getInstance().getProperty("BASEURL");
            driver.set(new ChromeDriver());
            getDriver().manage().window().maximize();
            getDriver().manage().deleteAllCookies();
            getDriver().get(baseURL);
        } catch (Exception e) {
            log.error("Error in setUp: " + e.getMessage());
        }
    }

    @After
    public void tearDown(Scenario scenario) {
        try {
            if (scenario.isFailed()) {
                test.get().log(Status.FAIL, MarkupHelper.createLabel(scenario.getName() + " FAIL", ExtentColor.RED));
            } else {
                test.get().log(Status.PASS, MarkupHelper.createLabel(scenario.getName() + " PASS", ExtentColor.GREEN));
            }

            if (getDriver() != null) {
                getDriver().quit(); // Close the driver properly after each scenario
            }

            driver.remove();
            test.remove();
        } catch (Exception e) {
            log.error("Error during tearDown: " + e.getMessage());
        } finally {
            if (extent != null) {
                extent.flush();
            }
        }
    }
}