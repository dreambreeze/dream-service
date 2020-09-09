package cn.dreambreeze.system.handler;

import cn.dreambreeze.server.domain.Role;
import cn.dreambreeze.server.mapper.RoleMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * role hanlder
 *
 * @author dream breeze
 * @date 2020/9/7 22:08
 */
@Service
public class RoleHandler {

    @Autowired
    private RoleMapper roleMapper;

    public Integer getCountByRoleName(String roleName) {
        QueryWrapper<Role> roleQueryWrapper = new QueryWrapper<>();
        roleQueryWrapper.eq("role_name", roleName);
        return roleMapper.selectCount(roleQueryWrapper);
    }
}
