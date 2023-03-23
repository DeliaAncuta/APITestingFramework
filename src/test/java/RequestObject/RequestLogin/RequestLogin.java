package RequestObject.RequestLogin;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
@Builder
@Getter

public class RequestLogin {

    @JsonProperty("email")
    private String Email;

    @JsonProperty("password")
    private String Password;

    public static class RequestLoginBuilder{
        public RequestLoginBuilder() {
        }
    }

}
