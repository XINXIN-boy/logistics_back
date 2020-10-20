package com.itqf.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itqf.commen.JsonMessage;
import com.itqf.dao.BillDao;
import com.itqf.dao.CargoreceiptDao;
import com.itqf.dao.GoodsBillDao;
import com.itqf.dao.RouteDao;
import com.itqf.entity.*;
import com.itqf.service.CargoreceiptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * projectName:logistics_back
 *
 * @author: 三毛
 * time:2020/10/916:16
 * description:
 */
@Service
public class CargoreceiptServiceImpl implements CargoreceiptService {

    @Autowired
    private CargoreceiptDao cargoreceiptDao ;

    @Autowired
    private RouteDao routeDao ;

    @Autowired
    private GoodsBillDao goodsBillDao ;

    @Autowired
    private BillDao billDao ;

    @Transactional
    @Override
    public void insertCargoreceipt(Cargoreceipt cargoReceipt) {
       int rows =  cargoreceiptDao.insertCargoreceipt(cargoReceipt);

       if (rows == 0){
           throw new RuntimeException("添加失败！");
       }

//        // 更新货运单中的中转地和中转费信息
//        String loadStation = cargoReceipt.getLoadStation();
//        String dealGoodsStation = cargoReceipt.getDealGoodsStation();

//        long startStation = routeDao.findRegionByCity(loadStation).getId();
//        long endStation = routeDao.findRegionByCity(dealGoodsStation).getId();
//
//        List<Routeinfo> routeList = routeDao.findRouteInfoByStartStationAndEndStation(startStation, endStation);
//
//        String passStation = routeList.get(0).getPassStation();
//        for (int i = 1; i < routeList.size(); i++) {
//            String temp = routeList.get(i).getPassStation();
//            passStation = (temp.length() < passStation.length() ? temp : passStation);
//        }
//        String[] pass_station = passStation.split(",");

        String goodsBillCode = cargoreceiptDao.findByGoodsRevertBillId(cargoReceipt.getGoodsRevertBillCode()).getGoodsBillDetailId();
        Goodsbill goodsBill = goodsBillDao.findGoodsBillByCode(goodsBillCode);
        double transfer_fee = 1.3 * 10;
        goodsBill.setTransferFee(transfer_fee);
//        String result = "";
////        for (int i = 0; i < pass_station.length; i++) {
////            String station_name = routeDao.findRegionById(Integer.valueOf(pass_station[i])).getCity();
////            result += (i == 0 ? "" : ",");
////            result += station_name;
////        }
        goodsBill.setTransferStation("result");
        int rows1 = goodsBillDao.updateGoodsBill(goodsBill);
        if (rows1 == 0){
            throw new RuntimeException("添加失败！") ;
        }
        // 保存单据明细表
        Billinfo billInfo = new Billinfo();
        billInfo.setBillType("货运回执单");
        billInfo.setAcceptStation(cargoReceipt.getAcceptStation());
        billInfo.setBillCode(cargoReceipt.getGoodsRevertBillCode());
        billInfo.setBillState("已填");
        billDao.insertBillinfo(billInfo);
    }

    @Override
    public void updateCargoreceipt(Cargoreceipt cargoReceipt) {
        int rows = cargoreceiptDao.updateRelease(cargoReceipt);
        if (rows == 0 ){
            throw new RuntimeException("更新失败" );
        }
    }

    @Transactional
    @Override
    public void deleteCargoreceipt(String goodsRevertBillCode) {

        Billinfo billInfo = billDao.findBillInfoByBillCode(goodsRevertBillCode);
        billInfo.setBillState("作废");
        int rows = billDao.updateBillInfo(billInfo);
        if (rows == 0){
            throw new RuntimeException("删除失败！");
        }

        Cargoreceipt cargoreceipt = new Cargoreceipt();
        cargoreceipt.setGoodsRevertBillCode(goodsRevertBillCode);
        int rows2 = cargoreceiptDao.updateRelease(cargoreceipt);
        if (rows2 == 0){
            throw new RuntimeException("删除失败！");
        }
    }

    @Override
    public JsonMessage findAllCargoreceiptByDriverId(String driverId, int page, int limit) {
        JsonMessage jsonMessage = new JsonMessage();

        PageHelper.startPage(page,limit);
        List<Cargoreceipt> list =  cargoreceiptDao.findAllCargoreceiptByDriverId(driverId );
        if (list != null && list.size()>0) {
            jsonMessage.setCode(0);
            jsonMessage.setMsg("查询成功！");
            jsonMessage.setData(list);
            jsonMessage.setCount(((Page)list).getTotal());
        }else {
            jsonMessage.setCode(1);
            jsonMessage.setMsg("未查询到数据！");
        }
        return jsonMessage;
    }

