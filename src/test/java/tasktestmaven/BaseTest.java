package tasktestmaven;
 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;

 
public class BaseTest {
    public WebDriver driver;
 
    @BeforeClass
    public void setup () {
    	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Berkay\\Chrome Driver\\chromedriver.exe");
 
        //Create a Chrome driver. All test classes use this.
        driver = new ChromeDriver();
 
        //Maximize Window
        driver.manage().window().maximize();
    }
 
    @AfterSuite
    public void teardown () {
        driver.quit();
    }
}