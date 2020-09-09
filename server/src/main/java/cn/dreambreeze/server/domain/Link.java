package cn.dreambreeze.server.domain;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>
 * 链接表
 * </p>
 *
 * @author dream breeze
 * @since 2020-09-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("d_link")
@ApiModel(value = "Link对象", description = "链接表")
public class Link extends Model<Link> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "链接ID")
    @TableId
    private Integer linkId;

    @ApiModelProperty(value = "链接名称")
    private String linkName;

    @ApiModelProperty(value = "链接地址")
    private String linkUrl;

    @ApiModelProperty(value = "LOGO图片")
    private String coverImg;

    @ApiModelProperty(value = "所属分类")
    private Long sortId;

    @ApiModelProperty(value = "链接作者")
    private String authorName;

    @ApiModelProperty(value = "在页面显示的顺序")
    private Long showOrder;

    @ApiModelProperty(value = "创建用户")
    @TableField(fill = FieldFill.INSERT)
    private Long createBy;

    @ApiModelProperty(value = "创建用户名")
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
        return this.linkId;
    }

}
