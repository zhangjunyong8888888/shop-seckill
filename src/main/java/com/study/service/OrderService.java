package com.study.service;


import com.study.bean.po.Order;
import com.study.bean.po.OrderSeckill;


public interface OrderService {

    /**
     * 获取秒杀订单信息
     *
     * @param userId  用户ID
     * @param goodsId 商品ID
     * @return
     */
    OrderSeckill getOrderSeckillByUserIdAndGoodsId(Long userId, Long goodsId);

    /**
     * 插入订单信息
     *
     * @param order
     */
    void insertOrder(Order order);


    void insertOrderSeckill(OrderSeckill orderSeckill);
}
