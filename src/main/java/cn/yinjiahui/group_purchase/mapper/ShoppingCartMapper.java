package cn.yinjiahui.group_purchase.mapper;

import cn.yinjiahui.group_purchase.po.ShoppingCart;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ShoppingCartMapper extends BaseMapper<ShoppingCart>
{
//    @Select("select g.*,c.* from goods g,shopping_cart c where c.phone=#{phone} and g.id=c.goodsId")
//    List<ShoppingCartItems> getMyShoppingCart(String phone);


    @Select("select * from shopping_cart  where phone = #{phone}")
    @Results({
            @Result(column = "goodsId",property = "goodsId"),
            @Result(property="goodsEntity",column="goodsId",one=@One(select="cn.yinjiahui.group_purchase.mapper.GoodsMapper.selectById"))
    })
    List<ShoppingCart> getMyShoppingCart(String phone);

    @Select("update shopping_cart s set s.num=s.num+1 where s.id=#{id} ")
    void addNumShoppingCart(Integer id);

    @Select("update shopping_cart s set s.num=s.num-1 where s.id=#{id} ")
    void subNumShoppingCart(Integer id);

    @Select("set shopping_cart s set s.num=#{num} where s.id=#{id} ")
    void setNumShoppingCart(Integer num,Integer id);
}
