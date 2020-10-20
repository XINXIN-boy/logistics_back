package com.itqf.controller;

import com.itqf.commen.JsonMessage;
import com.itqf.entity.Employee;
import com.itqf.service.EmployeeService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * projectName:logistics_back
 *
 * @author: 三毛
 * time:2020/10/718:43
 * description:
 */
@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService ;

    @RequestMapping("/addEmployee.do")
    public JsonMessage addEmployee(Employee employee){
        JsonMessage jsonMessage = new JsonMessage();

        try {
            employeeService.insertEmployee(employee);
            jsonMessage.setCode(0);
            jsonMessage.setMsg("添加成功");
        } catch (RuntimeException e) {
            jsonMessage.setCode(1);
            jsonMessage.setMsg(e.getMessage());
        }
        return jsonMessage ;
    }
    @RequestMapping("/deleteEmployee.do")
    public JsonMessage deleteEmployee(String employeeCode){
        JsonMessage jsonMessage = new JsonMessage();

        try {
            employeeService.deleteEmployee(employeeCode);
            jsonMessage.setCode(0);
            jsonMessage.setMsg("删除成功");
        } catch (RuntimeException e) {
            jsonMessage.setCode(1);
            jsonMessage.setMsg(e.getMessage());
        }
        return jsonMessage ;
    }
    @RequestMapping("/updateEmployee.do")
    public JsonMessage updateEmployee(Employee employee){
        JsonMessage jsonMessage = new JsonMessage();

        try {
            employeeService.updateEmployee(employee);
            jsonMessage.setCode(0);
            jsonMessage.setMsg("修改成功");
        } catch (RuntimeException e) {
            jsonMessage.setCode(1);
            jsonMessage.setMsg(e.getMessage());
        }
        return jsonMessage ;
    }
    @RequestMapping("/findAll.do")
    public JsonMessage findAll(int page , int limit){
        JsonMessage jsonMessage = employeeService.findAll(page ,limit);

        return jsonMessage ;
    }
    @RequestMapping("/findEmployeeByCode.do")
    public JsonMessage findEmployeeByCode(String employeeCode){
        JsonMessage jsonMessage = employeeService.findEmployeeByCode(employeeCode);
        return jsonMessage ;
    }

}
