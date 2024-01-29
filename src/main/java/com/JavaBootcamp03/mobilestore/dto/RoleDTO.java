package com.JavaBootcamp03.mobilestore.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Data
@Setter
@Getter
public class RoleDTO implements Serializable {
    private int id;
    private String name;
}
