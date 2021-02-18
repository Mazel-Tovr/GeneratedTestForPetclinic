package test.example

import io.restassured.RestAssured.*
import org.junit.jupiter.api.*

class HomePageTestExample {

    private val petclinicUrl = "http://localhost:8080"

    @Test
    fun getHomePage() {
        given().get("$petclinicUrl/").then().statusCode(200)
    }

    @Test
    fun getVetsPage() {
        given().get("$petclinicUrl/vets.html").then().statusCode(200)
    }

    //ShouldFailed
    @Test
    fun getErrorPage() {
        given().get("$petclinicUrl/oups").then().statusCode(200)
    }
}
