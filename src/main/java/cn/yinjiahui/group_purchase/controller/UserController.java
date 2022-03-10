package cn.yinjiahui.group_purchase.controller;

import cn.yinjiahui.group_purchase.common.Result;
import cn.yinjiahui.group_purchase.po.UserInfo;
import cn.yinjiahui.group_purchase.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/sso")
@Api(value = "UserController")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "")
    @PostMapping("/login")
    public Result login(@RequestParam String username,
                        @RequestParam String password) {
        String token = userService.login(username, password);
        if (token == null) {
            return Result.validateFailed("用户名或密码错误");
        }
        Map<String, Object> tokenMap = new HashMap<>(3);
        UserInfo user = userService.getUserByPhone(username);
        tokenMap.put("name", user.getUsername());
        tokenMap.put("id", user.getId());
        tokenMap.put("token", token);
        return Result.success(tokenMap);
    }
}
