package cn.dreambreeze.server.utils;

import cn.dreambreeze.server.VO.ResultVO;
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


    public static <T> ResultVO<T> success() {
        return ResultVO.<T>builder().code(HttpStatus.OK.value()).requestId(CommonUtils.getUID()).build();
    }

    public static <T> ResultVO<T> success(T t) {
        return ResultVO.<T>builder().code(HttpStatus.OK.value())
                .value(t).requestId(CommonUtils.getUID()).build();
    }

    public static ResultVO<String> fail(int code, String message) {
        return ResultVO.<String>builder().code(code).message(message)
                .requestId(CommonUtils.getRequestId("FAIL")).build();
    }
}
