package com.study.dao;


import com.study.bean.vo.GoodsDetailVo;
import com.study.bean.vo.GoodsListVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;


public interface GoodsDao {

    /**
     * 获取所有商品列表
     *
     * @return
     */
    @Select("select g.*,gs.seckill_price,gs.start_time,gs.end_time,gs.seckill_stock " +
            "from goods g LEFT JOIN goods_seckill gs on g.id = gs.goods_id ")
    List<GoodsListVo> getGoodsList();

    @Select("select g.*,gs.seckill_price,gs.start_time,gs.end_time,gs.seckill_stock " +
            "from goods g LEFT JOIN goods_seckill gs on g.id = gs.goods_id where g.id = ${goodsId} ")
    GoodsDetailVo getById(@Param("goodsId") Long goodsId);
}
