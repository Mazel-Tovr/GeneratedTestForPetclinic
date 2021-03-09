import com.squareup.kotlinpoet.*
import org.openqa.selenium.chrome.*
import org.testng.annotations.*

private const val fieldName = "petclinicUrl"
private const val driverName = "driver"
private const val url = "http://localhost:8080"
private const val pathToTestPackage = "src/test/kotlin"

fun main() {
    for (i in 1..1000) {
        /*
            Simple petclinic
         */
        /*
         GenerateHomePageTest.getGeneratedTest(clazzName = "HomePageTest$i", id = i).writeTo(File(pathToTestPackage))
         GenerateEditPage.getGeneratedTest(clazzName = "EditPageTest$i", id = i).writeTo(File(pathToTestPackage))
         GenerateAddPageTest.getGeneratedTest(clazzName = "AddPageTest$i", id = i).writeTo(File(pathToTestPackage))
        GenerateSimpleUITests.getGeneratedTest(clazzName = "UiTest$i", id = i).writeTo(File(pathToTestPackage))
        */

        /*
        Fat petclinic
         */
        GenerateRandomTest.getGeneratedTest(clazzName = "CallMethods$i", id = i)
    }
}

object GenerateHomePageTest {

    fun getGeneratedTest(
        packageName: String = "com.epam.home",
        clazzName: String,
        id: Int
    ) = FileSpec.builder(packageName, clazzName)
        .addType(generateTestClass(clazzName, id)).build()

    private fun generateTestClass(
        clazzName: String,
        id: Int
    ): TypeSpec {
        val field = PropertySpec.builder(fieldName, String::class)
            .initializer("\"$url\"")
            .addModifiers(KModifier.PRIVATE)
            .build()
        return TypeSpec.classBuilder(clazzName)
            .addFunction(getHomePageTestFunction(id))
            .addFunction(getVetsPageTestFunction(id))
            .addFunction(getErrorPageTestFunction(id))
            .addProperty(field)
            .build()
    }

    private fun getHomePageTestFunction(id: Int) = FunSpec.builder("getHomePage$id")
        .addAnnotation(Test::class)
        .addStatement("io.restassured.RestAssured.given().get(\"${'$'}petclinicUrl/\").then().statusCode(200)")
        .build()

    private fun getVetsPageTestFunction(id: Int) = FunSpec.builder("getVetsPage$id")
        .addAnnotation(Test::class)
        .addStatement("io.restassured.RestAssured.given().get(\"${'$'}petclinicUrl/vets.html\").then().statusCode(200)")
        .build()

    private fun getErrorPageTestFunction(id: Int) = FunSpec.builder("getErrorPage$id")
        .addAnnotation(Test::class)
        .addStatement("io.restassured.RestAssured.given().get(\"${'$'}petclinicUrl/oups\").then().statusCode(500)")
        .build()

}

object GenerateEditPage {

    fun getGeneratedTest(
        packageName: String = "com.epam.edit",
        clazzName: String,
        id: Int
    ) = FileSpec.builder(packageName, clazzName)
        .addType(generateTestClass(clazzName, id)).build()

    private fun generateTestClass(
        clazzName: String,
        id: Int
    ): TypeSpec {
        val field = PropertySpec.builder(fieldName, String::class)
            .initializer("\"$url\"")
            .addModifiers(KModifier.PRIVATE)
            .build()
        return TypeSpec.classBuilder(clazzName)
            .addFunction(getOwner4InfoPageTestFunction(id))
            .addFunction(getOwner4EditPageTestFunction(id))
            .addProperty(field)
            .build()
    }

    private fun getOwner4InfoPageTestFunction(id: Int) = FunSpec.builder("getHomePage$id")
        .addAnnotation(Test::class)
        .addStatement("io.restassured.RestAssured.given().get(\"${'$'}petclinicUrl/owners/4\").then().statusCode(200)")
        .build()

    private fun getOwner4EditPageTestFunction(id: Int) = FunSpec.builder("getVetsPage$id")
        .addAnnotation(Test::class)
        .addStatement("io.restassured.RestAssured.given().get(\"${'$'}petclinicUrl/owners/4/edit\").then().statusCode(200)")
        .build()

}

object GenerateAddPageTest {

    fun getGeneratedTest(
        packageName: String = "com.epam.add",
        clazzName: String,
        id: Int
    ) = FileSpec.builder(packageName, clazzName)
        .addType(generateTestClass(clazzName, id)).build()

