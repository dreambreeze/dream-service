package cn.dreambreeze.server.VO;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p>
 * 功能权限表
 * </p>
 *
 * @author dream breeze
 * @since 2020-09-12
 */
@Data
public class PowerVO {

    @ApiModelProperty(value = "权限ID")
    private Long powerId;

    @ApiModelProperty(value = "权限码")
    private String powerKey;

    @ApiModelProperty(value = "权限内容")
    private String powerContent;

    @ApiModelProperty(value = "创建用户")
    private Long createBy;

    @ApiModelProperty(value = "创建用户名")
    private String createName;

    @ApiModelProperty(value = "创建日期")
    private Long createAt;

    @ApiModelProperty(value = "删除日期")
    private Long deleteAt;

}
