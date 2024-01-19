package com.JavaBootcamp03.mobilestore.dto;

import lombok.Data;
import java.io.Serializable;

@Data
public class CustomerDTO implements Serializable {
    private int id;
    private String email;
    private String password;
    private String custFirstName;
    private String custLastName;
    private String custDOB;
    private int custGender;
}
