package com.what2e.eatwhat.service.impl;

import com.what2e.eatwhat.entity.User;
import com.what2e.eatwhat.service.LoginService;
import org.springframework.stereotype.Service;

/**
 * @author lumike
 * @version v1.0
 * @title LoginServiceImpl
 * @date 19-5-3 上午11:47
 * @Description 登录验证
 **/
@Service
public class LoginServiceImpl implements LoginService {
    
    @Override
    public boolean checkPassWord(User userInfo, String password) {
        if (userInfo.getPassword().equals(password)) {
            return true;
        } else {
            return false;
        }
    }
}
