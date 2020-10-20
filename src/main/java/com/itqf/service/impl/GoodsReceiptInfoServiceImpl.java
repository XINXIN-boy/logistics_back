package com.itqf.service.impl;

import com.itqf.dao.GoodsreceiptinfoDao;
import com.itqf.entity.Goodsreceiptinfo;
import com.itqf.service.GoodsReceiptInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * projectName:logistics_back
 *
 * @author: 三毛
 * time:2020/10/1719:41
 * description:
 */
@Service
public class GoodsReceiptInfoServiceImpl implements GoodsReceiptInfoService {
    @Autowired
    private GoodsreceiptinfoDao goodsreceiptinfoDao;
    @Override
    public void addArrived(Goodsreceiptinfo goodsreceiptinfo) {
        goodsreceiptinfoDao.insertGoodsReceiptInfo(goodsreceiptinfo);
    }
}
