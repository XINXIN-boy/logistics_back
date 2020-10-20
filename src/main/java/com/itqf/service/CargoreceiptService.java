package com.itqf.service;

import com.itqf.commen.JsonMessage;
import com.itqf.entity.Cargoreceipt;
import com.itqf.entity.Cargoreceiptdetail;

/**
 * projectName:logistics_back
 *
 * @author: 三毛
 * time:2020/10/916:16
 * description:
 */
public interface CargoreceiptService {

    void insertCargoreceipt(Cargoreceipt cargoReceipt);

    void updateCargoreceipt(Cargoreceipt cargoReceipt);

    void deleteCargoreceipt(String goodsRevertBillCode);

    JsonMessage findAllCargoreceiptByDriverId(String driverId, int page, int limit);

    JsonMessage findAllCargoreceiptByDriverIdAndBackBillState(String driverId, String backBillState, int page, int limit);

    Cargoreceiptdetail findCargoreceiptdetailByGoodsBillCode(String goodsBillCode);

    Cargoreceipt findCargoReceiptBygoodsRevertBillCode(String goodsRevertBillCode);

    JsonMessage findAllCargoreceipt(int page, int limit);

    JsonMessage findAllCargoreceiptdetail(int page, int limit);

    JsonMessage findAllCargoreceiptByEvent(String backBillState, int page, int limit);

    JsonMessage findGoodsBillByCode(String goodsRevertBillCode);

    void submit(Cargoreceipt cargoReceipt);

}
