package cn.yinjiahui.group_purchase.service.impl;

import cn.yinjiahui.group_purchase.common.Result;
import cn.yinjiahui.group_purchase.mapper.GoodsMapper;
import cn.yinjiahui.group_purchase.po.Goods;
import cn.yinjiahui.group_purchase.service.GoodsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    GoodsMapper goodsMapper;

    @Override
    public List<Goods> mGetGoods(List<Integer> goodsIdList) {
        return goodsMapper.selectBatchIds(goodsIdList);
    }

    @Override
    public Goods mGetGoodsById(Integer id) {
        return goodsMapper.selectById(id);
    }

    @Override
    public void mInsertNewGoods(String[] tittle, Integer[] num, float[] price)
    {
        try
        {
            List<Goods> goodsList = new ArrayList<>();
            if (tittle.length != price.length || price.length != num.length)
            {
                throw new Exception("数据数量不同！");
            }
            for (int i = 0; i < tittle.length; i++)
            {
                Goods goods = new Goods(tittle[i], price[i], num[i]);
                goodsMapper.insert(goods);
            }
        }
        catch (Exception e)
        {

        }
    }

    @Override
    public List<Goods> mGetGoodsByTitleLike(String keyWord)
    {
        return goodsMapper.selectGoodsByTitleLike(keyWord);
    }
}
