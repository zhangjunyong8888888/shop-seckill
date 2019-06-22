package com.study.dao;


import com.study.bean.po.OrderSeckill;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;


public interface OrderSeckillDao {

    @Select(" select * from order_seckill where user_id = ${userId} and goods_id = ${goodsId} ")
    OrderSeckill getByUserIdAndGoodsId(@Param("userId") Long userId, @Param("goodsId") Long goodsId);


    @Insert("INSERT INTO order_seckill(order_id,user_id,goods_id) VALUES (${orderId},${userId},${goodsId})")
    @SelectKey(
            keyColumn = "id",
            keyProperty = "id",
            resultType = Long.class,
            before = false,
            statement = "select last_insert_id()")
    Long insert(OrderSeckill orderSeckill);
}
