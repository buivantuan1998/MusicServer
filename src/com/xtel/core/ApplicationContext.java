package com.xtel.core;

import com.xtel.core.sys.dao.customer.CustomerDao;
import com.xtel.core.sys.dao.customer.impl.CustomerDaoImpl;
import com.xtel.core.sys.service.customer.CustomerService;
import com.xtel.core.sys.service.customer.impl.CustomerServiceImpl;

public class ApplicationContext {
    public static CustomerService customerService;
    public static CustomerDao customerDao;

    public void configure(){
        customerService = new CustomerServiceImpl();
        customerDao = new CustomerDaoImpl();
    }
}
