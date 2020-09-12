package cn.dreambreeze.system.handler;

import cn.dreambreeze.server.VO.UserVO;
import cn.dreambreeze.server.constant.ErrorCodeType;
import cn.dreambreeze.server.domain.User;
import cn.dreambreeze.server.exception.BusinessException;
import cn.dreambreeze.server.mapper.UserMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * user handler
 *
 * @author dream breeze
 * @date 2020/9/12 12:47
 */
@Service
public class UserHandler {

    private static final Logger LOG = LoggerFactory.getLogger(UserHandler.class);

    @Resource
    private UserMapper userMapper;

    public User selectUserByName(String userName) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name", userName);
        return userMapper.selectOne(queryWrapper);
    }

    public UserVO addUser(UserVO userVO) {
        User user = selectUserByName(userVO.getName());
        if (null != user) {
            throw new BusinessException(ErrorCodeType.USER_NAME_EXIST);
        }
        user = new User();
        BeanUtils.copyProperties(userVO, user);
        userMapper.insert(user);
        BeanUtils.copyProperties(user, userVO);
        return userVO;
    }

    public UserVO login(UserVO userVO) {
        User user = selectUserByName(userVO.getName());
        if (null == user) {
            LOG.warn("User is not exist, {}", userVO.getName());
            throw new BusinessException(ErrorCodeType.USER_NOT_EXIST);
        } else {
            if (userVO.getPassword().equals(user.getPassword())) {
                BeanUtils.copyProperties(user, userVO);
                return userVO;
            } else {
                LOG.warn("password is not error, enter password: {}, database password: {}", userVO.getPassword(), user.getPassword());
                throw new BusinessException(ErrorCodeType.USER_LOGIN_ERROR);
            }
        }
    }
}
