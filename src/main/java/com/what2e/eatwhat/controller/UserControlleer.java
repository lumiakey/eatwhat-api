package com.what2e.eatwhat.controller;

import com.google.gson.Gson;
import com.what2e.eatwhat.entity.ResponseResult;
import com.what2e.eatwhat.entity.Result;
import com.what2e.eatwhat.entity.User;
import com.what2e.eatwhat.service.LoginService;
import com.what2e.eatwhat.service.UserService;
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

/**
 * @author lumike
 * @version v1.0
 * @title UserControlleer
 * @date 19-5-5 上午2:00
 * @Description 用户相关的Controller
 **/

@Controller
@RequestMapping(value = "/user", produces = {"text/html;charset=UTF-8;", "application/json;charset=UTF-8;"})
public class UserControlleer {

    private final static Logger logger = LoggerFactory.getLogger(UserControlleer.class);

    @Autowired
    UserService userService;

    @Autowired
    LoginService<User> loginService;

    ResponseResult responseResult;

    Gson gson = new Gson();

    @RequestMapping(value = "/login")
    @ResponseBody
    public String login(HttpServletRequest request, HttpServletResponse response, String phonenumber, String password) {
        logger.info("UserController login" + phonenumber + password);
        String retString;
        User user = new User();
        Result loginSatatus = new Result(100, "账户验证不通过");
        if (StringUtils.isEmpty(phonenumber)) {
            logger.info("phonenumber null");
        } else if (StringUtils.isEmpty(password)) {
            logger.info("password null");
        } else {
            User userInfo = this.getUserInfoByPhone(phonenumber);
            if (userInfo != null) {
                if (userInfo.getValidity().equals("YES") && loginService.checkPassWord(userInfo, password)) {
                    loginSatatus.setStatusCode(200);
                    loginSatatus.setStatusDescription(JWTUtil.getToken(userInfo.getuId()));
                    responseResult = new ResponseResult("登录成功", loginSatatus);
                }
            }
        }
        return gson.toJson(responseResult);
    }

    @RequestMapping(value = "/register")
    @ResponseBody
    public String register(HttpServletRequest request, HttpServletResponse response, String phonenumber, String password) {
        logger.info("UserController regist" + phonenumber + password);
        /**
         * 生成了动态验证码之后将手机号和动态验证码绑定在服务器
         * 在提交注册的时候校验手机号和动态验证码是否是绑定
         */
        return null;
    }


    @RequestMapping(value = "/getUserInfo")
    @ResponseBody
    public String getUserInfo(HttpServletRequest request, HttpServletResponse response, String phonenumber, String token) {
        logger.info("getUserInfo:" + phonenumber +" " + token);
        if (token == null || token.equals("") || phonenumber == null ) {
            responseResult = new ResponseResult();
        }
        Integer userIdByToken = JWTUtil.getUserIdByToken(token);
        User userInfo = this.getUserInfoByPhone(phonenumber);
        if (userIdByToken != null && userIdByToken == userInfo.getuId()){
            responseResult = new ResponseResult("获取用户信息成功", userInfo);
        }else {
            responseResult = new ResponseResult("1002", "用户认证失败", null);
        }
        return gson.toJson(responseResult);
    }

    public User getUserInfoByPhone(String phonenumber) {
        User user = new User();
        user.setPhonenumber(phonenumber);
        User userInfo = userService.getByUser(user);
        return userInfo;
    }

    public boolean checkRequest(String phonenumber, String password) {
        boolean flag = false;
        User user = new User();
        user.setPhonenumber(phonenumber);
        User userInfo = userService.getByUser(user);
        if (userInfo == null) {
            logger.info("account mistaken");
        } else {
            if (loginService.checkPassWord(userInfo, password)) {
                flag = true;
            }
        }
        return flag;
    }
}
