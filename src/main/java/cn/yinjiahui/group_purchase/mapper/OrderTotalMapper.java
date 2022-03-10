package cn.yinjiahui.group_purchase.mapper;

import cn.yinjiahui.group_purchase.po.OrderGoods;
import cn.yinjiahui.group_purchase.po.OrderTotal;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
@Mapper
public interface OrderTotalMapper extends BaseMapper<OrderTotal>
{
    @Select("select * from order_total  where phone = #{phone}")
    @Results({
            @Result(column = "id",property = "id",id = true),
            @Result(column = "total_price",property = "total_price"),
            @Result(property="orderDetailed",column="id",many=@Many(select="cn.yinjiahui.group_purchase." +
                    "mapper.OrderDetailedMapper.getOrderDetailedByOrderId"))
    })
    List<OrderTotal> selectOrderByTitle(String title, String phone);
}
