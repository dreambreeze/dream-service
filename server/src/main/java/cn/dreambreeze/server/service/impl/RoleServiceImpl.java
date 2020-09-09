package cn.dreambreeze.server.service.impl;

import cn.dreambreeze.server.domain.Role;
import cn.dreambreeze.server.mapper.RoleMapper;
import cn.dreambreeze.server.service.RoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色表 服务实现类
 * </p>
 *
 * @author dream breeze
 * @since 2020-09-07
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {

}
