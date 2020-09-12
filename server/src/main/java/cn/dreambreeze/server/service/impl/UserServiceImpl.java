package cn.dreambreeze.server.service.impl;

import cn.dreambreeze.server.domain.User;
import cn.dreambreeze.server.mapper.UserMapper;
import cn.dreambreeze.server.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author dream breeze
 * @since 2020-09-12
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
