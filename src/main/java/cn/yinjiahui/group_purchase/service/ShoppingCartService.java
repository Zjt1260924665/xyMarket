package cn.yinjiahui.group_purchase.service;

import cn.yinjiahui.group_purchase.po.ShoppingCart;

import java.util.List;

public interface ShoppingCartService
{
    List<ShoppingCart> getMyShoppingCart(String phone);

    void insertShoppingCart(ShoppingCart s);

    void addNum(Integer id);

    void subNum(Integer id);

    void setNum(Integer num,Integer id);
}
