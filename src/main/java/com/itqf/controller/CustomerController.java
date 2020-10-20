package com.itqf.controller;

import com.itqf.commen.JsonMessage;
import com.itqf.entity.Customerinfo;
import com.itqf.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * projectName:logistics_back
 *
 * @author: 三毛
 * time:2020/10/619:38
 * description:
 */
@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService ;

    @RequestMapping("/addCustomer.do")
    public JsonMessage addCustomer(Customerinfo customerinfo){
        JsonMessage jsonMessage = new JsonMessage();
        try {
            customerService.insertCustomer(customerinfo);
            jsonMessage.setCode(0);
            jsonMessage.setMsg("添加成功");
        } catch (RuntimeException e) {
            jsonMessage.setCode(1);
            jsonMessage.setMsg(e.getMessage());
        }
        return  jsonMessage ;
    }

    @RequestMapping("/findAll.do")
    public JsonMessage findAll(int page , int limit){
        JsonMessage jsonMessage  =
                customerService.findAll(page , limit);
        return jsonMessage ;
    }


    @RequestMapping("/deleteCustomer.do")
    public JsonMessage deleteCustomer(String customerCode){
        JsonMessage jsonMessage = new JsonMessage();
        try {
            customerService.deleteCustomer(customerCode);
            jsonMessage.setCode(0);
            jsonMessage.setMsg("删除成功");
        } catch (RuntimeException e) {
            jsonMessage.setCode(1);
            jsonMessage.setMsg(e.getMessage());
        }
        return  jsonMessage ;
    }


    @RequestMapping("/findCustomerByCode.do")
    public JsonMessage findCustomerByCode(String customerCode){
        JsonMessage jsonMessage  =
                customerService.findCustomerByCode(customerCode);
        return  jsonMessage ;
    }

    @RequestMapping("/updateCustomerInfo.do")
    public JsonMessage updateCustomerInfo(Customerinfo customerinfo){
        JsonMessage jsonMessage = new JsonMessage();
        try {
            customerService.updateCustomerInfo(customerinfo);
            jsonMessage.setCode(0);
            jsonMessage.setMsg("修改成功");
        } catch (RuntimeException e) {
            jsonMessage.setCode(1);
            jsonMessage.setMsg(e.getMessage());
        }
        return  jsonMessage ;
    }

}
