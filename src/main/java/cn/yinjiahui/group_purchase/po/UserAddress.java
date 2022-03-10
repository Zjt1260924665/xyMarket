package cn.yinjiahui.group_purchase.po;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("user_address")
public class UserAddress
{
    @TableId(type= IdType.AUTO)
    private Integer id;

    private Integer addressId;

    private Integer phone;

    /** 0非默认 1默认 */
    private Integer status;


    public UserAddress(Integer phone,Integer addressId)
    {
        this.addressId = addressId;
        this.phone = phone;
        this.status = 0;
    }

    public UserAddress()
    {
    }

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public Integer getAddressId()
    {
        return addressId;
    }

    public void setAddressId(Integer addressId)
    {
        this.addressId = addressId;
    }

    public Integer getPhone()
    {
        return phone;
    }

    public void setPhone(Integer phone)
    {
        this.phone = phone;
    }

    public Integer getStatus()
    {
        return status;
    }

    public void setStatus(Integer status)
    {
        this.status = status;
    }
}
