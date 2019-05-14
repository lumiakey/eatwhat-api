package com.what2e.eatwhat.service.impl;

import com.what2e.eatwhat.dao.BlacklistMapper;
import com.what2e.eatwhat.entity.Blacklist;
import com.what2e.eatwhat.service.BlacklistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author lumike
 * @version v1.0
 * @title BlackListServiceImpl
 * @date 19-5-12 上午4:10
 * @Description 黑名单
 **/
@Service
public class BlackListServiceImpl implements BlacklistService {

    @Autowired
    BlacklistMapper blacklistMapper;

    @Override
    public boolean isBlacklistUser(int userId) {
        Blacklist blacklist = blacklistMapper.selectByUserId(userId);
        if (blacklist != null) {
            return true;
        }
        return false;
    }
}
