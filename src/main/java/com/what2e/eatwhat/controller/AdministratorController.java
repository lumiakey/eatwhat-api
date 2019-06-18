package com.what2e.eatwhat.controller;

import com.google.gson.Gson;
import com.what2e.eatwhat.entity.Administrator;
import com.what2e.eatwhat.entity.ResponseResult;
import com.what2e.eatwhat.entity.Result;
import com.what2e.eatwhat.service.LoginService;
import com.what2e.eatwhat.service.impl.AdministratorService;
import com.what2e.eatwhat.util.JWTUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping(value = "/administrator", produces = {"text/html;charset=UTF-8;", "application/json;charset=UTF-8;"})
public class AdministratorController {
    private final static Logger logger = LoggerFactory.getLogger(AdministratorController.class);
    Gson gson = new Gson();

    @Autowired
    LoginService<Administrator> loginService;

    @Autowired
    AdministratorService administratorService;

    ResponseResult responseResult;

    @RequestMapping(value = "/login")
    @ResponseBody
    public String login(HttpServletRequest request, HttpServletResponse response, String phonenumber, String password) {
        logger.info("administrator login"+phonenumber +" "+ password);
        if (StringUtils.isEmpty(phonenumber)) {
            logger.info("phonenumber null");
            responseResult = new ResponseResult("1001", "电话为空", null);
        } else if (StringUtils.isEmpty(password)) {
            logger.info("password null");
            responseResult = new ResponseResult("1001", "密码为空", null);
        } else {
            Administrator administrator = administratorService.getAdministratorByPhonenumber(phonenumber);
            Result loginSatatus = new Result(100, "账户验证不通过");
            if (administrator != null) {
                if (administrator.getValidity().equals("YES") && loginService.checkPassWord(administrator, password)) {
                    loginSatatus.setStatusCode(200);
                    loginSatatus.setStatusDescription(JWTUtil.getToken(administrator.getAdminId()));
                    responseResult = new ResponseResult("登录成功", loginSatatus);
                } else responseResult = new ResponseResult("1003", "账户无效或密码错误", loginSatatus);
            } else {
                responseResult = new ResponseResult("1003", "账户无效", null);
            }
        }
        return gson.toJson(responseResult);
    }

}
