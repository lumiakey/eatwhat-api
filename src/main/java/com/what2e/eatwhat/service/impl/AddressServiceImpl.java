package com.what2e.eatwhat.service.impl;

import com.what2e.eatwhat.dao.AddressMapper;
import com.what2e.eatwhat.entity.Address;
import com.what2e.eatwhat.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    AddressMapper addressMapper;

    @Override
    public void remove(Integer addressId) {
        if (addressId != null) {
            addressMapper.deleteByPrimaryKey(addressId);
        }
    }

    @Override
    public Address getAddressById(Integer addressId) {
        return addressMapper.selectByPrimaryKey(addressId);
    }

    @Override
    public void add(Address address) {
        if (address != null) {
            addressMapper.insertSelective(address);
        }
    }
}
