package cn.dreambreeze.system.controller;

import cn.dreambreeze.server.VO.Audience;
import cn.dreambreeze.server.VO.ResultVO;
import cn.dreambreeze.server.VO.UserVO;
import cn.dreambreeze.server.annotation.JwtIgnore;
import cn.dreambreeze.server.utils.CryptUtil;
import cn.dreambreeze.server.utils.JwtTokenUtil;
import cn.dreambreeze.server.utils.ResultBean;
import cn.dreambreeze.system.handler.UserHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

  @Autowired
  private Audience audience;

  @PostMapping("/login")
  @JwtIgnore
  public ResultVO login(@RequestBody @Validated UserVO userVO, HttpServletRequest request, HttpServletResponse response) {
    userVO.setPassword(CryptUtil.decrypt(userVO.getPassword()));
    UserVO resultUser = userHandler.login(userVO);

    if (audience == null) {
      BeanFactory factory = WebApplicationContextUtils.getRequiredWebApplicationContext(request.getServletContext());
      audience = (Audience) factory.getBean("audience");
    }

    String token = JwtTokenUtil.createJWT(String.valueOf(resultUser.getUserId()), resultUser.getName(), audience);
    Cookie cookie = new Cookie(JwtTokenUtil.AUTH_KEY, token);
    cookie.setMaxAge(7 * 24 * 60 * 60);
    response.addCookie(cookie);

    resultUser.setPassword(CryptUtil.encrypt(resultUser.getPassword()));
    return ResultBean.success(resultUser);
  }

  @GetMapping("/logout")
  @JwtIgnore
  public ResultVO logout(HttpServletRequest request, HttpServletResponse response) {
    Cookie[] cookies = request.getCookies();
    try {
      for (int i = 0; i < cookies.length; i++) {
        Cookie cookie = new Cookie(JwtTokenUtil.AUTH_KEY, null);
        cookie.setMaxAge(0);
        response.addCookie(cookie);
      }
    } catch (Exception ex) {
      LOG.error("清空cookie异常");
    }
    return ResultBean.success();
  }
}
