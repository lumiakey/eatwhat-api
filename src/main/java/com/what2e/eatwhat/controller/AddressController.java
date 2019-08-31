package com.what2e.eatwhat.controller;

import com.google.gson.Gson;
import com.what2e.eatwhat.entity.Address;
import com.what2e.eatwhat.entity.RequestOrder;
import com.what2e.eatwhat.entity.ResponseResult;
import com.what2e.eatwhat.service.AddressService;
import com.what2e.eatwhat.util.JWTUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping(value = "/address", produces = {"text/html;charset=UTF-8;", "application/json;charset=UTF-8;"})
public class AddressController {
    private final static Logger logger = LoggerFactory.getLogger(AddressController.class);

    ResponseResult responseResult;

    Gson gson = new Gson();

    @Autowired
    AddressService addressService;

    @RequestMapping(value = "/add")
    @ResponseBody
    public String addAddress(HttpServletRequest request, HttpServletResponse response, String address, String token) {
        logger.info("Into address : add");
        if (address != null && !address.equals("") && token != null && !token.equals("")) {
            Integer userIdByToken = JWTUtil.getUserIdByToken(token);
            Address newAddress = gson.fromJson(address, Address.class);
            if (userIdByToken != null && newAddress != null && newAddress.getuId() == userIdByToken) {
                addressService.add(newAddress);
                responseResult = new ResponseResult("添加成功", null);
            } else {
                responseResult = new ResponseResult("1002", "用户认证失败", null);
            }
        } else {
            responseResult = new ResponseResult();
        }
        return gson.toJson(responseResult);
    }

    @RequestMapping(value = "/remove")
    @ResponseBody
    public String removeAddress(HttpServletRequest request, HttpServletResponse response, Integer addressId, String token) {
        logger.info("Into address : remove");
        if (addressId != null && !addressId.equals("") && token != null && !token.equals("")) {
            Integer userIdByToken = JWTUtil.getUserIdByToken(token);
            Address addressById = addressService.getAddressById(addressId);
            if (userIdByToken != null && addressById != null && addressById.getuId() == userIdByToken) {
                addressService.remove(addressId);
                responseResult = new ResponseResult("删除成功", null);
            } else {
                responseResult = new ResponseResult("1002", "用户认证失败", null);
            }
        } else {
            responseResult = new ResponseResult();
        }
        return gson.toJson(responseResult);
    }
}
