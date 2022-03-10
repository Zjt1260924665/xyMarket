package cn.yinjiahui.group_purchase.po;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/***
 * 商品和分类的对照实体类
 */

@Data
@TableName("goods_classify")
public class Classify
{
    @TableId(type= IdType.AUTO)
    private Integer id;

    private String classify;

    private Integer goodsId;

    public Classify()
    {
    }

    public Classify(String classify, Integer goodsId)
    {
        this.classify = classify;
        this.goodsId = goodsId;
    }

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getClassify()
    {
        return classify;
    }

    public void setClassify(String classify)
    {
        this.classify = classify;
    }

    public Integer getGoodsId()
    {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId)
    {
        this.goodsId = goodsId;
    }
}
