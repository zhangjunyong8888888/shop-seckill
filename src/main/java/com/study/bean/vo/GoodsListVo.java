package com.study.bean.vo;


import com.study.bean.po.Goods;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;


@Data
public class GoodsListVo extends Goods {

    private BigDecimal seckillPrice;
    private Integer seckillStock;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
}
