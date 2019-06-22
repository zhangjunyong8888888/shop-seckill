package com.study.service;


import com.study.bean.po.GoodsSeckill;
import com.study.bean.vo.GoodsDetailVo;
import com.study.bean.vo.GoodsListVo;

import java.util.List;


public interface GoodsService {



    /**
     * 获取所有商品列表
     *
     * @return
     */
    List<GoodsListVo> getGoodsList();

    /**
     * 根据id获取商品详情
     *
     * @param goodsId
     * @return
     */
    GoodsDetailVo getGoodsDetailByGoodsId(Long goodsId);

    /**
     * 根据商品ID获取商品秒杀信息
     *
     * @param goodsId
     * @return
     */
    GoodsSeckill getGoodsSeckillByGoodsId(Long goodsId);

    /**
     * 减少秒杀商品库存
     *
     * @param goodsId 商品ID
     * @return 是否扣除成功
     */
    boolean inventoryReductionOfGoodsSeckill(Long goodsId);
}
