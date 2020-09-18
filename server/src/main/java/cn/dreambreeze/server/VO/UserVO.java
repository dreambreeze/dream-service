package cn.dreambreeze.server.VO;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author dream breeze
 * @since 2020-09-12
 */
@Data
public class UserVO {


  @ApiModelProperty(value = "用户id")
  private Long userId;

  @ApiModelProperty(value = "用户名")
  @NotBlank
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

  @ApiModelProperty(value = "用户最后活跃时间")
  private Long activeTime;

  @ApiModelProperty(value = "是否锁定，0为不锁定，1为锁定")
  private Integer locked;

  @ApiModelProperty(value = "是否冻结，0为不冻结，1为冻结")
  private Integer freeze;

  @ApiModelProperty(value = "创建用户")
  private Long createBy;

  @ApiModelProperty(value = "创建日期")
  private Long createAt;

  @ApiModelProperty(value = "修改日期")
  private Long updateAt;

  @ApiModelProperty(value = "删除日期")
  private Long deleteAt;

  private String imageCodeToken;
  private String imageCode;
  private String token;
  private String RoleId;
  private List<PowerVO> powerList;

}
