package com.itqf.dao;

import com.itqf.entity.Employee;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * projectName:logistics_back
 *
 * @author: 三毛
 * time:2020/10/718:54
 * description:
 */
@Repository
public interface EmployeeDao {
    int insertEmployee(Employee employee);

    int deleteEmployee(String employeeCode);

    int updateEmployee(Employee employee);

    List<Employee> findAll();

    Employee findEmployeeByCode(String employeeCode);
}
