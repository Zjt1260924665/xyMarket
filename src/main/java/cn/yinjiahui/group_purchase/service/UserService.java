package cn.yinjiahui.group_purchase.service;


import cn.yinjiahui.group_purchase.po.UserInfo;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface UserService {


    String login(String phone, String password);

    Integer getCurrentUserId();

    UserInfo getUserByPhone(String phone);

    UserInfo getUserById(Integer id);

    void updateAvatar(MultipartFile file) throws IOException;

}
