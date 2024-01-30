package com.JavaBootcamp03.mobilestore.payload.response;

import lombok.*;

//work flow
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse {
    private Boolean success = Boolean.TRUE;
    private int statusCode = 200;
    private String messsage = "";
    private Object data;
}
