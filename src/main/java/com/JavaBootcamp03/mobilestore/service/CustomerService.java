package com.JavaBootcamp03.mobilestore.service;

import com.JavaBootcamp03.mobilestore.dto.CustomerDTO;
import com.JavaBootcamp03.mobilestore.entity.CustomerEntity;
import com.JavaBootcamp03.mobilestore.entity.RoleEntity;
import com.JavaBootcamp03.mobilestore.repository.CustomerRepository;
import com.JavaBootcamp03.mobilestore.repository.RoleRepository;
import com.JavaBootcamp03.mobilestore.service.serviceInterface.CustomerServiceImp;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Service
public class CustomerService implements CustomerServiceImp {
    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public CustomerService(CustomerRepository customerRepository, PasswordEncoder passwordEncoder) {
        super();
        this.customerRepository = customerRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public List<CustomerEntity> getAllCustomer() {
        return customerRepository.findAll();
    }

    @Override
    public CustomerEntity createCustomer(CustomerDTO customerDTO) {
        CustomerEntity customer = new CustomerEntity();

        customer.setEmail(customerDTO.getEmail());
        customer.setPassword(passwordEncoder.encode(customerDTO.getPassword()));
        customer.setFirstName(customerDTO.getFirstName());
        customer.setLastName(customerDTO.getLastName());
        customer.setDob(customerDTO.getDob());
        customer.setGender(customerDTO.getGender());

        RoleEntity role = roleRepository.findByName("CUSTOMER");
        if(role == null){
            role = checkRoleExist();
        }
        customer.setRoleCustomer(role);

        return customerRepository.save(customer);
    }

    private RoleEntity checkRoleExist(){
        RoleEntity role = new RoleEntity();
        role.setName("CUSTOMER");
        return roleRepository.save(role);
    }

    @Override
    public CustomerEntity updateCustomer(int id, CustomerDTO customerDTO) {
        CustomerEntity customerEntity = customerRepository.findById(id);

        if(customerEntity != null){
            customerEntity.setEmail(customerDTO.getEmail());
            customerEntity.setPassword(passwordEncoder.encode(customerDTO.getPassword()));
            customerEntity.setFirstName(customerDTO.getFirstName());
            customerEntity.setLastName(customerDTO.getLastName());
            customerEntity.setDob(customerDTO.getDob());
            customerEntity.setGender(customerDTO.getGender());

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

    @Override
    public List<CustomerEntity> getCustomerByRoleId(int id) {
        RoleEntity role = roleRepository.findById(id);

        int roleID = role.getId();

        return customerRepository.findByRoleCustomer_Id(roleID);
    }
}
