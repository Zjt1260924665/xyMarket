package cn.yinjiahui.group_purchase.service.impl;

import cn.yinjiahui.group_purchase.mapper.ShoppingCartMapper;
import cn.yinjiahui.group_purchase.po.ShoppingCart;
import cn.yinjiahui.group_purchase.service.ShoppingCartService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ShoppingCartServiceImp implements ShoppingCartService
{
    @Autowired
    private ShoppingCartMapper  shoppingCartMapper;

    /**
     * 返回此账号所有购物车条目
     * @param phone 手机号
     * @return 购物车类型中包括一个商品 这个会返回商品
     */
    @Override
    public List<ShoppingCart> getMyShoppingCart(String phone)
    {
        return shoppingCartMapper.getMyShoppingCart(phone);
    }

    /**
     * 添加到购物车
     * @param s
     * 先查询是否有 有的话购物车该条目数量+1 没有的话保存到购物车
     */
    @Override
    public void insertShoppingCart(ShoppingCart s)
    {
        ShoppingCart i=shoppingCartMapper.selectById(s.getId());
        if(i==null)
        {
            shoppingCartMapper.insert(s);
        }
        else shoppingCartMapper.addNumShoppingCart(s.getId());
    }


    @Override
    public void addNum(Integer id)
    {
        shoppingCartMapper.addNumShoppingCart(id);
    }

    @Override
    public void subNum(Integer id)
    {
        shoppingCartMapper.subNumShoppingCart(id);
    }

    @Override
    public void setNum(Integer num, Integer id)
    {
        shoppingCartMapper.setNumShoppingCart(num,id);
    }
}
