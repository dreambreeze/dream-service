package cn.dreambreeze.system.controller;

import cn.dreambreeze.server.VO.ResultVO;
import cn.dreambreeze.server.VO.UserVO;
import cn.dreambreeze.server.domain.User;
import cn.dreambreeze.server.service.UserService;
import cn.dreambreeze.server.utils.CommonUtils;
import cn.dreambreeze.server.utils.ResultBean;
import cn.dreambreeze.system.handler.UserHandler;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * user controller
 *
 * @author dream breeze
 * @date 2020/9/12 12:47
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private static final Logger LOG = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private UserHandler userHandler;

    @GetMapping("/all")
    public ResultVO getAllUser() {
        return ResultBean.success(userService.list());
    }

    @GetMapping("/list")
    public ResultVO getUserList(@RequestParam("pageSize") Integer pageSize, @RequestParam("pageNum") Integer pageNum, @RequestParam("userName") String userName) {
        PageHelper.startPage(pageNum, pageSize);
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.like("user_name", userName);
        List<User> userList = userService.list(wrapper);
        PageInfo<User> pageInfo = new PageInfo<>(userList);
        pageInfo.setList(userList);
        return ResultBean.success(pageInfo);
    }

    @GetMapping("/{userId}")
    public ResultVO getUser(@PathVariable("userId") String userId) {
        return ResultBean.success(userService.getById(userId));
    }

    @PostMapping
    public ResultVO addUser(@RequestBody @Validated UserVO user) {
        return ResultBean.success(userHandler.addUser(user));
    }

    @PatchMapping
    public ResultVO updateUser(@RequestBody @Validated UserVO userVO) {
        User user = new User();
        BeanUtils.copyProperties(userVO, user);
        return ResultBean.success(userService.updateById(user));
    }

    @DeleteMapping("/{userId}")
    public ResultVO deleteUser(@PathVariable("userId") String userId) {
        return ResultBean.success(userService.removeById(userId));
    }

    @PostMapping("/login")
    public ResultVO login(@RequestBody @Validated UserVO userVO, HttpServletRequest request, HttpServletResponse response) {
        userVO.setPassword(DigestUtils.md5DigestAsHex(userVO.getPassword().getBytes()));
        UserVO resultUser = userHandler.login(userVO);
        String token = CommonUtils.getLoginToken();

        Cookie cookie = new Cookie("token", token);
        cookie.setMaxAge(7 * 24 * 60 * 60);

        response.addCookie(cookie);
        request.getSession().setAttribute(token, resultUser);
        return ResultBean.success(resultUser);
    }

    @GetMapping("/logout")
    public ResultVO logout(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        String token = "";
        for (Cookie cookie : cookies) {
            if ("token".equals(cookie.getName())) {
                token = cookie.getValue();
            }
        }
        UserVO userVO = (UserVO) request.getSession().getAttribute(token);
        request.getSession().removeAttribute(token);
        LOG.info("***** remove user session by token : {}", userVO.getName());
        return ResultBean.success();
    }
}
