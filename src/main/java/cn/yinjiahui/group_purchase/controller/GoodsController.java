package cn.yinjiahui.group_purchase.controller;

import cn.yinjiahui.group_purchase.common.Result;
import cn.yinjiahui.group_purchase.po.Classify;
import cn.yinjiahui.group_purchase.po.Goods;
import cn.yinjiahui.group_purchase.service.ClassifyService;
import cn.yinjiahui.group_purchase.service.GoodsService;
import io.swagger.annotations.Api;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/goods")
@Api(value = "GoodsController")
public class GoodsController {
    @Autowired
    GoodsService goodsService;

    @Autowired
    ClassifyService classifyService;

    /**
     * 通过商品id list得到系列商品
     * @param goodsIdList
     * @return
     */
    @PostMapping("/mget_goods")
    public Result mGetGoods(@RequestParam List<Integer> goodsIdList) {

        List<Goods> goods = goodsService.mGetGoods(goodsIdList);
        return Result.success(goods);
    }

    /***
     * 通过ID得到某个商品
     * @param goodsId 商品id
     * @return 商品信息 以及 图片
     */
    @PostMapping("/mget_goods_by_id")
    public Result mGetOneGoods(@RequestParam Integer goodsId) {
        Goods g= goodsService.mGetGoodsById(goodsId);
        return Result.success(g);
    }

    /**
     * 通过分类得到商品
     * @param classify 分类
     * @return 商品列表
     */
    @PostMapping("/mget_goods_by_classify")
    public Result mGetGoodsByClassify(@RequestParam String classify) {
        List<Integer> l=classifyService.mGet_GoodsId_inClassify(classify);
        List<Goods> goods = goodsService.mGetGoods(l);
        return Result.success(goods);
    }

    /**
     * 添加商品
     * @param tittle 标题列表
     * @param num 商品数量列表
     * @param price 价格列表
     * @return 结果
     */
    @PostMapping("/minsert_goods")
    public Result mGetGoodsByClassify(@RequestParam String[] tittle,
                                      @RequestParam Integer[] num,
                                      @RequestParam float[] price) {
        try
        {
            goodsService.mInsertNewGoods(tittle,num,price);
            return Result.success("添加成功！");
        }
        catch (Exception e)
        {
            return  Result.fail(e.toString());
        }
    }

    /**
     * 添加商品分类
     * @param classify 分类数组
     * @param goodsId 商品数组
     * @return 结果
     */
    @PostMapping("/minsert_classify")
    public Result mGetGoodsByClassify(@RequestParam String classify[],
                                      @RequestParam Integer goodsId[])
    {
        try
        {
            classifyService.insertClassify(classify,goodsId);
            return Result.success("添加成功！");
        }
        catch (Exception e)
        {
            return  Result.fail(e.toString());
        }
    }

    @PostMapping("/msearch")
    public Result mSearchByKeyWord(@RequestParam String keyWord)
    {
        try
        {
            List<Goods> list=goodsService.mGetGoodsByTitleLike("%"+keyWord+"%");
            return Result.success(list);
        }
        catch (Exception e)
        {
            System.out.println(e.toString());
            return  Result.fail(e.toString());
        }
    }

}
