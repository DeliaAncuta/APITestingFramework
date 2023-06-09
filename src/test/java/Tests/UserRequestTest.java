package Tests;

import RequestObject.RequestMethodType;
import RequestObject.RequestURLType;
import RequestObject.RequestUser.RequestUser;
import ResponseObject.ResponseBodyType;
import ResponseObject.ResponseCodeType;
import ResponseObject.ResponseHelper;
import ShareData.BaseTest;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class UserRequestTest extends BaseTest {

    @Test(priority = 1)
    public void postUserTest(){

        RequestUser requestUser = new RequestUser.RequestUserBuilder().name("morpheus").job("leader").build();
        Response response = requestHelper.performRequest(RequestMethodType.POST_METHOD, baseURL+ RequestURLType.POST_USER, requestUser);

        responseHelper = new ResponseHelper(response);
        responseHelper.validateResponse(ResponseBodyType.RESPONSE_USER, ResponseCodeType.STATUS_201);
        responseHelper.printResponseBody();
    }

    @Test(priority = 2)
    public void putUserTest(){

        RequestUser requestUser = new RequestUser.RequestUserBuilder().name("morpheus").job("leader").build();
        Response response = requestHelper.performRequest(RequestMethodType.PUT_METHOD, baseURL+ RequestURLType.PUT_PATCH_DELETE_USER, requestUser);

        responseHelper = new ResponseHelper(response);
        responseHelper.validateResponse(ResponseBodyType.RESPONSE_USER, ResponseCodeType.STATUS_200);
        responseHelper.printResponseBody();

    }

    @Test(priority = 3)
    public void patchUserTest(){

        RequestUser requestUser = new RequestUser.RequestUserBuilder().name("morpheus").job("zion resident").build();
        Response response = requestHelper.performRequest(RequestMethodType.PATCH_METHOD, baseURL+ RequestURLType.PUT_PATCH_DELETE_USER, requestUser);

        responseHelper = new ResponseHelper(response);
        responseHelper.validateResponse(ResponseBodyType.RESPONSE_USER, ResponseCodeType.STATUS_200);
        responseHelper.printResponseBody();


    }

    @Test(priority = 4)
    public void deleteUserTest(){

        Response response = requestHelper.performRequest(RequestMethodType.DELETE_METHOD, baseURL+ RequestURLType.PUT_PATCH_DELETE_USER, null);

        responseHelper = new ResponseHelper(response);
        responseHelper.validateResponse(ResponseBodyType.RESPONSE_USER, ResponseCodeType.STATUS_204);
        responseHelper.printResponseBody();

    }



}
