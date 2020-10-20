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
 * time:2020/10/913:37
 * description:
 */
@Repository
public interface CargoreceiptDao {

    /**
     * 添加货物收据
     * @param cargoReceipt
     * @return
     */
    int insertCargoreceipt(Cargoreceipt cargoReceipt);
    /**
     * 更新
     * @param cargoreceipt
     * @return
     */
    int updateRelease(Cargoreceipt cargoreceipt);

    /**
     * 根据 回执单 查找 货物收据 详情
     * @param goodsRevertBillId
     * @return
     */
    Cargoreceiptdetail findByGoodsRevertBillId(String goodsRevertBillId);

    /**
     * 根据 回执单 查找 货物收据
     * @param goodsRevertBillCode
     * @return
     */
    Cargoreceipt findCargoReceiptBygoodsRevertBillCode(String goodsRevertBillCode);

    /**
     * 根据 回执单 查找 货物票据
     * @param goodsRevertBillCode 回执单
     * @return
     */
    Goodsbill findCargoreceiptByCode(String goodsRevertBillCode);

    /**
     * 根据状态查所有的 货运收据
     * @param backBillState
     * @return
     */
    List<Cargoreceipt> findAllCargoreceiptByEvent(String backBillState);
    /**
     * 查找所有的 货运收据
     * @return
     */
    List<Cargoreceipt> findAllCargoreceipt();
    /**
     * 查找所有的 货运收据主表
     * @return
     */
    List<Cargoreceiptdetail> findAllCargoreceiptdetail();
    /**
     * 根据 票据code 查找所有的 货运收据 详情
     * @param billCode
     * @return
     */
    Cargoreceiptdetail findByGoodsBillDetailId(String billCode);
    /**
     * 根据 司机iD 和 合同状态查找 所有的 货运收据
     * @param driverId
     * @param backBillState
     * @return
     */
    List<Cargoreceipt> findAllCargoreceiptByDriverIdAndBackBillState(@Param("driverId") String driverId,@Param("backBillState") String backBillState);

    /**
     * 根据 司机iD 查找 所有的 货运收据
     * @param driverId
     * @return
     */
    List<Cargoreceipt> findAllCargoreceiptByDriverId(String driverId);



}