    @Override
    public JsonMessage findAllCargoreceiptByDriverIdAndBackBillState(String driverId, String backBillState, int page, int limit) {
        JsonMessage jsonMessage = new JsonMessage();

        PageHelper.startPage(page,limit);
        List<Cargoreceipt> list =  cargoreceiptDao.findAllCargoreceiptByDriverIdAndBackBillState(driverId , backBillState);
        if (list != null && list.size()>0) {
            jsonMessage.setCode(0);
            jsonMessage.setMsg("查询成功！");
            jsonMessage.setData(list);
            jsonMessage.setCount(((Page)list).getTotal());
        }else {
            jsonMessage.setCode(1);
            jsonMessage.setMsg("未查询到数据！");
        }
        return jsonMessage;
    }

    @Override
    public Cargoreceiptdetail findCargoreceiptdetailByGoodsBillCode(String goodsBillCode) {
        Cargoreceiptdetail cargoreceiptdetail = cargoreceiptDao.findByGoodsBillDetailId(goodsBillCode) ;
        if (cargoreceiptdetail != null) {
            return cargoreceiptdetail;
        }else {
            throw new RuntimeException("未找到数据！") ;
        }
    }

    @Override
    public Cargoreceipt findCargoReceiptBygoodsRevertBillCode(String goodsRevertBillCode) {
        Cargoreceipt cargoreceipt = cargoreceiptDao.findCargoReceiptBygoodsRevertBillCode(goodsRevertBillCode) ;
        if (cargoreceipt != null) {
            return cargoreceipt;
        }else {
            throw new RuntimeException("未找到数据！") ;
        }
    }


    @Override
    public JsonMessage findAllCargoreceipt(int page, int limit) {
        JsonMessage jsonMessage = new JsonMessage();

        PageHelper.startPage(page,limit);
        List<Cargoreceipt> list =  cargoreceiptDao.findAllCargoreceipt();
        if (list != null && list.size()>0) {
            jsonMessage.setCode(0);
            jsonMessage.setMsg("查询成功！");
            jsonMessage.setData(list);
            jsonMessage.setCount(((Page)list).getTotal());
        }else {
            jsonMessage.setCode(1);
            jsonMessage.setMsg("未查询到数据！");
        }
        return jsonMessage;
    }

    @Override
    public JsonMessage findAllCargoreceiptdetail(int page, int limit) {
        JsonMessage jsonMessage = new JsonMessage();

        PageHelper.startPage(page,limit);
        List<Cargoreceiptdetail> list =  cargoreceiptDao.findAllCargoreceiptdetail();
        if (list != null && list.size()>0) {
            jsonMessage.setCode(0);
            jsonMessage.setMsg("查询成功！");
            jsonMessage.setData(list);
            jsonMessage.setCount(((Page)list).getTotal());
        }else {
            jsonMessage.setCode(1);
            jsonMessage.setMsg("未查询到数据！");
        }
        return jsonMessage;
    }

    @Override
    public JsonMessage findAllCargoreceiptByEvent(String backBillState, int page, int limit) {
        JsonMessage jsonMessage = new JsonMessage();
        if ("".equals(backBillState)){
            backBillState = null ;
        }
        PageHelper.startPage(page,limit);
        List<Cargoreceipt> list =  cargoreceiptDao.findAllCargoreceiptByEvent(backBillState);
        if (list != null && list.size()>0) {
            jsonMessage.setCode(0);
            jsonMessage.setMsg("查询成功！");
            jsonMessage.setData(list);
            jsonMessage.setCount(((Page)list).getTotal());
        }else {
            jsonMessage.setCode(1);
            jsonMessage.setMsg("未查询到数据！");
        }
        return jsonMessage;
    }

    @Override
    public JsonMessage findGoodsBillByCode(String goodsRevertBillCode) {
        JsonMessage jsonMessage = new JsonMessage();
        Goodsbill goodsbill =  cargoreceiptDao.findCargoreceiptByCode(goodsRevertBillCode);
        if (goodsbill!=null) {
            jsonMessage.setCode(0);
            jsonMessage.setMsg("查询成功！");
            jsonMessage.setData(goodsbill);
        }else {
            jsonMessage.setCode(1);
            jsonMessage.setMsg("未查询到数据！");
        }
        return jsonMessage;
    }

    @Transactional
    @Override
    public void submit(Cargoreceipt cargoReceipt) {

        cargoReceipt.setBackBillState("未到车辆");
        int rows =  cargoreceiptDao.updateRelease(cargoReceipt);

        if (rows == 0){
            throw new RuntimeException("提交失败！");
        }

        String goodsBillCode = cargoreceiptDao.findByGoodsRevertBillId(cargoReceipt.getGoodsRevertBillCode()).getGoodsBillDetailId();
        Goodsbillevent goodsBillEvent = goodsBillDao.findGoodsBillByEventByGoodsBillCode(goodsBillCode);
        goodsBillEvent.setEventName("未到");

       int rows1 =  goodsBillDao.updateGoodsbillevent(goodsBillEvent);
        if (rows1 == 0){
            throw new RuntimeException("提交失败！");
        }
    }
}
