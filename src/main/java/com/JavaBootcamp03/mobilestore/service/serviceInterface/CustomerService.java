package com.JavaBootcamp03.mobilestore.service.serviceInterface;

import com.JavaBootcamp03.mobilestore.entity.CustomerEntity;

import java.util.List;

public interface CustomerService {
    List<CustomerEntity> getAllCustomer();

    CustomerEntity createCustomer(CustomerEntity customer);

    CustomerEntity updateCustomer(int id, CustomerEntity customer);

    void deleteCustomer(int id);

    CustomerEntity getCustomerByEmail(String email);

    CustomerEntity getCustomerById(int id);

    CustomerEntity checkLogin(String email, String password);
}
