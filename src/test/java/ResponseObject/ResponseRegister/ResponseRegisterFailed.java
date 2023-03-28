package ResponseObject.ResponseRegister;

import ResponseObject.ResponseSpecificValidator;
import ResponseObject.ResponseValidator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.testng.Assert;

public class ResponseRegisterFailed implements ResponseSpecificValidator {

    @JsonProperty("error")
    public String Error;

    @Override
    public void validateResponse(String Expected) {
        Assert.assertNotNull(Error, Expected);
    }
}
