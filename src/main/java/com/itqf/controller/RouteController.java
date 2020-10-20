package com.itqf.controller;

import com.itqf.commen.JsonMessage;
import com.itqf.entity.Cityexpand;
import com.itqf.entity.Region;
import com.itqf.entity.Routeinfo;
import com.itqf.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Jsp;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.spring.web.json.Json;

import java.util.List;

/**
 * projectName:logistics_back
 *
 * @author: 三毛
 * time:2020/10/716:05
 * description: 线路的控制层
 */
@RestController
@RequestMapping("/route")
public class RouteController {

    @Autowired
     private RouteService routeService ;

    /**
     * 扩展城市
     * @param cityexpand
     * @return
     */
    @RequestMapping("/addExpand.do")
    public JsonMessage addExpand(Cityexpand cityexpand){
        JsonMessage jsonMessage = new JsonMessage();
        try {
            routeService.insertCityexpand(cityexpand) ;
            jsonMessage.setCode(0);
            jsonMessage.setMsg("添加成功");
        } catch (RuntimeException e) {
            jsonMessage.setCode(1);
            jsonMessage.setMsg(e.getMessage());
        }
        return  jsonMessage ;
    }

    @RequestMapping("/deleteRegions.do")
    public JsonMessage deleteRegions(int id){
        JsonMessage jsonMessage = new JsonMessage();

        try {
            routeService.deleteRegions(id) ;
            jsonMessage.setCode(0);
            jsonMessage.setMsg("删除");
        } catch (RuntimeException e) {
            jsonMessage.setCode(1);
            jsonMessage.setMsg(e.getMessage());
        }

        return  jsonMessage ;
    }
    /**
     * 更新扩展
     * @param cityexpand
     * @return
     */
    @RequestMapping("/updateCityexpand.do")
     public JsonMessage updateCityexpand(Cityexpand cityexpand){
        JsonMessage jsonMessage = new JsonMessage();

        try {
            routeService.updateCityexpand(cityexpand) ;
            jsonMessage.setCode(0);
            jsonMessage.setMsg("修改成功");
        } catch (RuntimeException e) {
            jsonMessage.setCode(1);
            jsonMessage.setMsg(e.getMessage());
        }

        return  jsonMessage ;
     }
    /**
     * 查询所有没有范围的城市
     * @return
     */
    @RequestMapping("/findLeftRegions.do")
    public JsonMessage findLeftRegions(){
        JsonMessage jsonMessage = new JsonMessage();

        List<Region> list  = routeService.findLeftRegions();

        if (list != null && list.size()>0) {
            jsonMessage.setData(list);
            jsonMessage.setMsg("查询成功");
            jsonMessage.setCode(0);
        }else {
            jsonMessage.setMsg("未查询到数据");
            jsonMessage.setCode(1);
        }
        return  jsonMessage ;
    }
    @RequestMapping("/findAll.do")
    public JsonMessage findAll(){
        JsonMessage jsonMessage = new JsonMessage();

        List<Routeinfo> list  = routeService.findAll();

        if (list != null && list.size()>0) {
            jsonMessage.setData(list);
            jsonMessage.setMsg("查询成功");
            jsonMessage.setCode(0);
        }else {
            jsonMessage.setMsg("未查询到数据");
            jsonMessage.setCode(1);
        }
        return  jsonMessage ;
    }
    @RequestMapping("/findExpand.do")
    public JsonMessage findExpand(int id){
        JsonMessage jsonMessage = new JsonMessage();
        Cityexpand cityexpand = routeService.findExpand(id) ;

        if (cityexpand!= null){
            jsonMessage.setCode(0);
            jsonMessage.setMsg("查询成功");
            jsonMessage.setData(cityexpand);
        }else {
            jsonMessage.setCode(1);
            jsonMessage.setMsg("未查询到数据");
        }


        return jsonMessage ;
    }
    /**
     * 查询所有的区域
     * @return
     */
    @RequestMapping("/findAllRegions.do")
    public JsonMessage findAllRegions (){
        JsonMessage jsonMessage = new JsonMessage();
        List<Region> list =  routeService.findAllRegions();

        if (list != null && list.size()>0) {
            jsonMessage.setData(list);
            jsonMessage.setMsg("查询成功");
            jsonMessage.setCode(0);
        }else {
            jsonMessage.setMsg("未查询到数据");
            jsonMessage.setCode(1);
        }
        return  jsonMessage ;
    }

    /**
     *查询所有扩展城市
     * @return
     */
    @RequestMapping("/findAllExpands.do")
    public JsonMessage findAllExpands(int page , int limit){
        JsonMessage jsonMessage =  routeService.findAllExpands(page , limit);
        return  jsonMessage ;
    }
}
