package test.api.example

import io.restassured.RestAssured.*
import org.junit.jupiter.api.*

class EditPageExample {

    private val petclinicUrl = "http://localhost:8080"

    @Test
    fun getOwner4InfoPage() {
        given().get("$petclinicUrl/owners/4").then().statusCode(200)
    }

    @Test
    fun getOwner4EditPage() {
        given().get("$petclinicUrl/owners/4/edit").then().statusCode(200)
    }
}
