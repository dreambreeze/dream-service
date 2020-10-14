package cn.dreambreeze.server.VO;

import lombok.Data;

import java.util.List;

/**
 * @author dream breeze
 * @date 2020/9/27 17:31
 */
@Data
public class PageVO<T> {

  protected List<T> items;
  private Integer pageNum;
  private Integer pageSize;
  private Long total;

}
