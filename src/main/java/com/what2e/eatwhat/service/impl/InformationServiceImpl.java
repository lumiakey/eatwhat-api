package com.what2e.eatwhat.service.impl;

import com.what2e.eatwhat.dao.InformationMapper;
import com.what2e.eatwhat.entity.Information;
import com.what2e.eatwhat.service.InformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InformationServiceImpl implements InformationService {

    @Autowired
    InformationMapper informationMapper;

    @Override
    public List<Information> getInformationListByIssueTime(String issueTime) {
        List<Information> informationArrayList = new ArrayList<>();
        if (issueTime != null && !issueTime.equals("")) {
            informationArrayList = informationMapper.selectByIssueTime(issueTime);
        }
        return informationArrayList;
    }
}
