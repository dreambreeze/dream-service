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
 * 广告表
 * </p>
 *
 * @author dream breeze
 * @since 2020-09-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("d_ad")
@ApiModel(value = "Ad对象", description = "广告表")
public class Ad extends Model<Ad> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "广告自增ID")
    @TableId
    private Long adId;

    @ApiModelProperty(value = "代表的是该广告所处的广告位")
    private Integer position;

    @ApiModelProperty(value = "广告类型,0图片;1flash;2代码;3文字")
    private Long mediaType;

    @ApiModelProperty(value = "该条广告记录的广告名称")
    private String adName;

    @ApiModelProperty(value = "广告链接地址")
    private String adLink;

    @ApiModelProperty(value = "广告链接的表现,文字广告就是文字或图片和flash就是它们的地址")
    private String adCode;

    @ApiModelProperty(value = "广告开始时间")
    private Long startTime;

    @ApiModelProperty(value = "广告结束时间")
    private Long endTime;

    @ApiModelProperty(value = "广告主姓名")
    private String name;

    @ApiModelProperty(value = "广告主邮箱")
    private String email;

    @ApiModelProperty(value = "广告主电话")
    private String phone;

    @ApiModelProperty(value = "点击次数")
    private Long clickCount;

    @ApiModelProperty(value = "该广告是否关闭;1开启; 0关闭")
    private Long enabled;

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
        return this.adId;
    }

}
