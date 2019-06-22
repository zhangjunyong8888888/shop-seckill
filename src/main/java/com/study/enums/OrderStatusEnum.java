package com.study.enums;


import lombok.Getter;


@Getter
public enum OrderStatusEnum {

    //0-新建未支付，1-已支付，2-已发货，3-已收货，4-已退款，5-已完成

    NEW(0),
    PREPAID(1),
    SHIPPED(2),
    RECEIVED(3),
    REFUNDED(4),
    COMPLETED(5),
    ;

    private Integer code;

    OrderStatusEnum(Integer code) {
        this.code = code;
    }
}
