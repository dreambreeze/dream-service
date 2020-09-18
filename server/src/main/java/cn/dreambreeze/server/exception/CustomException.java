package cn.dreambreeze.server.exception;

import cn.dreambreeze.server.constant.ResultCode;

/**
 * call rest api exception
 *
 * @author dream breeze
 * @date 2020/9/7 22:01
 */
public class CustomException extends RuntimeException {

  private final int code;

  private final String message;

  public CustomException(ResultCode resultCode) {
    super();
    code = resultCode.getCode();
    message = resultCode.getMessage();
  }

  public int getCode() {
    return code;
  }

  @Override
  public String getMessage() {
    return message;
  }

}
