package com.xtel.core.sys.service.customer;

import com.xtel.core.sys.dto.request.customer.LoginRequest;
import com.xtel.core.sys.dto.response.customer.LoginCustomerResponse;

public interface CustomerService {
    LoginCustomerResponse login(LoginRequest request);
}
