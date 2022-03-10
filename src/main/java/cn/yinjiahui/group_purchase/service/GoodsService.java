package cn.yinjiahui.group_purchase.service;

import cn.yinjiahui.group_purchase.po.Goods;
import org.apache.ibatis.annotations.Select;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


public interface GoodsService {

    List<Goods> mGetGoods(List<Integer> goodsIdList);

    Goods mGetGoodsById(Integer id);

    void mInsertNewGoods(String[] tittle, Integer[] num, float[] price);

    List<Goods> mGetGoodsByTitleLike(String keyWord);
}
