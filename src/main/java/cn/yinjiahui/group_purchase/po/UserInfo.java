package cn.yinjiahui.group_purchase.po;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;


@Data
@TableName("user_info")
public class UserInfo {
    @TableId
    private Integer id;

    private String phone;
    @TableField("user_password")
    private String password;

    private String username;

    private String avatar;

}
