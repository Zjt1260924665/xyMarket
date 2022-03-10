package cn.yinjiahui.group_purchase.service;


import cn.yinjiahui.group_purchase.po.UserAddress;

import java.util.List;

public interface UserAddressService
{
    void insert(Integer phone,Integer addressId);

    void setDefault(Integer id);

    List<UserAddress> selectByPhone(Integer phone);

    void deleteById(Integer id);
}
