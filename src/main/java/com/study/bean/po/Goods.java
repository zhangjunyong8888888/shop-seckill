package com.study.bean.po;


import lombok.Data;

import java.math.BigDecimal;


@Data
public class Goods {

    private Long id;
    private String name;
    private String title;
    private String img;
    private String detail;
    private BigDecimal price;
    private Integer stock;
}
