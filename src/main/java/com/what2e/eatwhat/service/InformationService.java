package com.what2e.eatwhat.service;

import com.what2e.eatwhat.entity.Information;

import java.util.List;

public interface InformationService {
    List<Information> getInformationListByIssueTime(String issueTime);
}
