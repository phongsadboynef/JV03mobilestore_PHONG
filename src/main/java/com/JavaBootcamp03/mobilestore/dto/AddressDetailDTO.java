package com.JavaBootcamp03.mobilestore.dto;

import lombok.Data;
import java.io.Serializable;

@Data
public class AddressDetailDTO implements Serializable {
    private int id;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String district;
    private String ward;
    private String country;
    private String postalCode;
    private String phoneNumber;
}
