package cn.yinjiahui.group_purchase.service;

import cn.yinjiahui.group_purchase.po.OrderDetailed;

import java.util.List;

public interface OrderDetailedService
{
    void insert(Integer[] goodsId,float[] price,Integer[] num,Integer OrderId);

    List<OrderDetailed> selectByGoodsTitle(String goodsTitle);
}
