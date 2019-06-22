package com.study.bean.po;


import com.study.enums.OrderStatusEnum;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@NoArgsConstructor
public class Order {

    private Long id;
    private Long userId;
    private Long goodsId;
    private Long deliveryAddrId;
    private String goodsName;
    private Integer goodsCount;
    private Integer orderChannel;
    private Integer orderStatus;
    private LocalDateTime createdTime;
    private LocalDateTime payTime;




    public Order(Long userId, Long goodsId) {
        this.userId = userId;
        this.goodsId = goodsId;
        this.deliveryAddrId = 1L;
        this.goodsCount = 1;
        this.orderStatus = OrderStatusEnum.NEW.getCode();
        this.createdTime = LocalDateTime.now();
        this.orderChannel = 1;
    }
}
