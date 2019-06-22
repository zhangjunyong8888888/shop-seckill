package com.study.service.impl;


import com.study.bean.po.Order;
import com.study.bean.po.OrderSeckill;
import com.study.dao.OrderDao;
import com.study.dao.OrderSeckillDao;
import com.study.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderSeckillDao orderSeckillDao;

    @Autowired
    private OrderDao orderDao;


    @Override
    public OrderSeckill getOrderSeckillByUserIdAndGoodsId(Long userId, Long goodsId) {
        return orderSeckillDao.getByUserIdAndGoodsId(userId, goodsId);
    }

    @Override
    public void insertOrder(Order order) {
        Long orderId = orderDao.insert(order);
        order.setId(orderId);
    }

    @Override
    public void insertOrderSeckill(OrderSeckill orderSeckill) {
        Long orderSeckillId = orderSeckillDao.insert(orderSeckill);
        orderSeckill.setId(orderSeckillId);
    }
}
