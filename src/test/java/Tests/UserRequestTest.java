package Tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserRequestTest {

    @Test(priority = 1)
    public void postUserTest(){
        //Header
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json" );

        //Body
        JSONObject requestBody = new JSONObject();
        requestBody.put("name", "morpheus");
        requestBody.put("job", "leader");
        request.body(requestBody.toString());  //trebuie trimis un string

        //Response
        Response response = request.post("https://reqres.in/api/users");
        ResponseBody body = response.getBody();
        System.out.println(body.asString());
        System.out.println(response.getStatusCode());
        Assert.assertEquals(response.getStatusCode(), 201);
    }

    @Test(priority = 2)
    public void putUserTest(){
        //Header
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json" );

        //Body
        JSONObject requestBody = new JSONObject();
        requestBody.put("name", "morpheus");
        requestBody.put("job", "zion resident");
        request.body(requestBody.toString());  //trebuie trimis un string

        //Response
        Response response = request.put("https://reqres.in/api/users/2");
        ResponseBody body = response.getBody();
        System.out.println(body.asString());
        System.out.println(response.getStatusCode());
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test(priority = 3)
    public void patchUserTest(){
        //Header
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json" );

        //Body
        JSONObject requestBody = new JSONObject();
        requestBody.put("name", "morpheus");
        requestBody.put("job", "zion resident");
        request.body(requestBody.toString());  //trebuie trimis un string

        //Response
        Response response = request.patch("https://reqres.in/api/users/2");
        ResponseBody body = response.getBody();
        System.out.println(body.asString());
        System.out.println(response.getStatusCode());
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test(priority = 4)
    public void deleteUserTest(){
        //Header
        RequestSpecification request = RestAssured.given();

        //Body

        //Response
        Response response = request.delete("https://reqres.in/api/users/2");
        ResponseBody body = response.getBody();
        System.out.println(body.asString());
        System.out.println(response.getStatusCode());
        Assert.assertEquals(response.getStatusCode(), 204);
    }



}
