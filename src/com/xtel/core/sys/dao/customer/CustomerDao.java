package com.xtel.core.sys.dao.customer;

import com.xtel.core.sys.dto.response.customer.LoginCustomerResponse;

public interface CustomerDao {
     LoginCustomerResponse getInfoAccount(String phone_number, String password);
}
