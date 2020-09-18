package cn.dreambreeze.system.handler;

import cn.dreambreeze.server.VO.UserVO;
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

  public UserVO addUser(UserVO userVO) {
    User user = selectUserByName(userVO.getName());
    if (null != user) {
      throw new CustomException(ResultCode.USER_HAS_EXISTED);
    }
    user = new User();
    BeanUtils.copyProperties(userVO, user);
    userMapper.insert(user);
    BeanUtils.copyProperties(user, userVO);
    return userVO;
  }

  public UserVO register(HttpServletRequest request, UserVO userVO) {
    User user = selectUserByName(userVO.getName());
    if (null != user) {
      LOG.warn("User has exist, {}", userVO.getName());
      throw new CustomException(ResultCode.USER_HAS_EXISTED);
    } else {
      String remoteIpAddr = CommonUtils.getRemoteIpAddr(request);
      user = new User();
      BeanUtils.copyProperties(userVO, user);
      System.out.println(remoteIpAddr);
      user.setRegisterIp(remoteIpAddr);
      userMapper.insert(user);
    }
    BeanUtils.copyProperties(user, userVO);
    return userVO;
  }

  public UserVO login(UserVO userVO) {
    User user = selectUserByName(userVO.getName());
    if (null == user) {
      LOG.warn("User is not exist, {}", userVO.getName());
      throw new CustomException(ResultCode.USER_NOT_EXIST);
    } else {
      if (userVO.getPassword().equals(user.getPassword())) {
        BeanUtils.copyProperties(user, userVO);
        return userVO;
      } else {
        LOG.warn("password is not error, enter password: {}, database password: {}", userVO.getPassword(), user.getPassword());
        throw new CustomException(ResultCode.USER_LOGIN_ERROR);
      }
    }
  }
}
