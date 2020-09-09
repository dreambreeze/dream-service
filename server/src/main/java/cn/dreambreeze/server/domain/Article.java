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
 * 文章表
 * </p>
 *
 * @author dream breeze
 * @since 2020-09-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("d_article")
@ApiModel(value = "Article对象", description = "文章表")
public class Article extends Model<Article> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "文章ID")
    @TableId
    private Long articleId;

    @ApiModelProperty(value = "查看次数")
    private Long viewNum;

    @ApiModelProperty(value = "文章标题")
    private String title;

    @ApiModelProperty(value = "文章关键字")
    private String keyword;

    @ApiModelProperty(value = "文章描述")
    private String description;

    @ApiModelProperty(value = "所属分类")
    private String sort;

    @ApiModelProperty(value = "封面图片的路径")
    private String coverImg;

    @ApiModelProperty(value = "文章内容")
    private String content;

    @ApiModelProperty(value = "发布IP")
    private String sendIp;

    @ApiModelProperty(value = "是否置顶:0为否，1为是")
    private Long top;

    @ApiModelProperty(value = "是否博主推荐:0为否，1为是")
    private Long support;

    @ApiModelProperty(value = "私密等级:0为私有，1为公开，2为仅好友查看")
    private Integer security;

    @ApiModelProperty(value = "创建用户")
    @TableField(fill = FieldFill.INSERT)
    private Long createBy;

    @ApiModelProperty(value = "用户名")
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
        return this.articleId;
    }

}
