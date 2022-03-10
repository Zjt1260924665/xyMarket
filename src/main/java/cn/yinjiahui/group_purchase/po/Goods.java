package cn.yinjiahui.group_purchase.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("goods")
public class Goods {

    @TableId(type= IdType.AUTO)
    private Integer id;

    private String title;

    private float price;

    private Integer num;

    private Integer sales;

    private String image;

    public Goods(String title, float price, Integer num)
    {
        this.title = title;
        this.price = price;
        this.num = num;
    }

    public Goods()
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

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public float getPrice()
    {
        return price;
    }

    public void setPrice(float price)
    {
        this.price = price;
    }

    public Integer getNum()
    {
        return num;
    }

    public void setNum(Integer num)
    {
        this.num = num;
    }

    public Integer getSales()
    {
        return sales;
    }

    public void setSales(Integer sales)
    {
        this.sales = sales;
    }

    public String getImage()
    {
        return image;
    }

    public void setImage(String image)
    {
        this.image = image;
    }

//    @TableField("category_id")
//    private Integer categoryId;
//
//    @TableField("account_id")
//    private Integer accountId;
//
//    private Integer status;
//
//    private String images;
//
//    @TableField("desc_images")
//    private String descImages;
//
//    @TableField("sold_start_time")
//    private Date soldStartTime;
//
//    @TableField("sold_end_time")
//    private Date soldEndTime;
//    @TableField("origin_amount")
//    private Integer originAmount;
//
//    @TableField("actual_amount")
//    private Integer actualAmount;
//
//    @TableField("stock_qty")
//    private Integer stockQty;
//
//    @TableField("frozen_qty")
//    private String frozenQty;
//
//    @TableField("sold_qty")
//
//    private String soldQty;
//    @TableField("create_time")
//    private Date createTime;
//
//    @TableField("update_time")
//    private Date updateTime;
}