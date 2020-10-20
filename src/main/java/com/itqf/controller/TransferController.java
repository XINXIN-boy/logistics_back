package com.itqf.controller;

import com.github.pagehelper.Page;
import com.itqf.commen.JsonMessage;
import com.itqf.entity.*;
import com.itqf.service.GoodsReceiptInfoService;
import com.itqf.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.spring.web.json.Json;

import javax.xml.bind.util.JAXBSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * projectName:logistics_back
 *
 * @author: 三毛
 * time:2020/10/1717:21
 * description: 中转
 */
@RestController
@RequestMapping("/transfer")
public class TransferController {

    @Autowired
    private TransferService transferService;
    @Autowired
    private GoodsReceiptInfoService goodsReceiptInfoService;

    @RequestMapping("/arriveGoods")
    public JsonMessage selectArriveGoods(int page, int limit, String driverId){
        JsonMessage jsonMessage = new JsonMessage();
        List<Goodsbill> list = transferService.selectArriveGoods(page,limit,driverId);
        long total = ((Page) list).getTotal();
        jsonMessage.setCode(0);
        jsonMessage.setData(list);
        jsonMessage.setCount(total);
        return jsonMessage;
    }

    @RequestMapping("/addArrived")
    public JsonMessage addArrived(Goodsreceiptinfo goodsreceiptinfo){
        JsonMessage jsonMessage = new JsonMessage();
        goodsReceiptInfoService.addArrived(goodsreceiptinfo);
        jsonMessage.setCode(0);
        jsonMessage.setMsg("添加成功");
        return jsonMessage ;
    }

    @RequestMapping("/add")
    public JsonMessage addTransfer(Transfercominfo transfercominfo){
        JsonMessage jsonMessage = new JsonMessage();
        transferService.addTransfer(transfercominfo);
        jsonMessage.setCode(0);
        jsonMessage.setMsg("添加成功");
        return jsonMessage ;
    }

    @RequestMapping("/findByPage")
    public JsonMessage findByPage(int page,int limit){
        JsonMessage jsonMessage = new JsonMessage();
        List<Transfercominfo> list = transferService.findByPage(page,limit);
        long total = ((Page) list).getTotal();
        jsonMessage.setCode(0);
        jsonMessage.setData(list);
        jsonMessage.setCount(total);
        return jsonMessage;
    }

    @RequestMapping("/findcominfo")
    public JsonMessage findTransfercominfo(){
        JsonMessage jsonMessage = new JsonMessage();
        List<Transfercominfo> list = transferService.findAllcominfo();
        jsonMessage.setCode(0);
        jsonMessage.setData(list);
        return jsonMessage ;
    }

    @RequestMapping("/selectcominfo")
    public JsonMessage findById(String id){
        JsonMessage jsonMessage = new JsonMessage();
        System.out.println("id--" + id);
        Transfercominfo transfercominfo = transferService.findById(id);
        jsonMessage.setCode(0);
        jsonMessage.setData(transfercominfo);
        return jsonMessage;
    }

    @RequestMapping("/addInfo")
    public JsonMessage addTransferinfo(Transferinfo transferinfo){
        JsonMessage jsonMessage = new JsonMessage();
        transferService.addTransferinfo(transferinfo);
        jsonMessage.setCode(0);
        return jsonMessage;
    }

    @RequestMapping("/transferGoods")
    public JsonMessage findTransferGoods(int page,int limit,String driverId){

        JsonMessage jsonMessage = new JsonMessage();
        List<Goodsbill> list = transferService.findTransferGoods(page,limit,"未到车辆",driverId);
        long total = ((Page) list).getTotal();
        jsonMessage.setCode(0);
        jsonMessage.setData(list);
        jsonMessage.setCount(total);
        return jsonMessage;
    }

    @RequestMapping("/findInfoByPage")
    public JsonMessage findInfoByPage(int page, int limit){



        JsonMessage jsonMessage = new JsonMessage();
        List<Transferinfo> list = transferService.findInfoByPage(page,limit);
        long total = ((Page) list).getTotal();

        jsonMessage.setCode(0);
        jsonMessage.setData(list);
        jsonMessage.setCount(total);
        return jsonMessage;
    }
    @RequestMapping("/findOnWayBills")
    public JsonMessage findOnWayBills(String billType,int page,int limit){
        JsonMessage jsonMessage = new JsonMessage();
        List<Goodsbill> list = transferService.findOnWayBills(billType, page,limit);
        long total = ((Page) list).getTotal();
        jsonMessage.setCode(0);
        jsonMessage.setData(list);
        jsonMessage.setCount(total);
        return jsonMessage;
    }
}
