package com.what2e.eatwhat.service;

import com.what2e.eatwhat.entity.User;

public interface LoginService<E> {
    boolean checkPassWord(E e, String password);
}
