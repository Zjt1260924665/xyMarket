package cn.yinjiahui.group_purchase.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("order_total")
public class OrderDetailed
{
    @TableId(type= IdType.AUTO)
    private Integer id;

    private Integer Goods_id;

    private float price;

    private int num;

    private Integer orderId;

    /**用于联合查询*/
    private Goods goods;

    public Goods getGoods()
    {
        return goods;
    }

    public void setGoods(Goods goods)
    {
        this.goods = goods;
    }
    /***/

    public OrderDetailed()
    {
    }

    public OrderDetailed(Integer goods_id, float price, int num,int orderId)
    {
        Goods_id = goods_id;
        this.price = price;
        this.num = num;
        this.orderId=orderId;
    }

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public Integer getGoods_id()
    {
        return Goods_id;
    }

    public void setGoods_id(Integer goods_id)
    {
        Goods_id = goods_id;
    }

    public float getPrice()
    {
        return price;
    }

    public void setPrice(float price)
    {
        this.price = price;
    }

    public int getNum()
    {
        return num;
    }

    public void setNum(int num)
    {
        this.num = num;
    }

    public Integer getOrderId()
    {
        return orderId;
    }

    public void setOrderId(Integer orderId)
    {
        this.orderId = orderId;
    }
}
