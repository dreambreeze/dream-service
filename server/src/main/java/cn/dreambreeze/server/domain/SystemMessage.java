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
 * 系统通知表
 * </p>
 *
 * @author dream breeze
 * @since 2020-09-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("d_system_message")
@ApiModel(value = "SystemMessage对象", description = "系统通知表")
public class SystemMessage extends Model<SystemMessage> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "系统通知ID")
    @TableId
    private Long systemId;

    @ApiModelProperty(value = "角色ID")
    private Long roleId;

    @ApiModelProperty(value = "通知标题")
    private String systemTopic;

    @ApiModelProperty(value = "通知内容")
    private String systemContent;

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
        return this.systemId;
    }

}
