package com.what2e.eatwhat.dao;

import com.what2e.eatwhat.entity.Information;
import com.what2e.eatwhat.entity.InformationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface InformationMapper {
    int countByExample(InformationExample example);

    int deleteByExample(InformationExample example);

    int insert(Information record);

    int insertSelective(Information record);

    List<Information> selectByIssueTime(String issueTime);

    List<Information> selectByExample(InformationExample example);

    int updateByExampleSelective(@Param("record") Information record, @Param("example") InformationExample example);

    int updateByExample(@Param("record") Information record, @Param("example") InformationExample example);
}