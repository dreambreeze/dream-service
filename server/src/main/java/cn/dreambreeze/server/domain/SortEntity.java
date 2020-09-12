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
 * 分类关系表
 * </p>
 *
 * @author dream breeze
 * @since 2020-09-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("d_sort_entity")
@ApiModel(value = "SortEntity对象", description = "分类关系表")
public class SortEntity extends Model<SortEntity> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "分类关系ID")
    @TableId
    private Long sortEntityId;

    @ApiModelProperty(value = "分类名称")
    private String sortId;

    @ApiModelProperty(value = "article_id or code_id  or photo_id or link_id")
    private Long entityId;

    @ApiModelProperty(value = "创建用户")
    @TableField(fill = FieldFill.INSERT)
    private Long createBy;

    @ApiModelProperty(value = "创建用户名")
    private String createName;


    @Override
    protected Serializable pkVal() {
        return this.sortEntityId;
    }

}
