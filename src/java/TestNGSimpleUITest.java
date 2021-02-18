import io.github.bonigarcia.wdm.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.testng.annotations.*;

public class TestNGSimpleUITest extends Base {

    public static String petclinicUrl = System.getProperty("petclinicUrl", "http://localhost:8080");
    private static WebDriver driver;

    @BeforeTest
    public void beforeClass() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
       // driver.get(petclinicUrl);
    }

    @AfterClass
    public static void afterClass() {
        driver.quit();
    }

    @Test
    public void findOwnersTestTestNG() {
        driver.get(chromeUrl);
        sleep(2000);
        driver.get(petclinicUrl);
        driver.findElement(By.xpath("//a[@title='find owners']")).click();
        driver.findElement(By.id("lastName")).sendKeys("Davis");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        String owner = driver.findElement(By.xpath("//a[@href='/owners/2']")).getText();
        driver.get(chromeUrl);

    }

    @Test
    public void vetListTestTestNG() {
        driver.get(chromeUrl);
        sleep();
        driver.get(petclinicUrl);
        driver.findElement(By.xpath("//a[@title='veterinarians']")).click();
        String vet = driver.findElement(By.xpath("//td")).getText();
       // Assert.assertEquals("Betty Davis", vet);
        driver.get(chromeUrl);
        sleep();
        driver.quit();
    }

}
