package ResponseObject.ResponseResources;

import ResponseObject.ResponseValidator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.testng.Assert;


public class ResourceSupport implements ResponseValidator {

    @JsonProperty("url")
    private String url;
    @JsonProperty("text")
    private String text;


    @Override
    public void validateResponse() {
        Assert.assertNotNull(url);
        Assert.assertNotNull(text);
    }
}
