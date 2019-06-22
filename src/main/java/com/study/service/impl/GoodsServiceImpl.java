package com.study.service.impl;


import com.study.bean.po.GoodsSeckill;
import com.study.bean.vo.GoodsDetailVo;
import com.study.bean.vo.GoodsListVo;
import com.study.dao.GoodsDao;
import com.study.dao.GoodsSeckillDao;
import com.study.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsDao goodsDao;
    @Autowired
    private GoodsSeckillDao goodsSeckillDao;

    @Override
    public List<GoodsListVo> getGoodsList() {
        return goodsDao.getGoodsList();
    }

    @Override
    public GoodsDetailVo getGoodsDetailByGoodsId(Long goodsId) {
        return goodsDao.getById(goodsId);
    }

    @Override
    public GoodsSeckill getGoodsSeckillByGoodsId(Long goodsId) {
        return goodsSeckillDao.getById(goodsId);
    }

    @Override
    public boolean inventoryReductionOfGoodsSeckill(Long goodsId) {

        return goodsSeckillDao.inventoryReduction(goodsId) > 0;
    }
}
