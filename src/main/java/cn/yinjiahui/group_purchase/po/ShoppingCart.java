package cn.yinjiahui.group_purchase.po;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;


@Data
@TableName("shopping_cart")
public class ShoppingCart
{
    @TableId(type= IdType.AUTO)
    private Integer id;
    @TableField(value = "goodsId")
    private Integer goodsId;

    private Integer num;

    private String phone;

    private Goods goodsEntity;
    public ShoppingCart()
    {
    }

    public ShoppingCart(Integer goodsId, String phone)
    {
        this.goodsId = goodsId;
        this.num = 1;
        this.phone = phone;
    }

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public Integer getGoodsId()
    {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId)
    {
        this.goodsId = goodsId;
    }

    public Integer getNum()
    {
        return num;
    }

    public void setNum(Integer num)
    {
        this.num = num;
    }

    public String getPhone()
    {
        return phone;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }
}
