package cn.dreambreeze.server.exception;

import cn.dreambreeze.server.constant.ErrorCodeType;

/**
 * call rest api exception
 *
 * @author dream breeze
 * @date 2020/9/7 22:01
 */
public class CallRestApiException extends RuntimeException {
    private static final long serialVersionUID = -622849971310181415L;
    private final int code;

    private final String message;


    public CallRestApiException(ErrorCodeType errorCodeType, String... args) {
        super();
        code = errorCodeType.getCode();
        message = String.format(errorCodeType.getMessage(), args);
    }

    public CallRestApiException(ErrorCodeType errorCodeType) {
        super();
        code = errorCodeType.getCode();
        message = errorCodeType.getMessage();
    }


    public CallRestApiException(ErrorCodeType errorCodeType, Throwable cause, String... args) {
        super(cause);
        code = errorCodeType.getCode();
        message = String.format(errorCodeType.getMessage(), args);

    }

    public CallRestApiException(ErrorCodeType errorCodeType, Throwable cause) {
        super(cause);
        code = errorCodeType.getCode();
        message = errorCodeType.getMessage();

    }

    public int getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
