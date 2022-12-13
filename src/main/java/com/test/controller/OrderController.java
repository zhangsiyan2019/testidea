package com.test.controller;


import com.baomidou.mybatisplus.core.conditions.update.Update;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.test.DTO.OrderDTO;
import com.test.model.Order;
import com.test.service.IOrderService;
import com.test.util.JsonResponseBody;
import com.test.util.JsonResponseStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zsy
 * @since 2022-11-25
 */
@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private IOrderService orderService;

    @RequestMapping("/saveOrder")
    public JsonResponseBody save(Order order){
        boolean f = orderService.save(order);
        if(f){
            return new JsonResponseBody();
        }
        return new JsonResponseBody(JsonResponseStatus.SAVEERROR.getCode(),JsonResponseStatus.SAVEERROR.getMsg());

    }
    @RequestMapping("/updateOrder")
    public JsonResponseBody update(Order order){
        UpdateWrapper update=new UpdateWrapper();
        update.eq("order_id",order.getOrderId());
//        boolean f = orderService.update(order,update);
        boolean f = orderService.saveOrUpdate(order);
        if(f){
            return new JsonResponseBody();
        }
        return new JsonResponseBody(JsonResponseStatus.UPDATEERROR.getCode(),JsonResponseStatus.UPDATEERROR.getMsg());

    }

    @RequestMapping("/delOrder")
    public JsonResponseBody del(Order order){
        UpdateWrapper edit=new UpdateWrapper();
        edit.eq("order_id",order.getOrderId());
        //delete from t_order where order_id=6
        boolean f = orderService.remove(edit);
        if(f){
            return new JsonResponseBody();
        }
        return new JsonResponseBody(JsonResponseStatus.DELERROR.getCode(),JsonResponseStatus.DELERROR.getMsg());

    }

    @RequestMapping("/list")
    public JsonResponseBody queryCon(OrderDTO orderDTO){
        JsonResponseBody jrb=orderService.queryConTable(orderDTO);
        return jrb;
    }





}
