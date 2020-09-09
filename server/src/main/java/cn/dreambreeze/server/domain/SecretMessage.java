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
 * 私信表
 * </p>
 *
 * @author dream breeze
 * @since 2020-09-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("d_secret_message")
@ApiModel(value = "SecretMessage对象", description = "私信表")
public class SecretMessage extends Model<SecretMessage> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "私信ID")
    @TableId
    private Long secretId;

    @ApiModelProperty(value = "收信者ID")
    private Long receiveId;

    @ApiModelProperty(value = "私信标题")
    private String messageTopic;

    @ApiModelProperty(value = "私信内容")
    private String messageContent;

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
        return this.secretId;
    }

}
