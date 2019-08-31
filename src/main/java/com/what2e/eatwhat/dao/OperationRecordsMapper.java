package com.what2e.eatwhat.dao;

import com.what2e.eatwhat.entity.OperationRecords;
import com.what2e.eatwhat.entity.OperationRecordsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OperationRecordsMapper {
    int countByExample(OperationRecordsExample example);

    int deleteByExample(OperationRecordsExample example);

    int deleteByPrimaryKey(Integer operationId);

    int insert(OperationRecords record);

    int insertSelective(OperationRecords record);

    List<OperationRecords> selectByExample(OperationRecordsExample example);

    OperationRecords selectByPrimaryKey(Integer operationId);

    int updateByExampleSelective(@Param("record") OperationRecords record, @Param("example") OperationRecordsExample example);

    int updateByExample(@Param("record") OperationRecords record, @Param("example") OperationRecordsExample example);

    int updateByPrimaryKeySelective(OperationRecords record);

    int updateByPrimaryKey(OperationRecords record);
}