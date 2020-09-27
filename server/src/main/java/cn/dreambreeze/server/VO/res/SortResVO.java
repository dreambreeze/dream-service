package cn.dreambreeze.server.VO.res;

import lombok.Data;

/**
 * @author dream breeze
 * @since 2020-09-12
 */
@Data
public class SortResVO {

  private Long sortId;
  private String sortName;
  private Long parentId;
  private Integer type;
  private String coverImg;
  private Long createBy;
  private String createName;

}
