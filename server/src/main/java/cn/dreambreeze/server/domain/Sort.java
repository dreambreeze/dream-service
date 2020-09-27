package cn.dreambreeze.server.domain;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>
 * 分类表
 * </p>
 *
 * @author dream breeze
 * @since 2020-09-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("d_sort")
@ApiModel(value = "Sort对象", description = "分类表")
public class Sort extends Model<Sort> {

  private static final long serialVersionUID = 1L;

  @ApiModelProperty(value = "分类ID")
  @TableId
  private Long sortId;

  @ApiModelProperty(value = "分类名称")
  private String sortName;

  @ApiModelProperty(value = "父级分类")
  private Long parentId;

  @ApiModelProperty(value = "分类对象： 1、article ;  2、code;   3、link;   4、photo")
  private Integer type;

  @ApiModelProperty(value = "封面图片的路径")
  private String coverImg;

  @ApiModelProperty(value = "创建用户")
  @TableField(fill = FieldFill.INSERT)
  private Long createBy;

  @ApiModelProperty(value = "创建用户名")
  @TableField(fill = FieldFill.INSERT)
  private String createName;

  @ApiModelProperty(value = "创建日期")
  @TableField(fill = FieldFill.INSERT)
  private Long createAt;

  @ApiModelProperty(value = "修改日期")
  @TableField(fill = FieldFill.INSERT_UPDATE)
  private Long updateAt;

  @ApiModelProperty(value = "删除日期")
  @TableLogic
  private Long deleteAt;


  @Override
  protected Serializable pkVal() {
    return this.sortId;
  }

}
