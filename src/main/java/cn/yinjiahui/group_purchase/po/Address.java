package cn.yinjiahui.group_purchase.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("address")
public class Address
{
    @TableId(type= IdType.AUTO)
    private Integer id;

    private String name;

    private float x;

    private float y;

    private String address_detailed;
    public Address(String name, float x, float y,String address_detailed)
    {
        this.name = name;
        this.x = x;
        this.y = y;
        this.address_detailed=address_detailed;
    }

    public Address()
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

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public float getX()
    {
        return x;
    }

    public void setX(float x)
    {
        this.x = x;
    }

    public float getY()
    {
        return y;
    }

    public void setY(float y)
    {
        this.y = y;
    }

    public String getAddress_detailed()
    {
        return address_detailed;
    }

    public void setAddress_detailed(String address_detailed)
    {
        this.address_detailed = address_detailed;
    }
}
