package cn.dreambreeze.server.interceptor;

import cn.dreambreeze.server.VO.res.UserResVO;
import cn.dreambreeze.server.constant.ResultCode;
import cn.dreambreeze.server.exception.CustomException;
import cn.dreambreeze.server.utils.CommonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpMethod;
import org.springframework.util.ObjectUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author dream breeze
 * @date 2020/9/17 16:59
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {
  private static final Logger log = LoggerFactory.getLogger(LoginInterceptor.class);

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
    if (HttpMethod.GET.equals(request.getMethod())) {
      return true;
    }
    UserResVO user = CommonUtils.getUserByRequest(request);
    if (ObjectUtils.isEmpty(user)) {
      log.warn("***** user not login ******: " + ResultCode.USER_NOT_LOGGED_IN);
      throw new CustomException(ResultCode.USER_NOT_LOGGED_IN);
    }
    return true;
  }
}
