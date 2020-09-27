package cn.dreambreeze.server.interceptor;

import cn.dreambreeze.server.VO.Audience;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author dream breeze
 * @date 2020/9/17 16:59
 */
public class JwtInterceptor extends HandlerInterceptorAdapter {
  private static final Logger log = LoggerFactory.getLogger(JwtInterceptor.class);

  @Autowired
  private Audience audience;

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
    /*// 忽略带JwtIgnore注解的请求, 不做后续token认证校验
    if (handler instanceof HandlerMethod) {
      HandlerMethod handlerMethod = (HandlerMethod) handler;
      JwtIgnore jwtIgnore = handlerMethod.getMethodAnnotation(JwtIgnore.class);
      if (jwtIgnore != null) {
        return true;
      }
    }

    if (HttpMethod.OPTIONS.equals(request.getMethod())) {
      response.setStatus(HttpStatus.SC_OK);
      return true;
    }

    // 获取cookies token
    String authToken = commonUtils.getAuthTokenByRequest(request);

    log.info("## authHeader= {}", authToken);
    if (StringUtils.isBlank(authToken)) {
      log.info("### 用户未登录，请先登录 ###");
      throw new CustomException(ResultCode.USER_NOT_LOGGED_IN);
    }

    // 获取token
    if (audience == null) {
      BeanFactory factory = WebApplicationContextUtils.getRequiredWebApplicationContext(request.getServletContext());
      audience = (Audience) factory.getBean("audience");
    }

    // 获取token
    final String token = authToken.substring(7);
    // 验证token是否有效--无效已做异常抛出，由全局异常处理后返回对应信息
    JwtTokenUtil.parseJWT(authToken, audience.getBase64Secret());*/
    return true;
  }
}
