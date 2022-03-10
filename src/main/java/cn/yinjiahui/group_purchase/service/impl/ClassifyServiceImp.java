package cn.yinjiahui.group_purchase.service.impl;

import cn.yinjiahui.group_purchase.mapper.ClassifyMapper;
import cn.yinjiahui.group_purchase.po.Classify;
import cn.yinjiahui.group_purchase.po.Goods;
import cn.yinjiahui.group_purchase.service.ClassifyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class ClassifyServiceImp implements ClassifyService
{

    @Autowired
    private ClassifyMapper classifyMapper;

    @Override
    public List<Integer> mGet_GoodsId_inClassify(String classify)
    {
        return classifyMapper.getGoodsIdInOneClassify(classify);
    }

    @Override
    public void insertClassify(String[] classify, Integer[] goodsId)
    {
        try
        {
            if (classify.length != goodsId.length)
            {
                throw new Exception("数据数量不同！");
            }
            for (int i = 0; i < classify.length; i++)
            {
                Classify c=new Classify(classify[i],goodsId[i]);
                classifyMapper.insert(c);
            }
        }
        catch (Exception e)
        {

        }
    }

}
