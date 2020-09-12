package cn.dreambreeze.server.constant;

/**
 * @author dream breeze
 * @date 20200907 21:59
 */
public enum ErrorCodeType {

    /**
     * error code and message key
     * This includes generic exception codes, with each layer having its own exception codes
     */
    DEFAULT(142500, "The system is experiencing an issue, please check back later, or report the issue."),

    SERVICE_ERROR(142601, "Service business error"),
    ROLE_NAME_EXIST(142602, "Role name has exist"),
    USER_NAME_EXIST(142603, "User name has exist"),
    USER_NOT_EXIST(142604, "User is not exist"),
    USER_LOGIN_ERROR(142604, "User is not exist or password error"),
    ;

    private final int code;
    private final String message;


    ErrorCodeType(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public static ErrorCodeType getErrorCodeTypeByCode(int code) {

        ErrorCodeType[] errorCodeTypes = ErrorCodeType.values();
        for (ErrorCodeType errorCodeType : errorCodeTypes) {
            if (errorCodeType.code == code) {
                return errorCodeType;
            }
        }
        return null;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

}
