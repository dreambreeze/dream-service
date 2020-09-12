package cn.dreambreeze.server.domain;

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
 * 用户角色关系表
 * </p>
 *
 * @author dream breeze
 * @since 2020-09-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("d_user_role")
@ApiModel(value = "UserRole对象", description = "用户角色关系表")
public class UserRole extends Model<UserRole> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "用户角色ID")
    @TableId
    private Long userRoleId;

    @ApiModelProperty(value = "角色ID")
    private Long roleId;

    @ApiModelProperty(value = "权限ID")
    private Long powerId;


    @Override
    protected Serializable pkVal() {
        return this.userRoleId;
    }

}
