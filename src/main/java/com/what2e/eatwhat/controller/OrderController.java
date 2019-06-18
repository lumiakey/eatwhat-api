package com.what2e.eatwhat.controller;

import com.google.gson.Gson;
import com.what2e.eatwhat.entity.*;
import com.what2e.eatwhat.service.*;
import com.what2e.eatwhat.util.DateUtils;
import com.what2e.eatwhat.util.JWTUtil;
import com.what2e.eatwhat.util.SerializeUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author lumike
 * @version v1.0
 * @title OrderController
 * @date 19-5-5 上午2:36
 * @Description 订单相关controller
 **/
@Controller
@RequestMapping(value = "/order",produces = {"text/html;charset=UTF-8;", "application/json;charset=UTF-8;"})
public class OrderController {

    private final static Logger logger = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    OrderService orderService;

    @Autowired
    OrderDescService orderDescService;

    @Autowired
    RedisService redisService;

    @Autowired
    GroupUserService groupUserService;

    @Autowired
    BlacklistService blacklistService;

    @Autowired
    AddressService addressService;

    ResponseResult responseResult;

    Gson gson = new Gson();

    @RequestMapping(value = "/getOrderList")
    @ResponseBody
    public String getOrderByUserId(HttpServletRequest request, HttpServletResponse response, Integer userId ,String token) {
        logger.info("getOrderByUserId : userId:" + userId +" token:" +token);
        Integer userIdByToken = JWTUtil.getUserIdByToken(token);
        if (userIdByToken != null && userIdByToken == userId) {
            ArrayList<Order> orderArrayList = orderService.getOrderByUserId(userId);
            ArrayList<ResponseOrder> responseOrderArrayList = new ArrayList<>();
            for (Order order : orderArrayList) {
                ResponseOrder responseOrder = new ResponseOrder();
                responseOrder.setOderId(order.getOrderId());
                responseOrder.setOrderType(order.getOrderTypeId());
                responseOrder.setAddress(order.getAddress());
                responseOrder.setCreateTime(order.getCreateTime());
                responseOrder.setOrderPrice(order.getOrderPrice());
                responseOrder.setOrderRemarks(order.getOrderRemarks());
                responseOrder.setOrderDesc(orderDescService.getOrderDescByOrderId(order.getOrderId()));
                responseOrderArrayList.add(responseOrder);
            }
            responseResult = new ResponseResult("请求成功",responseOrderArrayList);
        }else {
            responseResult = new ResponseResult("1002", "用户认证失败", null);
        }
        return gson.toJson(responseResult);
    }

    @RequestMapping(value = "/payment")
    @ResponseBody
    public String payment(HttpServletRequest request, HttpServletResponse response, Integer paymentType, Integer orderId , String token) {
        logger.info("payment : orderId:" + orderId +" token:" +token);
        Integer userIdByToken = JWTUtil.getUserIdByToken(token);
        if (userIdByToken != null && orderId != null) {
            Order order = orderService.getOrderByOrderId(orderId);
            if (order !=null && order.getuId() == userIdByToken) {
                order.setOrderTypeId(2);
                orderService.paymentOrder(order);
                Result result = new Result(100, "付款成功");
                responseResult = new ResponseResult("1000","请求成功", result);
            } else {
                responseResult = new ResponseResult("1002", "用户认证失败", null);
            }
        }else {
            responseResult = new ResponseResult("1002", "用户认证失败", null);
        }
        return gson.toJson(responseResult);
    }

    @RequestMapping(value = "/cancel")
    @ResponseBody
    public String cancel(HttpServletRequest request, HttpServletResponse response, Integer orderId , String token) {
        logger.info("cancel : orderId:" + orderId +" token:" +token);
        Integer userIdByToken = JWTUtil.getUserIdByToken(token);
        if (userIdByToken != null && orderId != null) {
            Order order = orderService.getOrderByOrderId(orderId);
            if (order.getuId() == userIdByToken) {
                orderService.cancelOrder(orderId);
                Result result = new Result(100, "取消订单成功");
                responseResult = new ResponseResult("1000", "请求成功", result);
            } else {
                responseResult = new ResponseResult("1002", "用户认证失败", null);
            }
        } else {
            responseResult = new ResponseResult("1002", "用户认证失败", null);
        }
        return gson.toJson(responseResult);
    }

