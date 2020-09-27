package cn.dreambreeze.server.VO.res;

import lombok.Data;

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
public class UserResVO {

  private Long userId;
  private String name;
  private String password;
  private String phone;
  private Integer gender;
  private Integer age;
  private String avatar;
  private String school;
  private String company;
  private String profession;
  private String email;
  private String address;
  private Integer mark;
  private Long birthday;
  private Long rankId;
  private String says;
  private String introduction;
  private String lastLoginIp;
  private Long registerTime;
  private String registerIp;
  private Long activeTime;
  private Integer locked;
  private Integer freeze;
  private Long createBy;
  private Long createAt;
  private String imageCodeToken;
  private String imageCode;
  private String token;
  private String RoleName;
  private List<PowerResVO> powerList;

}
