package ResponseObject.ResponseResource;

import ResponseObject.ResponseValidator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.testng.Assert;

import java.util.List;

public class ResponseResourceSuccess implements ResponseValidator {

    @JsonProperty("data")
    private ResourceData data;

    @JsonProperty("support")
    private ResourceSupport support;

    @Override
    public void validateResponse() {

        Assert.assertNotNull(data);
        data.validateResponse();

        Assert.assertNotNull(support);
        support.validateResponse();
    }
}
