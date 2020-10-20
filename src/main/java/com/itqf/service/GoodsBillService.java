package com.itqf.service;

import com.itqf.commen.JsonMessage;
import com.itqf.entity.Cargoreceiptdetail;
import com.itqf.entity.Goodsbill;

/**
 * projectName:logistics_back
 *
 * @author: 三毛
 * time:2020/10/811:28
 * description:
 */
public interface GoodsBillService {

    String addGoodsBill(Goodsbill goodsbill);

    void addGoods(Cargoreceiptdetail cargoreceiptdetail, String goodsBillCode);

    void deleteGoodsBill(String goodsBillCode);

    void updateGoodsBill(Goodsbill goodsbill);

    void updateDel(String goodsBillCode);

    JsonMessage findAllGoodsBill(int page, int limit);

    Goodsbill findGoodsBillByCode(String goodsBillCode);

    Cargoreceiptdetail findCargoreceiptdetailByCode(String goodsRevertBillId);

    JsonMessage findGoodsBillByEvent(String eventName , int page , int limit);

    JsonMessage findAllGoodsBillByEvent(int page, int limit);
}
