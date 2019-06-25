package com.study.controller;


import com.study.bean.po.Order;
import com.study.bean.po.OrderSeckill;
import com.study.bean.po.User;
import com.study.bean.vo.GoodsDetailVo;
import com.study.exception.SeckillException;
import com.study.result.CodeMsg;
import com.study.service.GoodsService;
import com.study.service.OrderService;
import com.study.service.SeckillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;


@Controller
@RequestMapping("/seckill")
public class SeckillController {

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private SeckillService seckillService;

    /**
     * 秒杀
     * 1000 并发 11.6 qps
     * @param user
     * @param model
     * @param goodsId
     * @return
     */
    @PostMapping("do")
    public String doSeckill(User user, Model model,
                            @RequestParam(name = "goodsId") Long goodsId) {
        if (user == null) {
            model.addAttribute("errorMsg", CodeMsg.NO_LOGIN.getMsg());
            return "seckill_error";
        }
        // 判断秒杀是否进行中
        GoodsDetailVo goods = goodsService.getGoodsDetailByGoodsId(goodsId);
        if (goods == null || goods.getStartTime() == null) {
            model.addAttribute("errorMsg", CodeMsg.SECKILL_GOODS_NOT_FOUND.getMsg());
            return "seckill_error";
        }
        LocalDateTime now = LocalDateTime.now();
        if (now.isBefore(goods.getStartTime())) {
            model.addAttribute("errorMsg", CodeMsg.SECKILL_NOT_STARTED.getMsg());
            return "seckill_error";
        } else if (now.isAfter(goods.getEndTime()) // 时间到期或者库存不足返回秒杀结束
                || goods.getSeckillStock() <= 0) {
            model.addAttribute("errorMsg", CodeMsg.SECKILL_FINISHED.getMsg());
            return "seckill_error";
        }
        //判断是否已经秒杀到了
        OrderSeckill orderSeckill = orderService.getOrderSeckillByUserIdAndGoodsId(user.getId(), goods.getId());
        if (orderSeckill != null) {
            model.addAttribute("errorMsg", CodeMsg.SECKILL_CAN_NOT_REPEAT.getMsg());
            return "seckill_error";
        }
        Order order = null;
        try {
            order = seckillService.doSeckill(user.getId(), goods.getId());
        } catch (SeckillException e) {
            model.addAttribute("errorMsg", e.getCodeMsg().getMsg());
            return "seckill_error";
        }
        model.addAttribute("order", order);
        model.addAttribute("goods", goods);
        return "order_detail";
    }


}
