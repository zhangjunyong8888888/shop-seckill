package com.study.controller;


import com.study.bean.po.User;
import com.study.bean.vo.GoodsDetailVo;
import com.study.bean.vo.GoodsListVo;
import com.study.enums.SeckillStatusEnum;
import com.study.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;


@Controller
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @GetMapping("/list")
    public String toList(Model model) {
        List<GoodsListVo> goodsList = goodsService.getGoodsList();
        model.addAttribute("goodsList", goodsList);
        return "goods_list";
    }

    @GetMapping("/detail/{goodsId}")
    public String toDetail(Model model, User user,
                           @PathVariable("goodsId") Long goodsId) {

        GoodsDetailVo goodsDetail = goodsService.getGoodsDetailByGoodsId(goodsId);
        if (goodsDetail == null) {
            return "sys/404";
        }
        // 计算活动状态
        LocalDateTime now = LocalDateTime.now();
        if (now.isBefore(goodsDetail.getStartTime())) {
            Duration duration = Duration.between(now, goodsDetail.getStartTime());
            goodsDetail.setRemainSeconds(duration.getSeconds());
            goodsDetail.setSeckillStatus(SeckillStatusEnum.NOT_STARTED.getCode());

        } else if (now.isAfter(goodsDetail.getEndTime())) {
            goodsDetail.setRemainSeconds(-1L);
            goodsDetail.setSeckillStatus(SeckillStatusEnum.FINISHED.getCode());
        } else {
            goodsDetail.setRemainSeconds(0L);
            goodsDetail.setSeckillStatus(SeckillStatusEnum.PROGRESS.getCode());
        }
        model.addAttribute("goods", goodsDetail);
        model.addAttribute("user", user);
        return "goods_detail";
    }

}
