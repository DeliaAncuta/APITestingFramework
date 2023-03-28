package ResponseObject;

import ResponseObject.ResponseLogin.ResponseLoginFailed;
import ResponseObject.ResponseLogin.ResponseLoginSuccess;
import ResponseObject.ResponseRegister.ResponseRegisterFailed;
import ResponseObject.ResponseRegister.ResponseRegisterSuccess;
import ResponseObject.ResponseResource.ResponseResourceSuccess;
import ResponseObject.ResponseResources.ResponseResourcesSuccess;
import ResponseObject.ResponseUser.RespinsePutPatchUser;
import ResponseObject.ResponseUser.ResponsePostUser;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.testng.Assert;

import java.util.Optional;

public class ResponseHelper {

    private Response response;

    public ResponseHelper(Response response) {
        this.response = response;
    }

    public void validateResponseCode(Integer expected){
        System.out.println(response.getStatusCode());
        Assert.assertEquals(response.getStatusCode(), (int) expected); //am facut asta ca aternativa la sugestie intelig
    }

    public void validateResponse(String ResponseType, Integer ResponseCode) {
        System.out.println(response.getStatusCode());
        Assert.assertEquals(response.getStatusCode(), (int) ResponseCode);
        //login
        if (ResponseType.equals(ResponseBodyType.RESPONSE_LOGIN)) {
            switch (ResponseCode) {
                case 200:
                    ResponseLoginSuccess ResponseSuccess = response.getBody().as(ResponseLoginSuccess.class);
                    ResponseSuccess.validateResponse();
                    break;
                case 400:
                    ResponseLoginFailed ResponseFailed = response.getBody().as(ResponseLoginFailed.class);
                    ResponseFailed.validateResponse();
                    break;
            }

        }

        //Register
        if (ResponseType.equals(ResponseBodyType.RESPONSE_REGISTER)) {
            switch (ResponseCode) {
                case 200:
                    ResponseRegisterSuccess ResponseRegisterSuccess = response.getBody().as(ResponseRegisterSuccess.class);
                    ResponseRegisterSuccess.validateResponse();
                    break;
                case 400:
                    ResponseRegisterFailed ResponseRegisterFailed = response.getBody().as(ResponseRegisterFailed.class);
                    ResponseRegisterFailed.validateResponse();
                    break;
            }
        }

        //Resources and Resource

        if(ResponseType.equals(ResponseBodyType.RESPONSE_RESOURCES)){
            switch (ResponseCode) {
                case 200:
                    ResponseResourcesSuccess ResponseResourceSuccess = response.getBody().as(ResponseResourcesSuccess.class);
                    ResponseResourceSuccess.validateResponse();
                    break;
            }
        }

        if(ResponseType.equals(ResponseBodyType.RESPONSE_RESOURCE)){
            switch (ResponseCode) {
                case 200:
                    ResponseResourceSuccess ResponseResourcesSuccess = response.getBody().as(ResponseResourceSuccess.class);
                    ResponseResourcesSuccess.validateResponse();
                    break;
                case 400:
                    Assert.assertNotNull(response);
                    break;
            }
        }

        if(ResponseType.equals(ResponseBodyType.RESPONSE_USER)){
            switch (ResponseCode) {
                case 201:
                    ResponsePostUser ResponseUser = response.getBody().as(ResponsePostUser.class);
                    ResponseUser.validateResponse();
                    break;
                case 200:
                    RespinsePutPatchUser ResponsePutPatchUser = response.getBody().as(RespinsePutPatchUser.class);
                    ResponsePutPatchUser.validateResponse();
                    break;
                case 204:
                    Assert.assertNotNull(response.getBody());
                    break;
            }
        }


    }
        public void printResponseBody () {
            ResponseBody body = response.getBody();
            System.out.println(body.asString());
        }
}
