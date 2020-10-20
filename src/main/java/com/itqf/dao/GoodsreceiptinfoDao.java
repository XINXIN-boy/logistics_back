package com.itqf.dao;

import com.itqf.entity.Goodsreceiptinfo;
import org.springframework.stereotype.Repository;

/**
 * projectName:logistics_back
 *
 * @author: 三毛
 * time:2020/10/914:03
 * description:
 */
@Repository
public interface GoodsreceiptinfoDao {
    //
    public void insertGoodsReceiptInfo(Goodsreceiptinfo goodsReceiptInfo);

}
