package com.JavaBootcamp03.mobilestore.dto;

import lombok.Data;
import java.io.Serializable;

@Data
public class AddressDTO implements Serializable {
    private int id;
    private String addressName;
}
