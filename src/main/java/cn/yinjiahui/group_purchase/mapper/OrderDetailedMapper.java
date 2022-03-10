package cn.yinjiahui.group_purchase.mapper;

import cn.yinjiahui.group_purchase.po.OrderDetailed;
import cn.yinjiahui.group_purchase.po.OrderGoods;
import cn.yinjiahui.group_purchase.po.OrderTotal;
import cn.yinjiahui.group_purchase.po.ShoppingCart;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface OrderDetailedMapper extends BaseMapper<OrderDetailed>
{


    @Select("select * from order_total  where phone = #{phone}")
    @Results({
            @Result(column = "id",property = "id",id = true),
            @Result(column = "total_price",property = "total_price"),
            @Result(property="orderDetailed",column="id",many=@Many(select="cn.yinjiahui.group_purchase." +
                    "mapper.OrderDetailedMapper.getOrderDetailedByOrderId"))
    })
    List<OrderTotal> selectOrderByTitle(String title, String phone);

    @Select("select * from order_detailed where orderId=#{id}")
    @Results({
            @Result(column = "id",property = "id",id = true),
            @Result(column = "goodsId",property = "goods_id"),
            @Result(property="goods",column="id",one=@One(select="cn.yinjiahui.group_purchase." +
                    "mapper.GoodsMapper.selectById"))
    })
    List<OrderDetailed> getOrderDetailedByOrderId(Integer id);

}
