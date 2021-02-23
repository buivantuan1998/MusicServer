package com.xtel.core.sys.dto.request.customer;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class LoginRequest {
    private String phone_number;
    private String password;
}
