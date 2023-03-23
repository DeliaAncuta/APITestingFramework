package Tests;

import RequestObject.RequestMethodType;
import RequestObject.RequestURLType;
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
        responseHelper.validateResponseCode(ResponseCodeType.STATUS_200);
    }

    @Test
    public void getSingleUserTest(){

        Response response = requestHelper.performRequest(RequestMethodType.GET_METHOD, baseURL+ RequestURLType.GET_SINGLE_USERS, null);

        responseHelper = new ResponseHelper(response);
        responseHelper.validateResponseCode(ResponseCodeType.STATUS_200);
    }

    @Test
    public void getUserNotFound(){
        Response response = requestHelper.performRequest(RequestMethodType.GET_METHOD, baseURL+RequestURLType.GET_SINGLE_USERS_NOTFOUND, null);
        responseHelper = new ResponseHelper(response);
        responseHelper.validateResponseCode(ResponseCodeType.STATUS_404);
    }

    @Test
    public void getDelayedRequestTest(){

        Response response = requestHelper.performRequest(RequestMethodType.GET_METHOD, baseURL+RequestURLType.GET_DELAYED_RESPONSE, null);
        responseHelper = new ResponseHelper(response);
        responseHelper.validateResponseCode(ResponseCodeType.STATUS_200);

    }


}
