package com.xtel.core.sys.dto.response.customer;

import lombok.Data;
import lombok.ToString;

import java.sql.Timestamp;

@Data
@ToString
public class CustomerResponse {
    private String CUSTOMER_NAME;
    private String EMAIL;
    private String FULL_NAME;
    private Timestamp CREATE_TIME;
    private String PHONE_NUMBER;
}
