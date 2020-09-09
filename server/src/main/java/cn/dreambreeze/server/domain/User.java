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
 * 用户表
 * </p>
 *
 * @author dream breeze
 * @since 2020-09-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("d_user")
@ApiModel(value = "User对象", description = "用户表")
public class User extends Model<User> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "用户id")
    @TableId
    private Long userId;

    @ApiModelProperty(value = "角色ID")
    private Long roleId;

    @ApiModelProperty(value = "用户名")
    private String name;

    @ApiModelProperty(value = "登陆密码")
    private String password;

    @ApiModelProperty(value = "电话号码")
    private String phone;

    @ApiModelProperty(value = "性别: 1:女; 2:男 ; 3:未知")
    private Integer gender;

    @ApiModelProperty(value = "年龄")
    private Integer age;

    @ApiModelProperty(value = "用户头像存储路径")
    private String avatar;

    @ApiModelProperty(value = "毕业学校")
    private String school;

    @ApiModelProperty(value = "公司")
    private String company;

    @ApiModelProperty(value = "职业")
    private String profession;

    @ApiModelProperty(value = "邮箱")
    private String email;

    @ApiModelProperty(value = "用户地址")
    private String address;

    @ApiModelProperty(value = "用户积分")
    private Integer mark;

    @ApiModelProperty(value = "用户生日")
    private Long birthday;

    @ApiModelProperty(value = "用户等级")
    private Long rankId;

    @ApiModelProperty(value = "用户语录")
    private String says;

    @ApiModelProperty(value = "个人简介")
    private String introduction;

    @ApiModelProperty(value = "用户上一次登录IP地址")
    private String lastLoginIp;

    @ApiModelProperty(value = "用户注册时间")
    private Long registerTime;

    @ApiModelProperty(value = "用户注册时IP地址")
    private String registerIp;

    @ApiModelProperty(value = "用户上次更新内容时间")
    private Long lastUpdateTime;

    @ApiModelProperty(value = "是否锁定，0为不锁定，1为锁定")
    private Integer locked;

    @ApiModelProperty(value = "是否冻结，0为不冻结，1为冻结")
    private Integer freeze;

    @ApiModelProperty(value = "拥有权限")
    private String power;

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
        return this.userId;
    }

}
