package cn.yinjiahui.group_purchase.controller;


import cn.yinjiahui.group_purchase.common.Result;
import cn.yinjiahui.group_purchase.mapper.OrderTotalMapper;
import cn.yinjiahui.group_purchase.po.OrderTotal;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/test")
@Api(value = "testController")
public class testController
{
    @Autowired
    OrderTotalMapper orderTotalMapper;

    @PostMapping("/test")
    public Result mGetGoods(@RequestParam String phone,@RequestParam String title) {
        try
        {
            List<OrderTotal> l = orderTotalMapper.selectOrderByTitle(title,phone);
            return Result.success(l);
        }
        catch (Exception e)
        {
            return  Result.fail(e.toString());
        }
    }
}
