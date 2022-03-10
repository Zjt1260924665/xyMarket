package cn.yinjiahui.group_purchase.po;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import java.text.DateFormat;
import java.util.Date;

import java.text.SimpleDateFormat;
import java.util.List;

@Data
@TableName("order_detailed")
public class OrderTotal
{

    @TableId(type= IdType.AUTO)
    private Integer id;

    private String date;

    private float total_price;

    private float discount;

    private String phone;

    private Integer address;

    /**
     * 0 待支付 1已支付 2已送达
     */
    private Integer status =0;

    /**用来存储详细订单 联合查询用**/
    private List<OrderDetailed> orderDetailed;

    public OrderTotal()
    {
    }

    public OrderTotal(float total_price, float discount, String phone, Integer address)
    {
        this.total_price = total_price;
        this.discount = discount;
        this.status=0;
        this.phone = phone;
        this.address = address;
        Date d=new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd  HH:mm:ss");
        date= formatter.format(d);
    }

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getDate()
    {
        return date;
    }

    public void setDate(String date)
    {
        this.date = date;
    }

    public float getTotal_price()
    {
        return total_price;
    }

    public void setTotal_price(float total_price)
    {
        this.total_price = total_price;
    }

    public float getDiscount()
    {
        return discount;
    }

    public void setDiscount(float discount)
    {
        this.discount = discount;
    }

    public String getPhone()
    {
        return phone;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public Integer getAddress()
    {
        return address;
    }

    public void setAddress(Integer address)
    {
        this.address = address;
    }

    public Integer getStatus()
    {
        return status;
    }

    public void setStatus(Integer status)
    {
        this.status = status;
    }

    public List<OrderDetailed> getOrderDetailed()
    {
        return orderDetailed;
    }

    public void setOrderDetailed(List<OrderDetailed> orderDetailed)
    {
        this.orderDetailed = orderDetailed;
    }
}