    private fun generateTestClass(
        clazzName: String,
        id: Int
    ): TypeSpec {
        val field = PropertySpec.builder(fieldName, String::class)
            .initializer("\"$url\"")
            .addModifiers(KModifier.PRIVATE)
            .build()
        return TypeSpec.classBuilder(clazzName)
            .addFunction(getAddPetsPageTestFunction(id))
            .addFunction(getAddOwnerPageTestFunction(id))
            .addProperty(field)
            .build()
    }

    private fun getAddPetsPageTestFunction(id: Int) = FunSpec.builder("getHomePage$id")
        .addAnnotation(Test::class)
        .addStatement("io.restassured.RestAssured.given().get(\"${'$'}petclinicUrl/owners/1/pets/new\").then().statusCode(200)")
        .build()

    private fun getAddOwnerPageTestFunction(id: Int) = FunSpec.builder("getVetsPage$id")
        .addAnnotation(Test::class)
        .addStatement("io.restassured.RestAssured.given().get(\"${'$'}petclinicUrl/owners/new\").then().statusCode(200)")
        .build()

}

object GenerateRandomTest {

    fun getGeneratedTest(
        packageName: String = "com.epam.rnd",
        clazzName: String,
        id: Int
    ) = FileSpec.builder(packageName, clazzName)
        .addType(generateTestClass(clazzName, id)).build()

    private fun generateTestClass(
        clazzName: String,
        id: Int
    ): TypeSpec {
        val field = PropertySpec.builder(fieldName, String::class)
            .initializer("\"$url\"")
            .addModifiers(KModifier.PRIVATE)
            .build()
        return TypeSpec.classBuilder(clazzName)
            .addFunction(postRandomMethods(id))
            .addProperty(field)
            .build()
    }

    private fun postRandomMethods(testId: Int) = FunSpec.builder("callMethods${testId * 10}")
        .addAnnotation(Test::class)
        .addStatement("io.restassured.RestAssured.given().post(\"${'$'}petclinicUrl/extension/call/method/random/${testId * 10}\").then().statusCode(200)")
        .build()

}

object GenerateSimpleUITests {

    fun getGeneratedTest(
        packageName: String = "com.epam.ui",
        clazzName: String,
        id: Int
    ) = FileSpec.builder(packageName, clazzName)
        .addType(generateTestClass(clazzName, id)).build()

    private fun generateTestClass(
        clazzName: String,
        id: Int
    ): TypeSpec {

        return TypeSpec.classBuilder(clazzName)
            .addType(companionObject())
            .addFunction(findOwnersTestTestNG(id))
            .addFunction(vetListTestTestNG(id))
            .build()
    }

    private fun beforeClass() = FunSpec.builder("beforeClass")
        .addAnnotation(BeforeClass::class)
        .addAnnotation(JvmStatic::class)
        .addStatement("io.github.bonigarcia.wdm.WebDriverManager.chromedriver().setup()\n driver = ChromeDriver()\ndriver[petclinicUrl]")
        .build()

    private fun afterClass() = FunSpec.builder("afterClass")
        .addAnnotation(AfterClass::class)
        .addAnnotation(JvmStatic::class)
        .addStatement("driver.quit()")
        .build()

    private fun companionObject(): TypeSpec {
        val urlField = PropertySpec.builder(fieldName, String::class)
            .initializer("\"$url\"")
            .addModifiers(KModifier.PRIVATE)
            .build()
        val driverField = PropertySpec.builder(driverName, ChromeDriver::class, KModifier.LATEINIT)
            .mutable()
            .addModifiers(KModifier.PRIVATE)
            .build()
        return TypeSpec.companionObjectBuilder()
            .addProperty(urlField)
            .addProperty(driverField)
            .addFunction(beforeClass())
            .addFunction(afterClass())
            .build()
    }

    private fun findOwnersTestTestNG(id: Int) = FunSpec.builder("findOwnersTestTestNG$id")
        .addAnnotation(Test::class)
        .addStatement(
            """
            driver.findElement(org.openqa.selenium.By.xpath("//a[@title='find owners']")).click()
            driver.findElement(org.openqa.selenium.By.id("lastName")).sendKeys("Davis")
            driver.findElement(org.openqa.selenium.By.xpath("//button[@type='submit']")).click()
            driver.findElement(org.openqa.selenium.By.xpath("//a[@href='/owners/2']")).text
        """.trimIndent()
        )
        .build()

    private fun vetListTestTestNG(id: Int) = FunSpec.builder("vetListTestTestNG$id")
        .addAnnotation(Test::class)
        .addStatement(
            """
                driver.findElement(org.openqa.selenium.By.xpath("//a[@title='veterinarians']")).click()
                driver.findElement(org.openqa.selenium.By.xpath("//td")).text
        """.trimIndent()
        )
        .build()

}
