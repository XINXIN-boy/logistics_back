package com.itqf.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itqf.commen.JsonMessage;
import com.itqf.dao.BillDao;
import com.itqf.dao.CargoreceiptDao;
import com.itqf.dao.GoodsBillDao;
import com.itqf.dao.GoodsreceiptinfoDao;
import com.itqf.entity.*;
import com.itqf.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * projectName:logistics_back
 *
 * @author: 三毛
 * time:2020/10/810:36
 * description:
 */
@Service
public class BillServiceImpl implements BillService {

    @Autowired
    private BillDao billDao ;

    @Autowired
    private GoodsBillDao goodsBillDao;

    @Autowired
     private CargoreceiptDao cargoreceiptDao ;

    @Autowired
    private GoodsreceiptinfoDao goodsreceiptinfoDao ;

    @Transactional
    @Override
    public void addBillRelease(Billrelease billRelease) {

        billRelease.setBillType("货运单");
        String billCode = billRelease.getBillCode();
        int rows =  billDao.insertRelease(billRelease);
        if (rows == 0){
            throw new RuntimeException("添加失败") ;
        }

        Goodsbillevent goodsbillevent = new Goodsbillevent();
        goodsbillevent.setGoodsBillId(billCode);
        goodsbillevent.setEventName("未到");
        int rows1 = goodsBillDao.updateGoodsbillevent(goodsbillevent);
        if (rows1 == 0){
            throw new RuntimeException("添加失败") ;
        }

        String goodsRevertBillId = cargoreceiptDao.findByGoodsBillDetailId(billCode).getGoodsRevertBillId();
        Cargoreceipt cargoreceipt = new Cargoreceipt();
        cargoreceipt.setStartCarryTime(billRelease.getReceiveBillTime());
        cargoreceipt.setDriverId(billRelease.getReleasePerson());
        cargoreceipt.setBackBillState("未到车辆");
        cargoreceipt.setGoodsRevertBillCode(goodsRevertBillId);
        int rows2 = cargoreceiptDao.updateRelease(cargoreceipt);
        if (rows2 == 0){
            throw new RuntimeException("添加失败") ;
        }
    }

    @Transactional
    @Override
    public void addGoodsReceiptInfo(Goodsreceiptinfo goodsReceiptInfo) {
        String goodsRevertBillId = goodsReceiptInfo.getGoodsRevertCode();

        String billId = cargoreceiptDao.findByGoodsRevertBillId(goodsRevertBillId).getGoodsBillDetailId();
//
        goodsreceiptinfoDao.insertGoodsReceiptInfo(goodsReceiptInfo);


        Goodsbillevent goodsbillevent = new Goodsbillevent();
        goodsbillevent.setGoodsBillId(billId);
        goodsbillevent.setEventName("未结");
        int rows1 = goodsBillDao.updateGoodsbillevent(goodsbillevent);
        if (rows1 == 0){
            throw new RuntimeException("添加失败") ;
        }
//
        Goodsbill goodsbill = new Goodsbill();
        goodsbill.setGoodsBillCode(billId);
        goodsbill.setFactDealDate(goodsReceiptInfo.getRceiveGoodsDate());
        int rows3 = goodsBillDao.updateGoodsBill(goodsbill);
        if (rows3 == 0){
            throw new RuntimeException("添加失败") ;
        }

        Cargoreceipt cargoreceipt = new Cargoreceipt();
        cargoreceipt.setStartCarryTime(goodsReceiptInfo.getRceiveGoodsDate());
        cargoreceipt.setBackBillState("未结合同");
        cargoreceipt.setGoodsRevertBillCode(goodsRevertBillId);
        int rows2 = cargoreceiptDao.updateRelease(cargoreceipt);
        if (rows2 == 0){
            throw new RuntimeException("添加失败") ;
        }

    }

    @Override
    public JsonMessage findNotRelease(int page, int limit) {
        JsonMessage jsonMessage = new JsonMessage();
        PageHelper.startPage(page, limit);
        List<Billinfo> list = billDao.findNotRelease();

        if (list != null && list.size()>0) {
            jsonMessage.setCode(0);
            jsonMessage.setData(list);
            jsonMessage.setCount(((Page)list).getTotal());
            jsonMessage.setMsg("查询成功");
        }else {
            jsonMessage.setCode(1);
            jsonMessage.setMsg("未查询到数据！");
        }
        return jsonMessage ;
    }

    @Override
    public JsonMessage findAll(int page, int limit) {
        JsonMessage jsonMessage = new JsonMessage();
        PageHelper.startPage(page, limit);
        List<Billinfo> list = billDao.findAll();

        if (list != null && list.size()>0) {
            jsonMessage.setCode(0);
            jsonMessage.setData(list);
            jsonMessage.setCount(((Page)list).getTotal());
            jsonMessage.setMsg("查询成功");
        }else {
            jsonMessage.setCode(1);
            jsonMessage.setMsg("未查询到数据！");
        }
        return jsonMessage ;
    }
}
