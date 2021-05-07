package br.ce.wcarquino.tasks.apitest;

import org.junit.BeforeClass;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class APITest {
	
	@BeforeClass
	public static void setup() {
		RestAssured.baseURI = "http://localhost:8001/tasks-backend";
	}
	
	@Test
	public void deveRetornarTarefas() {
		RestAssured.given()
		.when().get("/todo")
		.then().statusCode(200);
	}
	
	
	@Test
	public void naoDeveAdicionarTarefaComSucesso() {
		RestAssured.given().body("{ \"task\": \"Test via API\", \"duedate\": \"2010-12-30\" }").contentType(ContentType.JSON)
		.when().post("/todo")
		.then().statusCode(400).log().all();
	}

}
