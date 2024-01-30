package com.JavaBootcamp03.mobilestore.service.serviceInterface;

import com.JavaBootcamp03.mobilestore.dto.CustomerDTO;
import com.JavaBootcamp03.mobilestore.entity.CustomerEntity;
import java.util.List;

public interface CustomerServiceImp {
    List<CustomerEntity> getAllCustomer();

    CustomerEntity createCustomer(CustomerDTO customerDTO);

    CustomerEntity updateCustomer(int id, CustomerDTO customerDTO);

    void deleteCustomer(int id);

    CustomerEntity getCustomerByEmail(String email);

    CustomerEntity getCustomerById(int id);

    CustomerEntity checkLogin(String email, String password);

    List<CustomerEntity> getCustomerByRoleId(int id);

    Boolean existsByEmail(String email);

    CustomerEntity signUpCustomer(CustomerDTO customerDTO);
}
