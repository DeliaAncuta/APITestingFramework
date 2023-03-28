package Tests;

import RequestObject.RequestLogin.RequestLogin;
import RequestObject.RequestMethodType;
import RequestObject.RequestURLType;
import ResponseObject.ResponseBodyType;
import ResponseObject.ResponseCodeType;
import ResponseObject.ResponseHelper;
import ShareData.BaseTest;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class LoginRequestsTests extends BaseTest {

    @Test(priority = 1)
    public void postLoginSuccessfulTest(){

        RequestLogin loginSuccess = new RequestLogin.RequestLoginBuilder().Email("eve.holt@reqres.in").Password("cityslicka").build();
        Response response = requestHelper.performRequest(RequestMethodType.POST_METHOD, baseURL+ RequestURLType.POST_LOGIN, loginSuccess);

        responseHelper = new ResponseHelper(response);
        responseHelper.validateResponse(ResponseBodyType.RESPONSE_LOGIN, ResponseCodeType.STATUS_200);
        responseHelper.printResponseBody();

        //serializare pe request si deserializare pe response
    }

    @Test(priority = 2)
    public void postLoginUnSuccessfulTest(){
        //Header

        RequestLogin requestLoginUnsuccessful = new RequestLogin.RequestLoginBuilder().Email("eve.holt@reqres.in").build();
        Response response = requestHelper.performRequest(RequestMethodType.POST_METHOD, baseURL+ RequestURLType.POST_LOGIN, requestLoginUnsuccessful);

        String ExpectedError = "Missing password";
        responseHelper = new ResponseHelper(response);
        responseHelper.validateResponse(ResponseBodyType.RESPONSE_LOGIN, ResponseCodeType.STATUS_400, ExpectedError);
        responseHelper.printResponseBody();

    }
}
