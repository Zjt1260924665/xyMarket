package cn.yinjiahui.group_purchase;


import cn.yinjiahui.group_purchase.po.UserInfo;
import cn.yinjiahui.group_purchase.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class ApplicationTest {
    @Autowired
    UserService userService;

    @Test
    void test() {
        UserInfo userById = userService.getUserById(1);
        System.out.println(userById);
    }

}
