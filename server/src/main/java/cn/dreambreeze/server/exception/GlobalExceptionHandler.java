package cn.dreambreeze.server.exception;

import cn.dreambreeze.server.constant.ResultCode;
import cn.dreambreeze.server.utils.ResultBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * call rest api exception handler
 *
 * @author dream breeze
 * @date 2020/9/7 22:04
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
  public static final String LOG_MESSAGE_TEMPLATE = "Request url: {}, code:{}, message:{}";

  @ResponseBody
  @ExceptionHandler(value = CustomException.class)
  public ResponseEntity businessExceptionHandler(HttpServletRequest req, CustomException e) {
    log.warn(LOG_MESSAGE_TEMPLATE, req.getRequestURL(), e.getCode(), e.getMessage(), e);
    return new ResponseEntity(ResultBean.fail(e.getCode(), e.getMessage()), HttpStatus.BAD_REQUEST);
  }

  /**
   * 参数错误异常
   */
  @ExceptionHandler({MethodArgumentNotValidException.class, BindException.class})
  public ResponseEntity handleException(Exception e) {

    if (e instanceof MethodArgumentNotValidException) {
      MethodArgumentNotValidException validException = (MethodArgumentNotValidException) e;
      BindingResult result = validException.getBindingResult();
      StringBuffer errorMsg = new StringBuffer();
      if (result.hasErrors()) {
        List<ObjectError> errors = result.getAllErrors();
        errors.forEach(p -> {
          FieldError fieldError = (FieldError) p;
          errorMsg.append(fieldError.getDefaultMessage()).append(",");
          log.error("### 请求参数错误：{" + fieldError.getObjectName() + "},field{" + fieldError.getField() + "},errorMessage{" + fieldError.getDefaultMessage() + "}");
        });
      }
    } else if (e instanceof BindException) {
      BindException bindException = (BindException) e;
      if (bindException.hasErrors()) {
        log.error("### 请求参数错误: {}", bindException.getAllErrors());
      }
    }

    return new ResponseEntity(ResultCode.PARAM_IS_INVALID, HttpStatus.BAD_REQUEST);
  }

  /**
   * 处理所有不可知的异常
   */
//  @ExceptionHandler(Exception.class)
//  public ResponseEntity handleOtherException(Exception e) {
//    //打印异常堆栈信息
//    e.printStackTrace();
//    // 打印异常信息
//    log.error("### 不可知的异常:{} ###", e.getMessage());
//    return new ResponseEntity(ResultCode.SYSTEM_INNER_ERROR, HttpStatus.INTERNAL_SERVER_ERROR);
//  }
}
