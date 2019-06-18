package com.what2e.eatwhat.service;

import com.what2e.eatwhat.entity.Address;

public interface AddressService {
    Address getAddressById(Integer addressId);

    void add(Address address);

    void remove(Integer addressId);
}
