package com.JavaBootcamp03.mobilestore.dto;

import lombok.Data;
import java.io.Serializable;

@Data
public class UserDTO implements Serializable {
    private int id;
    private String email;
    private String password;
    private String usrFirstName;
    private String usrLastName;
    private String usrDOB;
    private int usrGender;
}
