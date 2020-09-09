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

    DB_ERROR(142001, "DB code keep field"),
    DB_INSERT_ERROR(142002, "Insert error count: [%s]"),
    DB_UPDATE_ERROR(142003, "Update error count: [%s]"),
    DB_DEL_ERROR(142004, "Del error count: [%s]"),

    REST_CALL_ERROR(142301, "Error occurred while call rest api"),
    REST_CALL_NO_DATA(142302, "No data found"),
    REST_CALL_FORBIDDEN(142303, "Access forbidden"),
    REST_CALL_INCORRECT_REQ(142304, "Incorrect request"),
    TEXT_NOT_DOCUMENT(142305, "The text not a xml document"),
    GET_RULE_PATH_ERROR(142306, "Get rule path error"),
    GET_KIE_CONTAINER_ERROR(142307, "Get kieContainer error,non-existent key:[%s]"),
    CREATE_FULL_RECORD_DOCUMENT_ERROR(142308, "Create full record document error"),

    SERVICE_ERROR(142601, "Service business error"),
    ROLE_NAME_EXIST(142602, "Role name has exist"),
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
