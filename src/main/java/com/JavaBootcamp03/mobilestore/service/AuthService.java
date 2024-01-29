package com.JavaBootcamp03.mobilestore.service;


import com.JavaBootcamp03.mobilestore.entity.CustomerEntity;
import com.JavaBootcamp03.mobilestore.repository.CustomerRepository;
import com.JavaBootcamp03.mobilestore.service.serviceInterface.AuthServiceImp;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthService implements AuthServiceImp {
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public CustomerEntity checkLogin(String email, String password) {
        CustomerEntity customerEntity = customerRepository.findByEmail(email);
        //nếu truy vấn có dữ liệu tức user tồn tại
        if(customerEntity != null){
            //kiểm tra password trong database có match với password user truyền lên hay không
            if(passwordEncoder.matches(password,customerEntity.getPassword())){
                return customerEntity;
            }
        }

        return null;
    }
}
