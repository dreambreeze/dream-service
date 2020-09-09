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
 * 点赞表
 * </p>
 *
 * @author dream breeze
 * @since 2020-09-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("d_like")
@ApiModel(value = "Like对象", description = "点赞表")
public class Like extends Model<Like> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "点赞收藏记录ID")
    @TableId
    private Long likeId;

    @ApiModelProperty(value = "文章ID")
    private Long articleId;

    @ApiModelProperty(value = "微码ID")
    private Long codeId;

    @ApiModelProperty(value = "相片ID")
    private Long photoId;

    @ApiModelProperty(value = "作品用户id")
    private Long userId;

    @ApiModelProperty(value = "1点赞, 2收藏")
    private Integer type;

    @ApiModelProperty(value = "创建用户")
    @TableField(fill = FieldFill.INSERT)
    private Long createBy;

    @ApiModelProperty(value = "创建日期")
    @TableField(fill = FieldFill.INSERT)
    private Long createAt;

    @ApiModelProperty(value = "删除日期")
    @TableLogic
    private Long deleteAt;


    @Override
    protected Serializable pkVal() {
        return this.likeId;
    }

}
