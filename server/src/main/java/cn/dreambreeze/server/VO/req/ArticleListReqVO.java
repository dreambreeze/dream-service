package cn.dreambreeze.server.VO.req;

import lombok.Data;

/**
 * @Author dream breeze
 * @Date 2020/9/27 19:50
 */
@Data
public class ArticleListReqVO {

  private Integer pageNum;
  private Integer pageSize;
  private String searchKey;
  private Long sortId;

}
