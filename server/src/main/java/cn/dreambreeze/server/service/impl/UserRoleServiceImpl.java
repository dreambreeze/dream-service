package cn.dreambreeze.server.service.impl;

import cn.dreambreeze.server.domain.UserRole;
import cn.dreambreeze.server.mapper.UserRoleMapper;
import cn.dreambreeze.server.service.UserRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户角色关系表 服务实现类
 * </p>
 *
 * @author dream breeze
 * @since 2020-09-12
 */
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements UserRoleService {

}
