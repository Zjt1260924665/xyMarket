package cn.yinjiahui.group_purchase.mapper;

import cn.yinjiahui.group_purchase.po.Address;
import cn.yinjiahui.group_purchase.po.Category;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface AddressMapper extends BaseMapper<Address>
{

    @Select("select * from address")
    List<Address> getAll();
}
