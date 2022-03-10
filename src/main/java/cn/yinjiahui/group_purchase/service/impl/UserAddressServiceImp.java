package cn.yinjiahui.group_purchase.service.impl;

import cn.yinjiahui.group_purchase.mapper.UserAddressMapper;
import cn.yinjiahui.group_purchase.po.UserAddress;
import cn.yinjiahui.group_purchase.service.UserAddressService;
import lombok.extern.slf4j.Slf4j;
import lombok.extern.slf4j.XSlf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class UserAddressServiceImp implements UserAddressService
{

    @Autowired
UserAddressMapper userAddressMapper;
    @Override
    public void insert(Integer phone, Integer addressId)
    {
        UserAddress userAddress=new UserAddress(phone,addressId);
        userAddressMapper.insert(userAddress);
    }

    @Override
    public void setDefault(Integer id)
    {
        userAddressMapper.setDefault(id);
    }

    @Override
    public List<UserAddress> selectByPhone(Integer phone)
    {
        return userAddressMapper.selectByPhone(phone);
    }

    @Override
    public void deleteById(Integer id)
    {
        userAddressMapper.deleteById(id);
    }
}
