package cn.dreambreeze.system.controller;

import cn.dreambreeze.server.VO.ResultVO;
import cn.dreambreeze.server.constant.ErrorCodeType;
import cn.dreambreeze.server.domain.Role;
import cn.dreambreeze.server.exception.BusinessException;
import cn.dreambreeze.server.service.RoleService;
import cn.dreambreeze.server.utils.ResultBean;
import cn.dreambreeze.system.handler.RoleHandler;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * role controller
 *
 * @author dream breeze
 * @create 2020/9/2 22:53
 */

@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @Autowired
    private RoleHandler roleHandler;

    @GetMapping("/all")
    public ResultVO<List<Role>> getAllRole() {
        return ResultBean.success(roleService.list());
    }

    @GetMapping("/list")
    public ResultVO<PageInfo> getRoleList(@RequestParam("pageSize") Integer pageSize, @RequestParam("pageNum") Integer pageNum, @RequestParam("roleName") String roleName) {
        PageHelper.startPage(pageNum, pageSize);
        QueryWrapper<Role> wrapper = new QueryWrapper();
        wrapper.like("role_name", roleName);
        List<Role> roleList = roleService.list(wrapper);
        PageInfo pageInfo = new PageInfo<>(roleList);
        pageInfo.setList(roleList);
        return ResultBean.success(pageInfo);
    }

    @GetMapping("/{roleId}")
    public ResultVO<Role> getRole(@PathVariable("roleId") String roleId) {
        return ResultBean.success(roleService.getById(roleId));
    }

    @PostMapping
    public ResultVO<Object> addRole(@RequestBody Role role) {
        if (roleHandler.getCountByRoleName(role.getRoleName()) > 0) {
            throw new BusinessException(ErrorCodeType.ROLE_NAME_EXIST);
        }
        return ResultBean.success(roleService.save(role));
    }

    @PatchMapping
    public ResultVO<Boolean> updateRole(@RequestBody Role role) {
        return ResultBean.success(roleService.updateById(role));
    }

    @DeleteMapping("/{roleId}")
    public ResultVO<Boolean> deleteRole(@PathVariable("roleId") String roleId) {
        return ResultBean.success(roleService.removeById(roleId));
    }
}
