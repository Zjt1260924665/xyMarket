package cn.yinjiahui.group_purchase.mapper;

import cn.yinjiahui.group_purchase.po.Goods;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface GoodsMapper extends BaseMapper<Goods> {

    @Select("select * from goods where title like #{keyWord}")
    List<Goods> selectGoodsByTitleLike(String keyword);
}
