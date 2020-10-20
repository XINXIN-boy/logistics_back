package com.itqf.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itqf.commen.JsonMessage;
import com.itqf.dao.*;
import com.itqf.entity.*;
import com.itqf.service.CustomerService;
import com.itqf.service.GoodsBillService;
import com.itqf.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.security.auth.callback.Callback;
import java.util.LinkedList;
import java.util.List;

/**
 * projectName:logistics_back
 *
 * @author: 三毛
 * time:2020/10/1717:47
 * description:
 */
@Service
public class TransferServiceImpl implements TransferService {

    @Autowired
    private GoodsBillDao goodsBillDao;
    @Autowired
    private TransferComInfoDao transferComInfoDao;
    @Autowired
    private TransferDao transferDao;
    @Autowired
    private RouteDao routeDao;
    @Autowired
    private CallbackDao callbackDao;

    @Override
    public List<Goodsbill> selectArriveGoods(int page, int limit, String driverId) {
        PageHelper.startPage(page,limit);
        Cargoreceipt cargoreceipt = new Cargoreceipt();
        cargoreceipt.setBackBillState("未到车辆");
        cargoreceipt.setDriverId(driverId);
        List<Goodsbill> list = goodsBillDao.selectGoodsBill(cargoreceipt);
        return list;
    }

    @Override
    public void addTransfer(Transfercominfo transfercominfo) {
        transferComInfoDao.addTransferconinfo(transfercominfo);
    }

    @Override
    public List<Transfercominfo> findByPage(int page, int limit) {
        PageHelper.startPage(page,limit);
        List<Transfercominfo> list = transferComInfoDao.findByPage();
        return list;
    }

    @Override
    public List<Transfercominfo> findAllcominfo() {
        List<Transfercominfo> list = transferComInfoDao.findByPage();
        return list;
    }

    @Override
    public Transfercominfo findById(String id) {
        Transfercominfo transfercominfo = transferComInfoDao.findById(id);
        return transfercominfo;
    }

    @Override
    public void addTransferinfo(Transferinfo transferinfo) {
        String transferStation = transferinfo.getTransferStation();
        Region byId = routeDao.findRegionByCity(transferStation);
        transferinfo.setTransferStation(byId.getCity());
        transferDao.addTransferinfo(transferinfo);
    }

    @Override
    public List<Goodsbill> findTransferGoods(int page,int limit,String type, String driverId) {
        PageHelper.startPage(page,limit);
        Cargoreceipt cargoreceipt = new Cargoreceipt();
        cargoreceipt.setDriverId(driverId);
        cargoreceipt.setBackBillState(type);
        List<Goodsbill> list = goodsBillDao.selectGoodsBill(cargoreceipt);
        //TODO
        return list;
    }

    @Override
    public List<Transferinfo> findInfoByPage(int page, int limit) {
        PageHelper.startPage(page,limit);
        List<Transferinfo> list = transferDao.findInfoByPage();
        return list;
    }

    @Override
    public List<Goodsbill> findOnWayBills(String billType, int page, int limit) {
        PageHelper.startPage(page,limit);
        List<Goodsbill> list = goodsBillDao.findOnWayBills();
        List<Goodsbill> result = new LinkedList<>();
        for (Goodsbill goodsBill : list) {
//			List<TransferInfo> infos = transferInfoDao.findByGoodsBillCode(goodsBill.getGoodsBillCode());
            Callbackinfo callbackinfo = new Callbackinfo();
            callbackinfo.setBillType("中转回告");
            callbackinfo.setGoodsBillId(goodsBill.getGoodsBillCode());
            Callbackinfo callbackInfo = callbackDao.findByGoodsBillIdAndType(callbackinfo);
//			String[] citys = goodsBill.getTransferStation().split(",");
            if (callbackInfo == null) {
                result.add(goodsBill);
            }
        }
        return result;
    }
}
