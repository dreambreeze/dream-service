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
 * 微码表
 * </p>
 *
 * @author dream breeze
 * @since 2020-09-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("d_code")
@ApiModel(value = "Code对象", description = "微码表")
public class Code extends Model<Code> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "微码ID")
    @TableId
    private Integer codeId;

    @ApiModelProperty(value = "微码名称")
    private String codeName;

    @ApiModelProperty(value = "微码地址")
    private String codeUrl;

    @ApiModelProperty(value = "封面图片的路径")
    private String coverImg;

    @ApiModelProperty(value = "查看次数")
    private Long viewNum;

    @ApiModelProperty(value = "私密等级:0为私有，1为公开，2为仅好友查看")
    private Integer security;

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
        return this.codeId;
    }

}
