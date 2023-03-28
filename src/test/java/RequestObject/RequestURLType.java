package RequestObject;


public class RequestURLType {

    //UsersRequestTest
    public static String GET_LIST_USERS = "/api/users?page=2";
    public static String GET_SINGLE_USERS = "/api/users/2";
    public static String GET_SINGLE_USERS_NOTFOUND = "/api/users/23";
    public static String GET_DELAYED_RESPONSE = "/api/users?delay=3";

    //ResourceRequestTest
    public static String GET_RESOURCE_LIST = "/api/unknown";
    public static String GET_RESOURCE_LIST_SINGLE = "/api/unknown/2";
    public static String GET_RESOURCE_NOT_FOUND = "/api/unknown/23";

    //LoginRequest
    public static String POST_LOGIN = "/api/login";

    public static String POST_REGISTER = "/api/register";

    public static String POST_USER = "/api/users";

    public static String PUT_PATCH_DELETE_USER = "/api/users/2";

}
