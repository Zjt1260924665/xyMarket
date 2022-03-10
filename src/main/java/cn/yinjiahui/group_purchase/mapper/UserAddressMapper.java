package cn.yinjiahui.group_purchase.mapper;

import cn.yinjiahui.group_purchase.po.UserAddress;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.catalina.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserAddressMapper extends BaseMapper<UserAddress>
{
    @Select("update user_address set status=1 where id=#{id}")
    void setDefault(Integer id);

    @Select("select * from user_address where phone=#{phone}")
    List<UserAddress> selectByPhone(Integer phone);
}
