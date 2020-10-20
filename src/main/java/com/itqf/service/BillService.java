package com.itqf.service;

import com.itqf.commen.JsonMessage;
import com.itqf.entity.Billrelease;
import com.itqf.entity.Goodsreceiptinfo;

/**
 * projectName:logistics_back
 *
 * @author: 三毛
 * time:2020/10/810:36
 * description:
 */
public interface BillService {

    void addBillRelease(Billrelease billRelease);

    void addGoodsReceiptInfo(Goodsreceiptinfo goodsReceiptInfo);

    JsonMessage findNotRelease(int page, int limit);

    JsonMessage findAll(int page, int limit);
}
