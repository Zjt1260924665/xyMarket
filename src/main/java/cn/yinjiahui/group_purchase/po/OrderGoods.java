package cn.yinjiahui.group_purchase.po;


import lombok.Data;

@Data
public class OrderGoods
{
    private Goods goods;
    private OrderDetailed orderDetailed;
    private OrderTotal orderTotal;



    public OrderGoods()
    {
    }

    public Goods getGoods()
    {
        return goods;
    }

    public void setGoods(Goods goods)
    {
        this.goods = goods;
    }

    public OrderDetailed getOrderDetailed()
    {
        return orderDetailed;
    }

    public void setOrderDetailed(OrderDetailed orderDetailed)
    {
        this.orderDetailed = orderDetailed;
    }

    public OrderTotal getOrderTotal()
    {
        return orderTotal;
    }

    public void setOrderTotal(OrderTotal orderTotal)
    {
        this.orderTotal = orderTotal;
    }
}
