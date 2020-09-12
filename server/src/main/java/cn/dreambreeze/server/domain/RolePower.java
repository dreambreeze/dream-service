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
 * 角色权限关系表
 * </p>
 *
 * @author dream breeze
 * @since 2020-09-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("d_role_power")
@ApiModel(value = "RolePower对象", description = "角色权限关系表")
public class RolePower extends Model<RolePower> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "角色权限ID")
    @TableId
    private Long rolePowerId;

    @ApiModelProperty(value = "角色ID")
    private Long roleId;

    @ApiModelProperty(value = "权限ID")
    private Long powerId;


    @Override
    protected Serializable pkVal() {
        return this.rolePowerId;
    }

}
