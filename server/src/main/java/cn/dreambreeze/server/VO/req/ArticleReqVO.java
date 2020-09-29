package cn.dreambreeze.server.VO.req;

import lombok.Data;

import java.util.List;

/**
 * @Author dream breeze
 * @Date 2020/9/27 19:50
 */
@Data
public class ArticleReqVO {

  private Long articleId;
  private Long viewNum;
  private String title;
  private String summary;
  private String coverImg;
  private String content;
  private String sendIp;
  private Integer status;
  private Integer top;
  private Integer support;
  private Integer security;
  private List<Long> sort;

}
