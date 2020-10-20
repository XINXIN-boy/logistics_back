package com.itqf.service;

import com.itqf.commen.JsonMessage;
import com.itqf.entity.Employee;

/**
 * projectName:logistics_back
 *
 * @author: 三毛
 * time:2020/10/718:51
 * description:
 */
public interface EmployeeService {

    void insertEmployee(Employee employee);

    void deleteEmployee(String employeeCode);

    void updateEmployee(Employee employee);

    JsonMessage findAll(int page, int limit);

    JsonMessage findEmployeeByCode(String employeeCode);
}
