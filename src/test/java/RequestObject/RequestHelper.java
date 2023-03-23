package RequestObject;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RequestHelper {

    private Response response;

    private RequestSpecification request;

    public RequestHelper() {
        request = RestAssured.given();
        request.header("Content-Type", "application/json" );
    }

    public Response performRequest(String requestType, String endPoint, Object body){
       switch (requestType){
           case "get" : response = request.get(endPoint);
            break;
           case "post" :
               request.body(body);
               response = request.post(endPoint);
               break;
       }
    return response;
    }


}
