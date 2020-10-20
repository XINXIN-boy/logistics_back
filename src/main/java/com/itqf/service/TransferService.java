package com.itqf.service;

import com.itqf.commen.JsonMessage;
import com.itqf.entity.Customerreceiptinfo;
import com.itqf.entity.Goodsbill;
import com.itqf.entity.Transfercominfo;
import com.itqf.entity.Transferinfo;

import java.util.List;

/**
 * projectName:logistics_back
 *
 * @author: 三毛
 * time:2020/10/1717:44
 * description:
 */
public interface TransferService {

    List<Goodsbill> selectArriveGoods(int page, int limit, String driverId);

    void addTransfer(Transfercominfo transfercominfo);


    List<Transfercominfo> findByPage(int page, int limit);

    List<Transfercominfo> findAllcominfo();


    Transfercominfo findById(String id);

    void addTransferinfo(Transferinfo transferinfo);

    List<Goodsbill> findTransferGoods(int page, int limit, String type, String driverId);

    List<Transferinfo> findInfoByPage(int page, int limit);

    List<Goodsbill> findOnWayBills(String billType, int page, int limit);

}
