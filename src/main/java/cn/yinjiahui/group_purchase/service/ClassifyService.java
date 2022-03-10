package cn.yinjiahui.group_purchase.service;

import cn.yinjiahui.group_purchase.po.Classify;

import java.util.List;

public interface ClassifyService
{
    List<Integer> mGet_GoodsId_inClassify(String classify);

    void insertClassify(String[] classify,Integer[] goodsId);
}
