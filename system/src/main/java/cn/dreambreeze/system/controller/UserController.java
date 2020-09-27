package cn.dreambreeze.system.controller;

import cn.dreambreeze.server.VO.ResultVO;
import cn.dreambreeze.server.VO.res.UserResVO;
import cn.dreambreeze.server.annotation.JwtIgnore;
import cn.dreambreeze.server.domain.User;
import cn.dreambreeze.server.service.UserService;
import cn.dreambreeze.server.utils.CryptUtil;
import cn.dreambreeze.server.utils.ResultBean;
import cn.dreambreeze.system.handler.UserHandler;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
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

  @Autowired
  private UserService userService;

  @Autowired
  private UserHandler userHandler;

  @GetMapping("/all")
  public ResultVO getAllUser() {
    return ResultBean.success(userService.list());
  }

  @GetMapping("/list")
  public ResultVO getUserList(@RequestParam("pageSize") Integer pageSize, @RequestParam("pageNum") Integer pageNum, @RequestParam("name") String userName) {
    PageHelper.startPage(pageNum, pageSize);
    QueryWrapper<User> wrapper = new QueryWrapper<>();
    wrapper.like("name", userName);
    List<User> userList = userService.list(wrapper);
    PageInfo<User> pageInfo = new PageInfo<>(userList);
    pageInfo.setList(userList);
    return ResultBean.success(pageInfo);
  }

  @GetMapping("/{userId}")
  public ResultVO getUser(@PathVariable("userId") String userId) {
    User user = userService.getById(userId);
    if (null != user) {
      user.setPassword(CryptUtil.encrypt(user.getPassword()));
    }
    return ResultBean.success(userService.getById(userId));
  }

  @PostMapping
  public ResultVO addUser(@RequestBody @Validated UserResVO user) {
    return ResultBean.success(userHandler.addUser(user));
  }

  @PatchMapping
  public ResultVO updateUser(@RequestBody @Validated UserResVO userResVO) {
    userResVO.setPassword(CryptUtil.decrypt(userResVO.getPassword()));
    User user = new User();
    BeanUtils.copyProperties(userResVO, user);
    return ResultBean.success(userService.updateById(user));
  }

  @DeleteMapping("/{userId}")
  public ResultVO deleteUser(@PathVariable("userId") String userId) {
    return ResultBean.success(userService.removeById(userId));
  }

  @PostMapping("/register")
  @JwtIgnore
  public ResultVO register(HttpServletRequest request, @RequestBody @Validated UserResVO userResVO) {
    userResVO.setPassword(CryptUtil.decrypt(userResVO.getPassword()));
    UserResVO register = userHandler.register(request, userResVO);
    register.setPassword(CryptUtil.encrypt(register.getPassword()));
    return ResultBean.success(register);
  }
}
