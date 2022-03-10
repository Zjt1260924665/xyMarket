package cn.yinjiahui.group_purchase.service.impl;

import cn.yinjiahui.group_purchase.mapper.AddressMapper;
import cn.yinjiahui.group_purchase.po.Address;
import cn.yinjiahui.group_purchase.service.AddressService;
import lombok.extern.slf4j.Slf4j;
import lombok.extern.slf4j.XSlf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class AddressServiceImp implements AddressService
{

    @Autowired
    AddressMapper addressMapper;

    @Override
    public void InsertAddress(float x, float y, String name,String address_d)
    {
        Address address=new Address(name,x,y,address_d);
        addressMapper.insert(address);
    }

    @Override
    public List<Address> getAll()
    {
        return addressMapper.getAll();
    }
}
