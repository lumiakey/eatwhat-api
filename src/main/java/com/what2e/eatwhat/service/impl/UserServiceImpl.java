package com.what2e.eatwhat.service.impl;

import com.what2e.eatwhat.dao.UserMapper;
import com.what2e.eatwhat.entity.User;
import com.what2e.eatwhat.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author lumike
 * @version v1.0
 * @title UserServiceImpl
 * @date 19-5-3 下午12:13
 * @Description 用户相关service
 **/
@Service
public class UserServiceImpl implements UserService {
    public static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    UserMapper userMapper;

    @Override
    public User getByUser(User user) {
        return userMapper.getByUser(user);
    }

    @Override
    public User getUserByUid(Integer userId) {
        User user = new User();
        if (userId != null) {
            user = userMapper.selectByPrimaryKey(userId);
        }
        return user;
    }
}
