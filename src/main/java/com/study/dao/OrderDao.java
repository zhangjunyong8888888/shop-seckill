package com.study.dao;


import com.study.bean.po.Order;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.SelectKey;


public interface OrderDao {

    @Insert("INSERT INTO order_info (user_id,goods_id, delivery_addr_id, goods_name, goods_count, order_channel, order_status, created_time) " +
            "VALUES (${userId}, ${goodsId}, ${deliveryAddrId}, #{goodsName}, ${goodsCount}, ${orderChannel}, ${orderStatus}, #{createdTime}) ")
    @SelectKey(keyColumn = "id", keyProperty = "id", resultType = Long.class, before = false, statement = "select last_insert_id()")
    Long insert(Order order);
}
