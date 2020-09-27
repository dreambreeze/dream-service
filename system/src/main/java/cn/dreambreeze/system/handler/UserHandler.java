package cn.dreambreeze.system.handler;

import cn.dreambreeze.server.VO.res.UserResVO;
import cn.dreambreeze.server.constant.ResultCode;
import cn.dreambreeze.server.domain.User;
import cn.dreambreeze.server.exception.CustomException;
import cn.dreambreeze.server.mapper.UserMapper;
import cn.dreambreeze.server.utils.CommonUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

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

  public UserResVO addUser(UserResVO userResVO) {
    User user = selectUserByName(userResVO.getName());
    if (null != user) {
      throw new CustomException(ResultCode.USER_HAS_EXISTED);
    }
    user = new User();
    BeanUtils.copyProperties(userResVO, user);
    userMapper.insert(user);
    BeanUtils.copyProperties(user, userResVO);
    return userResVO;
  }

  public UserResVO register(HttpServletRequest request, UserResVO userResVO) {
    User user = selectUserByName(userResVO.getName());
    if (null != user) {
      LOG.warn("User has exist, {}", userResVO.getName());
      throw new CustomException(ResultCode.USER_HAS_EXISTED);
    } else {
      String remoteIpAddr = CommonUtils.getRemoteIpAddr(request);
      user = new User();
      BeanUtils.copyProperties(userResVO, user);
      user.setRegisterIp(remoteIpAddr);
      userMapper.insert(user);
    }
    BeanUtils.copyProperties(user, userResVO);
    return userResVO;
  }

  public UserResVO login(UserResVO userResVO) {
    User user = selectUserByName(userResVO.getName());
    if (null == user) {
      LOG.warn("User is not exist, {}", userResVO.getName());
      throw new CustomException(ResultCode.USER_NOT_EXIST);
    } else {
      if (userResVO.getPassword().equals(user.getPassword())) {
        BeanUtils.copyProperties(user, userResVO);
        return userResVO;
      } else {
        LOG.warn("password is not error, enter password: {}, database password: {}", userResVO.getPassword(), user.getPassword());
        throw new CustomException(ResultCode.USER_LOGIN_ERROR);
      }
    }
  }
}
