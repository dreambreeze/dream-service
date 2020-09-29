package cn.dreambreeze.system.controller;

import cn.dreambreeze.server.VO.ResultVO;
import cn.dreambreeze.server.VO.res.UserResVO;
import cn.dreambreeze.server.annotation.JwtIgnore;
import cn.dreambreeze.server.utils.CommonUtils;
import cn.dreambreeze.server.utils.CryptUtil;
import cn.dreambreeze.server.utils.ResultBean;
import cn.dreambreeze.system.handler.UserHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author dream breeze
 * @date 2020/9/17 11:42
 */
@RestController
@RequestMapping("/auth")
public class LoginController {
  private static final Logger LOG = LoggerFactory.getLogger(LoginController.class);

  @Autowired
  private UserHandler userHandler;

  @PostMapping("/login")
  @JwtIgnore
  public ResultVO login(@RequestBody @Validated UserResVO userResVO, HttpServletRequest request, HttpServletResponse response) {
    userResVO.setPassword(CryptUtil.decrypt(userResVO.getPassword()));
    UserResVO resultUser = userHandler.login(userResVO);

    String sessionId = CommonUtils.getUID();
    HttpSession session = request.getSession();
    session.setAttribute(sessionId, resultUser);
    Cookie cookie = new Cookie(CommonUtils.TOKEN, sessionId);
    cookie.setMaxAge(7 * 24 * 60 * 60);
    cookie.setPath("/");
    cookie.setSecure(false);
    cookie.setVersion(0);
    cookie.setHttpOnly(true);
    response.addCookie(cookie);

    resultUser.setPassword(CryptUtil.encrypt(resultUser.getPassword()));
    return ResultBean.success(resultUser);
  }

  @GetMapping("/logout")
  @JwtIgnore
  public ResultVO logout(HttpServletRequest request, HttpServletResponse response) {
    Cookie[] cookies = request.getCookies();
    try {
      for (int i = 0, l = cookies.length; i < l; i++) {
        if (cookies[i].getName().equals(CommonUtils.TOKEN)) {
          HttpSession session = request.getSession();
          session.removeAttribute(cookies[i].getValue());
          Cookie cookie = new Cookie(CommonUtils.TOKEN, null);
          cookie.setMaxAge(0);
          response.addCookie(cookie);
        }
      }
    } catch (Exception ex) {
      LOG.error("清空session cookie异常");
    }
    return ResultBean.success();
  }
}
