package com.xtel.core.sys.service.customer.impl;

import com.xtel.core.ApplicationContext;
import com.xtel.core.sys.dao.customer.CustomerDao;
import com.xtel.core.sys.dto.request.customer.LoginRequest;
import com.xtel.core.sys.dto.response.customer.LoginCustomerResponse;
import com.xtel.core.sys.service.customer.CustomerService;

public class CustomerServiceImpl implements CustomerService {
    private CustomerDao customerDao;

    public CustomerServiceImpl(){
        this.customerDao = ApplicationContext.customerDao;
    }

    @Override
    public LoginCustomerResponse login(LoginRequest request) {
        //gui mail otp
        // convert data to jwt
        return customerDao.getInfoAccount(request.getPhone_number(), request.getPassword());
    }
}
