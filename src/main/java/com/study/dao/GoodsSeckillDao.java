package com.study.dao;


import com.study.bean.po.GoodsSeckill;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;


public interface GoodsSeckillDao {


    @Select("select * from goods_seckill where goods_id = ${goodsId} ")
    GoodsSeckill getById(@Param("goodsId") Long goodsId);

    @Update("update goods_seckill set seckill_stock = seckill_stock - 1 where goods_id = ${goodsId} and seckill_stock > 1 ")
    int inventoryReduction(@Param("goodsId") Long goodsId);
}
