package com.study.service.impl;


import com.study.bean.po.Order;
import com.study.bean.po.OrderSeckill;
import com.study.exception.SeckillException;
import com.study.result.CodeMsg;
import com.study.service.GoodsService;
import com.study.service.OrderService;
import com.study.service.SeckillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class SeckillServiceImpl implements SeckillService {

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private OrderService orderService;

    @Override
    @Transactional

    public Order doSeckill(Long userId, Long goodsId) throws SeckillException {

        // 扣除库存
        if (!goodsService.inventoryReductionOfGoodsSeckill(goodsId)) {
            throw new SeckillException(CodeMsg.SECKILL_REDUCE_INVENTORY_FILED);
        }
        //创建订单
        Order order = new Order(userId, goodsId);
        orderService.insertOrder(order);
        orderService.insertOrderSeckill(new OrderSeckill(order.getId(), userId, goodsId));
        return order;
    }
}
