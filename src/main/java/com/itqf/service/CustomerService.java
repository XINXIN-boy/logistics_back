package com.itqf.service;

import com.itqf.commen.JsonMessage;
import com.itqf.entity.Customerinfo;

/**
 * projectName:logistics_back
 *
 * @author: 三毛
 * time:2020/10/619:52
 * description:
 */
public interface CustomerService {
    void insertCustomer(Customerinfo customerinfo);

    JsonMessage findAll(int page, int limit);

    void deleteCustomer(String customerCode);

    JsonMessage findCustomerByCode(String customerCode);

    void updateCustomerInfo(Customerinfo customerinfo);
}
