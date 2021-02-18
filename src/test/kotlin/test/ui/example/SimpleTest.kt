//package test.ui.example
//
//import org.junit.jupiter.api.*
//import org.openqa.selenium.*
//import org.openqa.selenium.chrome.*
//
//class SimpleTest {
//
//    private val petclinicUrl = "http://localhost:8080"
//    private lateinit var driver: WebDriver
//
//    @BeforeAll
//    fun beforeClass() {
//
//        WebDriverManager.chromedriver().setup()
//        driver = ChromeDriver()
//        driver[petclinicUrl]
//    }
//
//    @AfterAll
//    fun afterClass() {
//        driver!!.quit()
//    }
//
//    @Test
//    fun findOwnersTestTestNG() {
//        driver.findElement(By.xpath("//a[@title='find owners']")).click()
//        driver.findElement(By.id("lastName")).sendKeys("Davis")
//        driver.findElement(By.xpath("//button[@type='submit']")).click()
//        val owner = driver.findElement(By.xpath("//a[@href='/owners/2']")).text
//    }
//
//    @Test
//    fun vetListTestTestNG() {
//        driver.findElement(By.xpath("//a[@title='veterinarians']")).click()
//        val vet = driver.findElement(By.xpath("//td")).text
//        // Assert.assertEquals("Betty Davis", vet);
//    }
//}
