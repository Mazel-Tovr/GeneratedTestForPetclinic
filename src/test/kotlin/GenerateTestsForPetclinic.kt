import com.squareup.kotlinpoet.*
import org.junit.jupiter.api.*
import java.io.*

private const val fieldName = "petclinicUrl"
private const val url = "http://localhost:8080"
private const val pathToTestPackage = "src/test/kotlin"

fun main() {
    for (i in 1..1000){
        GenerateHomePageTestExample.getGeneratedTest(clazzName = "HomePageTest$i").writeTo(File(pathToTestPackage))
        GenerateEditPageExample.getGeneratedTest(clazzName = "EditPageTest$i").writeTo(File(pathToTestPackage))
        GenerateAddPageTestExample.getGeneratedTest(clazzName = "AddPageTest$i").writeTo(File(pathToTestPackage))
    }
}

object GenerateHomePageTestExample {

    fun getGeneratedTest(
        packageName: String = "com.epam.home",
        clazzName: String
    ) = FileSpec.builder(packageName, clazzName)
        .addType(generateTestClass(clazzName)).build()

    private fun generateTestClass(
        clazzName: String
    ): TypeSpec {
        val field = PropertySpec.builder(fieldName, String::class)
            .initializer("\"$url\"")
            .addModifiers(KModifier.PRIVATE)
            .build()
        return TypeSpec.classBuilder(clazzName)
            .addFunction(getHomePageTestFunction())
            .addFunction(getVetsPageTestFunction())
            .addFunction(getErrorPageTestFunction())
            .addProperty(field)
            .build()
    }

    private fun getHomePageTestFunction() = FunSpec.builder("getHomePage")
        .addAnnotation(Test::class)
        .addStatement("io.restassured.RestAssured.given().get(\"${'$'}petclinicUrl/\").then().statusCode(200)")
        .build()

    private fun getVetsPageTestFunction() = FunSpec.builder("getVetsPage")
        .addAnnotation(Test::class)
        .addStatement("io.restassured.RestAssured.given().get(\"${'$'}petclinicUrl/vets.html\").then().statusCode(200)")
        .build()

    private fun getErrorPageTestFunction() = FunSpec.builder("getErrorPage")
        .addAnnotation(Test::class)
        .addStatement("io.restassured.RestAssured.given().get(\"${'$'}petclinicUrl/oups\").then().statusCode(200)")
        .build()

}

object GenerateEditPageExample {

    fun getGeneratedTest(
        packageName: String = "com.epam.edit",
        clazzName: String
    ) = FileSpec.builder(packageName, clazzName)
        .addType(generateTestClass(clazzName)).build()

    private fun generateTestClass(
        clazzName: String
    ): TypeSpec {
        val field = PropertySpec.builder(fieldName, String::class)
            .initializer("\"$url\"")
            .addModifiers(KModifier.PRIVATE)
            .build()
        return TypeSpec.classBuilder(clazzName)
            .addFunction(getOwner4InfoPageTestFunction())
            .addFunction(getOwner4EditPageTestFunction())
            .addProperty(field)
            .build()
    }

    private fun getOwner4InfoPageTestFunction() = FunSpec.builder("getHomePage")
        .addAnnotation(Test::class)
        .addStatement("io.restassured.RestAssured.given().get(\"${'$'}petclinicUrl/owners/4\").then().statusCode(200)")
        .build()

    private fun getOwner4EditPageTestFunction() = FunSpec.builder("getVetsPage")
        .addAnnotation(Test::class)
        .addStatement("io.restassured.RestAssured.given().get(\"${'$'}petclinicUrl/owners/4/edit\").then().statusCode(200)")
        .build()

}

object GenerateAddPageTestExample {

    fun getGeneratedTest(
        packageName: String = "com.epam.add",
        clazzName: String
    ) = FileSpec.builder(packageName, clazzName)
        .addType(generateTestClass(clazzName)).build()

    private fun generateTestClass(
        clazzName: String
    ): TypeSpec {
        val field = PropertySpec.builder(fieldName, String::class)
            .initializer("\"$url\"")
            .addModifiers(KModifier.PRIVATE)
            .build()
        return TypeSpec.classBuilder(clazzName)
            .addFunction(getAddPetsPageTestFunction())
            .addFunction(getAddOwnerPageTestFunction())
            .addProperty(field)
            .build()
    }

    private fun getAddPetsPageTestFunction() = FunSpec.builder("getHomePage")
        .addAnnotation(Test::class)
        .addStatement("io.restassured.RestAssured.given().get(\"${'$'}petclinicUrl/owners/1/pets/new\").then().statusCode(200)")
        .build()

    private fun getAddOwnerPageTestFunction() = FunSpec.builder("getVetsPage")
        .addAnnotation(Test::class)
        .addStatement("io.restassured.RestAssured.given().get(\"${'$'}petclinicUrl/owners/new\").then().statusCode(200)")
        .build()

}

