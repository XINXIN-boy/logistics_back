package com.itqf.controller;

import com.itqf.commen.JsonMessage;
import com.itqf.entity.Driverinfo;
import com.itqf.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * projectName:logistics_back
 *
 * @author: 三毛
 * time:2020/10/621:47
 * description:
 */
@RestController
@RequestMapping("/driver")
public class DriverController {

    @Autowired
    private DriverService driverService ;

    @RequestMapping("/addDriver.do")
    public JsonMessage addDriver(Driverinfo driverinfo){
        JsonMessage jsonMessage = new JsonMessage();
        try {
            driverService.insertDriver(driverinfo);
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
                driverService.findAll(page , limit);
        return jsonMessage ;
    }


    @RequestMapping("/deleteDriver.do")
    public JsonMessage deleteDriver(String id){
        JsonMessage jsonMessage = new JsonMessage();
        try {
            driverService.deleteDriver(id);
            jsonMessage.setCode(0);
            jsonMessage.setMsg("删除成功");
        } catch (RuntimeException e) {
            jsonMessage.setCode(1);
            jsonMessage.setMsg(e.getMessage());
        }
        return  jsonMessage ;
    }


    @RequestMapping("/findDriverByCode.do")
    public JsonMessage findDriverByCode(String id){
        JsonMessage jsonMessage  =
                driverService.findDriverByCode(id);
        return  jsonMessage ;
    }

    @RequestMapping("/updateDriver.do")
    public JsonMessage updateDriver(Driverinfo driverinfo){
        JsonMessage jsonMessage = new JsonMessage();
        try {
            driverService.updateDriver(driverinfo);
            jsonMessage.setCode(0);
            jsonMessage.setMsg("修改成功");
        } catch (RuntimeException e) {
            jsonMessage.setCode(1);
            jsonMessage.setMsg(e.getMessage());
        }
        return  jsonMessage ;
    }

}
