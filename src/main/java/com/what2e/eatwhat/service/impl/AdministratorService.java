package com.what2e.eatwhat.service.impl;

import com.what2e.eatwhat.dao.AdministratorMapper;
import com.what2e.eatwhat.entity.Administrator;
import com.what2e.eatwhat.entity.User;
import com.what2e.eatwhat.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author lumike
 * @version v1.0
 * @title
 * @date
 * @Description
 **/
@Service
public class AdministratorService implements LoginService<Administrator> {

    @Autowired
    AdministratorMapper administratorMapper;

    @Override
    public boolean checkPassWord(Administrator administrator, String password) {
        if (administrator.getPassword().equals(password)) {
            return true;
        } else {
            return false;
        }
    }

    public Administrator getAdministratorByPhonenumber(String phonenumber) {
        Administrator administrator = new Administrator();
        if (phonenumber != null) {
            administrator = administratorMapper.selectByPhonenumber(phonenumber);
        }
        return administrator;
    }
}
