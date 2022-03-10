package cn.yinjiahui.group_purchase.service;

import cn.yinjiahui.group_purchase.po.Address;

import java.util.List;

public interface AddressService
{
    void InsertAddress(float x,float y,String name,String address_d);

    List<Address> getAll();
}
