package Tests;

import RequestObject.RequestMethodType;
import RequestObject.RequestURLType;
import ResponseObject.ResponseBodyType;
import ResponseObject.ResponseCodeType;
import ResponseObject.ResponseHelper;
import ShareData.BaseTest;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class ResourceRequestsTest extends BaseTest {


    @Test(priority = 1)
    public void getResourceListTest(){

        Response response = requestHelper.performRequest(RequestMethodType.GET_METHOD, baseURL + RequestURLType.GET_RESOURCE_LIST, null);

        responseHelper = new ResponseHelper(response);
        responseHelper.validateResponse(ResponseBodyType.RESPONSE_RESOURCES, ResponseCodeType.STATUS_200);
        responseHelper.printResponseBody();
    }


    @Test(priority = 2)
    public void getResourceSingle(){

        Response response = requestHelper.performRequest(RequestMethodType.GET_METHOD, baseURL + RequestURLType.GET_RESOURCE_LIST_SINGLE, null);

        responseHelper = new ResponseHelper(response);
        responseHelper.validateResponse(ResponseBodyType.RESPONSE_RESOURCE, ResponseCodeType.STATUS_200);
        responseHelper.printResponseBody();
    }

    @Test(priority = 3)
    public void getResourceSingleNotFound(){

        Response response = requestHelper.performRequest(RequestMethodType.GET_METHOD, baseURL + RequestURLType.GET_RESOURCE_NOT_FOUND, null);

        responseHelper = new ResponseHelper(response);
        responseHelper.validateResponse(ResponseBodyType.RESPONSE_RESOURCE, ResponseCodeType.STATUS_404);
        responseHelper.printResponseBody();
    }
}
