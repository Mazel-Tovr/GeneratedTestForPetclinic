//import io.github.bonigarcia.wdm.*;
//import org.openqa.selenium.*;
//import org.openqa.selenium.chrome.*;
//import org.testng.*;
//import org.testng.annotations.*;
//
//public class TestNGParameterizedUiTest extends Base {
//
//    public static String petclinicUrl = System.getProperty("petclinicUrl", "http://localhost:8080");
//    private static WebDriver driver;
//
//    @BeforeClass
//    public static void beforeClass() {
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
//      //  driver.get(petclinicUrl);
//    }
//
//    @AfterClass
//    public static void afterClass() {
//        driver.quit();
//    }
//
//    @DataProvider
//    public Object[][] getData() {
//        Object[][] data = new Object[4][2];
//        data[0][0] = "home page";
//        data[0][1] = "Welcome";
//        data[1][0] = "find owners";
//        data[1][1] = "Find Owners";
//        data[2][0] = "veterinarians";
//        data[2][1] = "Veterinarians";
//        data[3][0] = "trigger a RuntimeException to see how it is handled";
//        data[3][1] = "Something happened...";
//        return data;
//    }
//
//    @Test(dataProvider = "getData")
//    public void checkPageHeaderTestNG(String tabTitle, String expectedHeader) {
//        driver.get(petclinicUrl);
//        driver.findElement(By.xpath("//a[@title='" + tabTitle + "']")).click();
//        String mainPageHeader = driver.findElement(By.xpath("//h2")).getText();
//        sleep(1000);
//        Assert.assertEquals(expectedHeader, mainPageHeader);
//        driver.get(chromeUrl);
//    }
//}
