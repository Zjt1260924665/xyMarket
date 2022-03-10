package cn.yinjiahui.group_purchase.mapper;

import cn.yinjiahui.group_purchase.po.Classify;
import cn.yinjiahui.group_purchase.po.Goods;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ClassifyMapper extends BaseMapper<Classify>
{
    @Select("select goodsId from  goods_classify where classify=#{classify}")
    List<Integer> getGoodsIdInOneClassify(@Param("classify") String classify);


}
