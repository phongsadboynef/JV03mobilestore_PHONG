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
    private java.sql.Date custDOB;
    private int custGender;
}