    @RequestMapping(value = "/submitOrders")
    @ResponseBody
    public String submitOrders(HttpServletRequest request, HttpServletResponse response, String order, String token) {
        logger.info("submitOrders : order:" + order +" token:s" +token);
        boolean flag = false;
        ReentrantLock lock = new ReentrantLock();
        RequestOrder newOrder = gson.fromJson(order, RequestOrder.class);
        ArrayList<RequestOrderDesc> orderDescArrayList = newOrder.getOrderDescs();
        Integer userIdByToken = JWTUtil.getUserIdByToken(token);
        if (userIdByToken != null && userIdByToken == newOrder.getUserId()) {
            for (RequestOrderDesc orderDesc : orderDescArrayList) {
                if (orderDesc != null) {
                    logger.info("submitOrders"+orderDesc.getFoodId().toString());
                    byte[] bytes = redisService.read(orderDesc.getFoodId().toString().getBytes());
                    RedisFoodValue redisFoodValue = (RedisFoodValue) SerializeUtil.unserialize(bytes);
                    int orderAmount = orderDesc.getOrderAmount();
                    if (orderAmount < redisFoodValue.getRemainder()) {
                        if (orderAmount < 10) {
                            redisFoodValue.setRemainder(redisFoodValue.getRemainder() - orderAmount);
                            redisService.write(orderDesc.getFoodId().toString().getBytes(), SerializeUtil.serialize(redisFoodValue));
                            flag = true;
                        } else {
                            if (groupUserService.isGroupUser(newOrder.getUserId())) {
                                redisFoodValue.setRemainder(redisFoodValue.getRemainder() - orderAmount);
                                redisService.write(orderDesc.getFoodId().toString().getBytes(), SerializeUtil.serialize(redisFoodValue));
                                flag = true;
                            } else { //不是团队
                                if (blacklistService.isBlacklistUser(newOrder.getUserId())) {
                                    Result submitResult = new Result(400, "获取购买资格失败");
                                    responseResult = new ResponseResult("1003","黑名单用户", submitResult);
                                } else {
                                    if (orderAmount < 100) {
                                        redisFoodValue.setRemainder(redisFoodValue.getRemainder() - orderAmount / 2);
                                        redisService.write(orderDesc.getFoodId().toString().getBytes(), SerializeUtil.serialize(redisFoodValue));
                                        flag = true;
                                    } else {
                                        Result submitResult = new Result(400, "获取购买资格失败");
                                        responseResult = new ResponseResult("1003","一次订购太多", submitResult);
                                    }
                                }
                            }
                        }
                    } else {
                        Result submitResult = new Result(400, "获取购买资格失败");
                        responseResult = new ResponseResult("1003","余量不足，下单失败", submitResult);
                    }
                } else {
                    Result submitResult = new Result(400, "获取购买资格失败");
                    responseResult = new ResponseResult("1003","订单详情错误", submitResult);
                }
            }
        } else {
            Result submitResult = new Result(400, "获取购买资格失败");
            responseResult = new ResponseResult("1","1001","用户认证失败", submitResult);
        }
        if (flag) {
            //降级 直接MySQL入库
            Integer orderId = orderService.submitOrder(newOrder);
            if (orderId != null) {
                //修改redis总量
                for (RequestOrderDesc orderDesc : orderDescArrayList) {
                    lock.lock();
                    byte[] read = redisService.read(orderDesc.getFoodId().toString().getBytes());
                    RedisFoodValue redisFoodValue = (RedisFoodValue)SerializeUtil.unserialize(read);
                    int inventory = redisFoodValue.getInventory(); //库存
                    int remainder = redisFoodValue.getRemainder(); //剩余
                    int newInventory = inventory - orderDesc.getOrderAmount();
                    if (newInventory >= remainder) {
                        redisFoodValue.setInventory(newInventory);
                        redisService.write(orderDesc.getFoodId().toString().getBytes(),SerializeUtil.serialize(redisFoodValue));
                    } else {
                        redisFoodValue.setInventory(newInventory);
                        redisFoodValue.setRemainder(newInventory);
                        redisService.write(orderDesc.getFoodId().toString().getBytes(),SerializeUtil.serialize(redisFoodValue));
                    }
                    lock.unlock();
                }
                Result submitResult = new Result(200,""+orderId);
                responseResult = new ResponseResult("提交成功", submitResult);
            } else {
                //资格回滚
                for (RequestOrderDesc orderDesc : orderDescArrayList) {
                    lock.lock();
                    byte[] read = redisService.read(orderDesc.getFoodId().toString().getBytes());
                    RedisFoodValue redisFoodValue = (RedisFoodValue)SerializeUtil.unserialize(read);
                    int remainder = redisFoodValue.getRemainder(); //剩余
                    Integer orderAmount = orderDesc.getOrderAmount();
                    if (orderAmount < 10) {
                        redisFoodValue.setRemainder(remainder+orderAmount);
                        redisService.write(orderDesc.getFoodId().toString().getBytes(),SerializeUtil.serialize(redisFoodValue));
                    } else {
                        Integer userId = newOrder.getUserId();
                        if (groupUserService.isGroupUser(userId)) {
                            redisFoodValue.setRemainder(remainder+orderAmount/2);
                            redisService.write(orderDesc.getFoodId().toString().getBytes(),SerializeUtil.serialize(redisFoodValue));
                        }
                    }
                    lock.unlock();
                }
                Result submitResult = new Result(500, "订单入库失败");
                responseResult = new ResponseResult("1003","提交失败", submitResult);
            }
            //不降级 发送订单到MQ
        }
        return gson.toJson(responseResult);
    }

}
