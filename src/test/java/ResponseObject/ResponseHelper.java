package ResponseObject;

import ResponseObject.ResponseLogin.ResponseLoginFailed;
import ResponseObject.ResponseLogin.ResponseLoginSuccess;
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

    public void validateResponse(String ResponseType, Integer ResponseCode){
        System.out.println(response.getStatusCode());
        Assert.assertEquals(response.getStatusCode(), (int) ResponseCode);
        if(ResponseType.equals(ResponseBodyType.RESPONSE_LOGIN)){
            switch (ResponseCode){
                case 200:
                    ResponseLoginSuccess ResponseSuccess = response.getBody().as(ResponseLoginSuccess.class);
                    ResponseSuccess.validateResponse();
                    break;
                case 400:
                    ResponseLoginFailed ResponseFailed = response.getBody().as(ResponseLoginFailed.class);
                    ResponseFailed.ValidateResponse();
                    break;
            }

        }
    }


    public void printResponseBody(){
        ResponseBody body = response.getBody();
        System.out.println(body.asString());
    }





}
