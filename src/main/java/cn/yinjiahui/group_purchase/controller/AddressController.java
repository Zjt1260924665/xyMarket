package cn.yinjiahui.group_purchase.controller;

import cn.yinjiahui.group_purchase.common.Result;
import cn.yinjiahui.group_purchase.po.Address;
import cn.yinjiahui.group_purchase.po.Goods;
import cn.yinjiahui.group_purchase.po.UserAddress;
import cn.yinjiahui.group_purchase.service.AddressService;
import cn.yinjiahui.group_purchase.service.GoodsService;
import cn.yinjiahui.group_purchase.service.UserAddressService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api/address")
@Api(value = "AddressController")
public class AddressController
{
    @Autowired
    AddressService addressService;

    @Autowired
    UserAddressService userAddressService;

    /***
     * 得到所有的地址
     * @return
     */
    @PostMapping("/mget_all_address")
    public Result mGetAllAddress() {

        try
        {
            List<Address> list=addressService.getAll();
            return Result.success(list);
        }
        catch (Exception e)
        {
            System.out.println(e.toString());
            return Result.fail(e.toString());
        }
    }

    /**
     * 添加地址
     * @param name 地址名
     * @param x 精度
     * @param y 维度
     * @param address_d 地址形容词 如 鲁磨路中航181
     * @return
     */
    @PostMapping("/minsert_address")
    public Result mInsertAddress(@RequestParam String name ,
                                 @RequestParam float x,
                                 @RequestParam float y,
                                 @RequestParam String address_d) {
        try
        {
            addressService.InsertAddress(x,y,name,address_d);
            return Result.success("添加成功");
        }
        catch (Exception e)
        {
            System.out.println(e.toString());
            return Result.fail(e.toString());
        }
    }

    /**
     * 添加个人提货地址
     * @param phone 个人电话号
     * @param addressId 地址id
     * @return
     */
    @PostMapping("/minsert_my_address")
    public Result mInsertMyAddress(@RequestParam Integer phone ,
                                 @RequestParam Integer addressId) {
        try
        {
            userAddressService.insert(phone,addressId);
            return Result.success("添加成功");
        }
        catch (Exception e)
        {
            System.out.println(e.toString());
            return Result.fail(e.toString());
        }
    }

    /**
     * 得到个人的收藏的提货地址
     * @param phone 电话号
     * @return
     */
    @PostMapping("/mget_my_address")
    public Result mGetMyAddress(@RequestParam Integer phone) {
        try
        {
            List<UserAddress> list=userAddressService.selectByPhone(phone);
            return Result.success(list);
        }
        catch (Exception e)
        {
            System.out.println(e.toString());
            return Result.fail(e.toString());
        }
    }

    /**
     * 设置个人默认的提货地址
     * @param id 数据库主键id
     * @return
     */
    @PostMapping("/mset_my_default_address")
    public Result mSetMyAddress(@RequestParam Integer id) {
        try
        {
            userAddressService.setDefault(id);
            return Result.success("修改成功");
        }
        catch (Exception e)
        {
            System.out.println(e.toString());
            return Result.fail(e.toString());
        }
    }

    /**
     * 删除个人某个收藏地址
     * @param id
     * @return
     */
    @PostMapping("/mdelete_my_address")
    public Result mDeleteMyAddress(@RequestParam Integer id) {
        try
        {
            userAddressService.deleteById(id);
            return Result.success("修改成功");
        }
        catch (Exception e)
        {
            System.out.println(e.toString());
            return Result.fail(e.toString());
        }
    }
}
