package cn.dreambreeze.server.utils;

import cn.dreambreeze.server.model.ResultModel;
import org.springframework.http.HttpStatus;

/**
 * result bean
 *
 * @author dream breeze
 * @create 2020/9/3 23:06
 */
public final class ResultBean {

    private ResultBean() {

    }

    public static <T> ResultModel<T> success(T t) {
        return ResultModel.<T>builder().code(HttpStatus.OK.value())
                .value(t).requestId(DreamUtils.getUID()).build();
    }

    public static ResultModel<String> fail(int code, String message) {
        return ResultModel.<String>builder().code(code).message(message)
                .requestId(DreamUtils.getRequestId("FAIL")).build();
    }
}
