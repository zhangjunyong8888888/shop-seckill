package com.study.bean.po;


import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class OrderSeckill {

    private Long id;
    private Long orderId;
    private Long userId;
    private Long goodsId;

    public OrderSeckill(Long orderId, Long userId, Long goodsId) {
        this.orderId = orderId;
        this.userId = userId;
        this.goodsId = goodsId;
    }
}
