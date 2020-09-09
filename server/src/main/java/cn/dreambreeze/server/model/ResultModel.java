package cn.dreambreeze.server.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * response modal
 *
 * @author dream breeze
 * @create 2020/9/3 23:00
 */
@Getter
@Setter
@ToString
@Builder
public class ResultModel<T> {
    private int code;
    private String message;
    private T value;
    private String requestId;
}
