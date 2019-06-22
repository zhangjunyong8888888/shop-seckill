package com.study.bean.vo;


import com.study.bean.po.Goods;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;


@Data
public class GoodsDetailVo extends Goods {

    private BigDecimal seckillPrice;
    private Integer seckillStock;
    /**
     * 秒杀活动状态
     */
    private Integer seckillStatus;
    /**
     * 剩余时间
     */
    private Long remainSeconds;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
}
