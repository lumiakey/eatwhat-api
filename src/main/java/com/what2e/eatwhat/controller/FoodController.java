package com.what2e.eatwhat.controller;

import com.google.gson.Gson;
import com.what2e.eatwhat.entity.Food;
import com.what2e.eatwhat.entity.FoodJson;
import com.what2e.eatwhat.entity.ResponseResult;
import com.what2e.eatwhat.service.FoodService;
import com.what2e.eatwhat.service.RedisService;
import com.what2e.eatwhat.util.JWTUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author lumike
 * @version v1.0
 * @title FoodController
 * @date 19-5-5 下午10:14
 * @Description 菜品相关Controller
 **/
@Controller
@RequestMapping(value = "/food", produces = {"text/html;charset=UTF-8;", "application/json;charset=UTF-8;"})
public class FoodController {

    private final static Logger logger = LoggerFactory.getLogger(FoodController.class);

    Gson gson = new Gson();

    ResponseResult responseResult;

    FoodJson foodJson = new FoodJson();

    @Autowired
    RedisService redisService;

    @Autowired
    FoodService foodService;

    @RequestMapping(value = "/getFoodList")
    @ResponseBody
    public String getFoodList(HttpServletRequest request, HttpServletResponse response, String locationCode, String time) {
        logger.info("Into FoodController : getFoodList");
        if (locationCode == null || locationCode.equals("")) {
            responseResult = new ResponseResult("1001", "参数不能为空", null);
        }
        if (time == null || time.equals("")) {
            responseResult = new ResponseResult("1001", "参数不能为空", null);
        }
        String[] requestTime = time.split(" ");
        int hour = Integer.valueOf(requestTime[1].substring(0, 2));
        if (hour < 10) {
            responseResult = new ResponseResult("获取全天菜单", redisService.readFoodListOfOneDay(requestTime[0], locationCode));
        } else if (hour < 13) {
            responseResult = new ResponseResult("获取午餐和晚餐菜单", redisService.readFoodListOfLunchAndDinner(requestTime[0], locationCode));
        } else if (hour < 19) {
            responseResult = new ResponseResult("获取晚餐菜单", redisService.readFoodDinner(requestTime[0], locationCode));
        } else {
            responseResult = new ResponseResult("获取全天菜单", redisService.readFoodListOfOneDay(requestTime[0], locationCode));
        }
        return gson.toJson(responseResult);
    }

    @RequestMapping(value = "/add")
    @ResponseBody
    public String addFood(HttpServletRequest request, HttpServletResponse response, String food,Integer uId, String token) {
        if (food == null || food.equals("") || token == null || token.equals("")) {
            responseResult = new ResponseResult();
        } else {
            Integer userIdByToken = JWTUtil.getUserIdByToken(token);
            Food newFood = gson.fromJson(food, Food.class);
            if (userIdByToken == uId) {
                foodService.add(newFood);
                responseResult = new ResponseResult("添加成功", null);
            } else {
                responseResult = new ResponseResult("1002", "用户认证失败", null);
            }
        }
        return gson.toJson(responseResult);
    }
}