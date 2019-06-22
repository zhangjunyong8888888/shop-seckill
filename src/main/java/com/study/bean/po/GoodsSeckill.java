package com.study.bean.po;


import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;


@Data
public class GoodsSeckill {

    private Long id;
    private Long goodsId;
    private BigDecimal seckillPrice;
    private Integer seckillStock;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
}
