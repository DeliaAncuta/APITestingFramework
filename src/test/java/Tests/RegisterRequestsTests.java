package Tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterRequestsTests {

    @Test(priority = 1)
    public void postRegisterSuccessfulTest(){
        //Header
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json" );

        //Body
        JSONObject requestBody = new JSONObject();
        requestBody.put("email", "eve.holt@reqres.in");
        requestBody.put("password", "pistol");
        request.body(requestBody.toString());  //trebuie trimis un string

        //Response
        Response response = request.post("https://reqres.in/api/register");
        ResponseBody body = response.getBody();
        System.out.println(body.asString());
        System.out.println(response.getStatusCode());
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test(priority = 2)
    public void postRegisterUnSuccesfulTest(){
        //Header
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json" );

        //Body
        JSONObject requestBody = new JSONObject();
        requestBody.put("email", "sydney@fife");
        request.body(requestBody.toString());  //trebuie trimis un string

        //Response
        Response response = request.post("https://reqres.in/api/register");
        ResponseBody body = response.getBody();
        System.out.println(body.asString());
        System.out.println(response.getStatusCode());
        Assert.assertEquals(response.getStatusCode(), 400);
    }
}
