package com.study.service;


import com.study.bean.po.Order;
import com.study.exception.SeckillException;


public interface SeckillService {

    /**
     * 下单商品
     *
     * @param userId  用户ID
     * @param goodsId 商品ID
     * @return
     */
    Order doSeckill(Long userId, Long goodsId) throws SeckillException;
}
