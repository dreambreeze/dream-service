package cn.dreambreeze.server.VO.res;

import lombok.Data;

/**
 * <p>
 * 文章表
 * </p>
 *
 * @author dream breeze
 * @since 2020-09-22
 */
@Data
public class ArticleResVO {

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
  private Long createBy;
  private String createName;
  private Long createAt;
  private Long updateAt;

}
