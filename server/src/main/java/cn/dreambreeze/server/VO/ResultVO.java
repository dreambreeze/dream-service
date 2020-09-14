package cn.dreambreeze.server.VO;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * response VO
 *
 * @author dream breeze
 * @date 2020/9/3 23:00
 */
@Getter
@Setter
@ToString
@Builder
public class ResultVO<T> {
  private Integer code;
  private String message;
  private T value;
  private String requestId;
}
