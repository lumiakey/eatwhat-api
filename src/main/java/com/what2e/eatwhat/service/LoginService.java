package com.what2e.eatwhat.service;

import com.what2e.eatwhat.entity.User;

public interface LoginService {
    boolean checkPassWord(User userInfo, String password);
}
