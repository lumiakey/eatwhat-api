package com.what2e.eatwhat.service.impl;

import com.what2e.eatwhat.dao.GroupUserMapper;
import com.what2e.eatwhat.entity.GroupUser;
import com.what2e.eatwhat.service.GroupUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author lumike
 * @version v1.0
 * @title GroupUserServiceImpl
 * @date 19-5-12 上午3:49
 * @Description 团队用户服务
 **/
@Service
public class GroupUserServiceImpl implements GroupUserService {

    @Autowired
    GroupUserMapper groupUserMapper;

    @Override
    public boolean isGroupUser(int userId) {
        GroupUser groupUser = groupUserMapper.selectByUserId(userId);
        if (groupUser != null) {
            return true;
        }
        return false;
    }
}
