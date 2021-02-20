//package test.ui.example
//
//import io.github.bonigarcia.wdm.*
//import org.openqa.selenium.*
//import org.openqa.selenium.chrome.*
//import org.testng.annotations.*
//
//class SimpleTest {
//
//    companion object {
//        private val driver: ChromeDriver = ChromeDriver()
//        private val petclinicUrl = "http://localhost:8080"
//
//        @BeforeClass
//        @JvmStatic
//        fun beforeClass() {
//            WebDriverManager.chromedriver().setup()
//            driver[petclinicUrl]
//        }
//
//        @AfterClass
//        @JvmStatic
//        fun afterClass() {
//            driver.quit()
//        }
//
//    }
//
//    @Test
//    fun findOwnersTestTestNG() {
//        driver.findElement(By.xpath("//a[@title='find owners']")).click()
//        driver.findElement(By.id("lastName")).sendKeys("Davis")
//        driver.findElement(By.xpath("//button[@type='submit']")).click()
//        driver.findElement(By.xpath("//a[@href='/owners/2']")).text
//    }
//
//    @Test
//    fun vetListTestTestNG() {
//        driver.findElement(By.xpath("//a[@title='veterinarians']")).click()
//        driver.findElement(By.xpath("//td")).text
//    }
//}
