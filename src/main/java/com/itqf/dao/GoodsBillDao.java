package com.itqf.dao;

import com.itqf.entity.Cargoreceipt;
import com.itqf.entity.Cargoreceiptdetail;
import com.itqf.entity.Goodsbill;
import com.itqf.entity.Goodsbillevent;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * projectName:logistics_back
 *
 * @author: 三毛
 * time:2020/10/813:42
 * description:
 */@Repository
public interface GoodsBillDao {
    int addGoodsBill(Goodsbill goodsbill);

    int addGoods(Cargoreceiptdetail cargoreceiptdetail);

    int insertGoodsbillevent(Goodsbillevent goodsbillevent);

    int updateGoodsbillevent(Goodsbillevent goodsbillevent) ;

    int updateGoodsBill(Goodsbill goodsbill) ;

    Goodsbill findGoodsBillByCode(String goodsBillCode);

    Cargoreceiptdetail findCargoreceiptdetailByCode(String goodsRevertBillId);

    Goodsbillevent findGoodsBillByEventByGoodsBillCode(String goodsBillCode);

    List<Goodsbill> findAllGoodsBill();

    List<Goodsbillevent> findGoodsBillByEvent(String eventName);

    List<Goodsbillevent> findAllGoodsBillByEvent();


    List<Goodsbill> findOnWayBills();


    List<Goodsbill> findAllGoodsbillByBackBillStateAndDriverId(String backBillState, String driverId);

    List<Goodsbill> selectGoodsBill(Cargoreceipt cargoreceipt);

}
