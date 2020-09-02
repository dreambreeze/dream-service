package cn.dreambreeze.system.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * role controller
 *
 * @author dream breeze
 * @create 2020/9/2 22:53
 */
@RestController
@RequestMapping("/role")
public class RoleController {

    @RequestMapping("/list")
    public String getRoleList() {
        return "star spring cloud ";
    }
}
