package com.what2e.eatwhat.controller;

import com.google.gson.Gson;
import com.what2e.eatwhat.entity.Information;
import com.what2e.eatwhat.entity.RedisInformationListKey;
import com.what2e.eatwhat.entity.ResponseResult;
import com.what2e.eatwhat.service.RedisService;
import com.what2e.eatwhat.util.SerializeUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

@Controller
@RequestMapping(value = "/information", produces = {"text/html;charset=UTF-8;", "application/json;charset=UTF-8;"})
public class InformationController {

    Gson gson = new Gson();

    private final static Logger logger = LoggerFactory.getLogger(InformationController.class);

    @Autowired
    RedisService redisService;

    ResponseResult responseResult;

    @RequestMapping(value = "/getInformationList")
    @ResponseBody
    public String getInfomationList(HttpServletRequest request, HttpServletResponse response, String locationCode, String time) {
        logger.info("Into InformationController : getInfomationList");
        if (locationCode == null || locationCode.equals("")) {
            responseResult = new ResponseResult("1001", "参数不能为空", null);
        }
        if (time == null || time.equals("")) {
            responseResult = new ResponseResult("1001", "参数不能为空", null);
        }
        String[] requestTime = time.split(" ");
        RedisInformationListKey redisInformationListKey = new RedisInformationListKey(requestTime[0], locationCode);
        byte[] bytes = redisService.read(redisInformationListKey.getKey().getBytes());
        ArrayList<Information> informationArrayList = (ArrayList<Information>) SerializeUtil.unserialize(bytes);
        responseResult = new ResponseResult("1000", "获取信息列表成功", informationArrayList);
        return gson.toJson(responseResult);
    }

}
