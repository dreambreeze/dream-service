package cn.dreambreeze.server.exception;

import cn.dreambreeze.server.model.ResultModel;
import cn.dreambreeze.server.utils.ResultBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * call rest api exception handler
 *
 * @author dream breeze
 * @date 2020/9/7 22:04
 */
@ControllerAdvice
@Slf4j
public class CallRestApiExceptionHandler {
    public static final String LOG_MESSAGE_TEMPLATE = "Request url: {}, code:{}, message:{}";

    @ResponseBody
    @ExceptionHandler(value = CallRestApiException.class)
    public ResultModel<String> callRestApiExceptionHandler(HttpServletRequest req, CallRestApiException e) {
        log.warn(LOG_MESSAGE_TEMPLATE, req.getRequestURL(), e.getCode(), e.getMessage(), e);
        return ResultBean.fail(e.getCode(), e.getMessage());
    }
}
