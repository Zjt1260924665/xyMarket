package cn.yinjiahui.group_purchase.controller;


import cn.yinjiahui.group_purchase.common.Result;
import cn.yinjiahui.group_purchase.po.ShoppingCart;
import cn.yinjiahui.group_purchase.service.ShoppingCartService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/shopping_cart")
@Api(value = "ShoppingCartController")
public class ShoppingCartController
{
    @Autowired
    ShoppingCartService shoppingCartService;

    @PostMapping("/mget_my_shopping_cart")
    public Result mGetGoods(@RequestParam String phone) {
        try
        {
            List<ShoppingCart> l = shoppingCartService.getMyShoppingCart(phone);
            return Result.success(l);
        }
        catch (Exception e)
        {
            return  Result.fail(e.toString());
        }
    }

    @PostMapping("/minsert_shopping_cart")
    public Result mGetGoods(@RequestParam String phone,
                            @RequestParam Integer goodsNum) {
        try
        {
            ShoppingCart shoppingCart=new ShoppingCart(goodsNum,phone);
            shoppingCartService.insertShoppingCart(shoppingCart);
            return Result.success("添加成功");
        }
        catch (Exception e)
        {
            return  Result.fail(e.toString());
        }
    }

    @PostMapping("/madd_num")
    public Result addNum(@RequestParam Integer id) {
        try
        {
           shoppingCartService.addNum(id);
            return Result.success("添加成功");
        }
        catch (Exception e)
        {
            return  Result.fail(e.toString());
        }
    }

    @PostMapping("/msub_num")
    public Result subNum(@RequestParam Integer id) {
        try
        {
            shoppingCartService.subNum(id);
            return Result.success("添加成功");
        }
        catch (Exception e)
        {
            return  Result.fail(e.toString());
        }
    }

    @PostMapping("/mset_num")
    public Result subNum(@RequestParam Integer id,@RequestParam Integer num) {
        try
        {
            shoppingCartService.setNum(num,id);
            return Result.success("修改成功");
        }
        catch (Exception e)
        {
            return  Result.fail(e.toString());
        }
    }
}
