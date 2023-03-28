package Tests;

import RequestObject.RequestMethodType;
import RequestObject.RequestURLType;
import ResponseObject.ResponseBodyType;
import ResponseObject.ResponseCodeType;
import ResponseObject.ResponseHelper;
import ShareData.BaseTest;
import io.restassured.response.Response;
import org.testng.annotations.Test;


public class UsersRequestsTests extends BaseTest {

    @Test
    public void getListUsersTest(){

        Response response = requestHelper.performRequest(RequestMethodType.GET_METHOD, baseURL+ RequestURLType.GET_LIST_USERS, null);

        responseHelper = new ResponseHelper(response);
        responseHelper.validateResponse(ResponseBodyType.RESPONSE_USERS, ResponseCodeType.STATUS_200);
        responseHelper.printResponseBody();
    }

    @Test
    public void getSingleUserTest(){ //tema

        Response response = requestHelper.performRequest(RequestMethodType.GET_METHOD, baseURL+ RequestURLType.GET_SINGLE_USERS, null);

        responseHelper = new ResponseHelper(response);
        responseHelper.validateResponse(ResponseBodyType.RESPONSE_USERS, ResponseCodeType.STATUS_200);
        responseHelper.printResponseBody();
    }

    @Test
    public void getUserNotFound(){
        Response response = requestHelper.performRequest(RequestMethodType.GET_METHOD, baseURL+RequestURLType.GET_SINGLE_USERS_NOTFOUND, null);
        responseHelper = new ResponseHelper(response);
        responseHelper.validateResponse(ResponseBodyType.RESPONSE_USERS, ResponseCodeType.STATUS_404);
        responseHelper.printResponseBody();
    }

    @Test
    public void getDelayedRequestTest(){

        Response response = requestHelper.performRequest(RequestMethodType.GET_METHOD, baseURL+RequestURLType.GET_DELAYED_RESPONSE, null);
        responseHelper = new ResponseHelper(response);
        responseHelper.validateResponse(ResponseBodyType.RESPONSE_USERS, ResponseCodeType.STATUS_200);
        responseHelper.printResponseBody();

    }


}
