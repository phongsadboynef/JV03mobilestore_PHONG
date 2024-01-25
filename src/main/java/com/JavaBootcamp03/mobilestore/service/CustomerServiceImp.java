package com.JavaBootcamp03.mobilestore.service;

import com.JavaBootcamp03.mobilestore.entity.CustomerEntity;
import com.JavaBootcamp03.mobilestore.entity.RoleEntity;
import com.JavaBootcamp03.mobilestore.repository.CustomerRepository;
import com.JavaBootcamp03.mobilestore.repository.RoleRepository;
import com.JavaBootcamp03.mobilestore.service.serviceInterface.CustomerService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class CustomerServiceImp implements CustomerService {
    private RoleRepository roleRepository;
    private CustomerRepository customerRepository;
    private PasswordEncoder passwordEncoder;
    private ModelMapper modelMapper;

    @Override
    public List<CustomerEntity> getAllCustomer() {
        return customerRepository.findAll();
    }

    @Override
    public CustomerEntity createCustomer(CustomerEntity customer) {
        RoleEntity role = checkRoleExist();
        customer.setRoleCustomer(role);

        return customerRepository.save(customer);
    }

    @Override
    public CustomerEntity updateCustomer(int id, CustomerEntity customer) {
        CustomerEntity customerEntity = customerRepository.findById(id);

        if(customerEntity != null){
            customerEntity.setFirstName(customer.getFirstName());
            customerEntity.setLastName(customer.getLastName());
            customerEntity.setDob(customer.getDob());
            customerEntity.setGender(customer.getGender());
            customerEntity.setRank(customer.getRank());
            customerEntity.setRoleCustomer(customer.getRoleCustomer());
            customerEntity.setAddressDetails(customer.getAddressDetails());
            customerEntity.setEmail(customer.getEmail());
            customerEntity.setPassword(customer.getPassword());

            return customerRepository.save(customerEntity);
        }


        return null;
    }

    @Override
    public void deleteCustomer(int id) {
        CustomerEntity customerEntity = customerRepository.findById(id);
        if(customerEntity != null){
            customerRepository.delete(customerEntity);
        }
    }

    @Override
    public CustomerEntity getCustomerByEmail(String email) {
        return customerRepository.findByEmail(email);
    }

    @Override
    public CustomerEntity getCustomerById(int id) {
        return customerRepository.findById(id);
    }

    @Override
    public CustomerEntity checkLogin(String username, String password) {
        CustomerEntity customer = customerRepository.findByEmail(username);
        if(customer != null && passwordEncoder.matches(password, customer.getPassword())){
            return customer;
        }
        return null;
    }

    private RoleEntity checkRoleExist(){
        RoleEntity role = new RoleEntity();
        role.setName("CUSTOMER");
        return roleRepository.save(role);
    }
}
