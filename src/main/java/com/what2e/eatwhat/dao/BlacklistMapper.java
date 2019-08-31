package com.what2e.eatwhat.dao;

import com.what2e.eatwhat.entity.Blacklist;
import com.what2e.eatwhat.entity.BlacklistExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BlacklistMapper {
    int countByExample(BlacklistExample example);

    int deleteByExample(BlacklistExample example);

    int deleteByPrimaryKey(Integer blacklistId);

    int insert(Blacklist record);

    int insertSelective(Blacklist record);

    List<Blacklist> selectByExample(BlacklistExample example);

    Blacklist selectByPrimaryKey(Integer blacklistId);

    Blacklist selectByUserId(Integer userId);

    int updateByExampleSelective(@Param("record") Blacklist record, @Param("example") BlacklistExample example);

    int updateByExample(@Param("record") Blacklist record, @Param("example") BlacklistExample example);

    int updateByPrimaryKeySelective(Blacklist record);

    int updateByPrimaryKey(Blacklist record);
}