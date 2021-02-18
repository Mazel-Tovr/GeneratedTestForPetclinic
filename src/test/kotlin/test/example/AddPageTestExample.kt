package test.example

import io.restassured.RestAssured.*
import org.junit.jupiter.api.*

class AddPageTestExample {

    private val petclinicUrl = "http://localhost:8080"

    @Test
    fun getAddPetsPage() {
        given().get("$petclinicUrl/owners/1/pets/new").then().statusCode(200)
    }

    @Test
    fun getAddOwnerPage() {
        given().get("$petclinicUrl/owners/new").then().statusCode(200)
    }

}
