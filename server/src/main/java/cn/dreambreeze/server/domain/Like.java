package cn.dreambreeze.server.domain;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>
 * 点赞收藏表
 * </p>
 *
 * @author dream breeze
 * @since 2020-09-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("d_like")
@ApiModel(value = "Like对象", description = "点赞收藏表")
public class Like extends Model<Like> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "点赞收藏记录ID")
    @TableId
    private Long likeId;

    @ApiModelProperty(value = "article_id or code_id  or photo_id")
    private Long entityId;

    @ApiModelProperty(value = "1点赞, 2收藏")
    private Integer type;

    @ApiModelProperty(value = "创建用户")
    @TableField(fill = FieldFill.INSERT)
    private Long createBy;

    @ApiModelProperty(value = "创建日期")
    @TableField(fill = FieldFill.INSERT)
    private Long createAt;


    @Override
    protected Serializable pkVal() {
        return this.likeId;
    }

}
