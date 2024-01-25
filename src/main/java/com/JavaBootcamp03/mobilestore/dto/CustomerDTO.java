package com.JavaBootcamp03.mobilestore.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Data
@Getter
@Setter
public class CustomerDTO implements Serializable {
    private int id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private java.sql.Date dob;
    private int gender;
    private RoleDTO roleCustomer;
    private List<AddressDetailDTO> listAddress;
}
