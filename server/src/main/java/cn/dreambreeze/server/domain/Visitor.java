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
 * 访客记录表
 * </p>
 *
 * @author dream breeze
 * @since 2020-09-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("d_visitor")
@ApiModel(value = "Visitor对象", description = "访客记录表")
public class Visitor extends Model<Visitor> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "访客记录ID")
    @TableId
    private Long visitorId;

    @ApiModelProperty(value = "访客IP地址")
    private String visitorIp;

    @ApiModelProperty(value = "被访问用户ID")
    private Long userId;

    @ApiModelProperty(value = "查看ID")
    private Long whereId;

    @ApiModelProperty(value = "查看作品名")
    private String whereName;

    @ApiModelProperty(value = "创建用户")
    @TableField(fill = FieldFill.INSERT)
    private Long createBy;

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
        return this.visitorId;
    }

}
