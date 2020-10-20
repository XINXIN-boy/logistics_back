package com.itqf.controller;

import com.itqf.commen.JsonMessage;
import com.itqf.entity.Cargoreceipt;
import com.itqf.entity.Cargoreceiptdetail;
import com.itqf.service.CargoreceiptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * projectName:logistics_back
 *
 * @author: 三毛
 * time:2020/10/916:12
 * description:
 */
@RestController
@RequestMapping("/vehicle")
public class VehicleController {

    /**
     * 货运收据 的业务
     */
    @Autowired
    private CargoreceiptService cargoreceiptService ;

    /**
     * 填写货运回执单主表
     */
    @RequestMapping(value = "/addCargoreceipt.do")
    public JsonMessage addCargoreceipt(Cargoreceipt cargoReceipt) {
        JsonMessage jsonMessage = new JsonMessage();
        try {
            cargoreceiptService.insertCargoreceipt(cargoReceipt);
            jsonMessage.setCode(0);
            jsonMessage.setMsg("添加成功！");
        } catch (RuntimeException e) {
            jsonMessage.setCode(1);
            jsonMessage.setMsg(e.getMessage());
        }
        return  jsonMessage ;
    }
    /**
     * 提交货运回执单
     */
    @RequestMapping("/submitCargoreceipt.do")
    public JsonMessage submitCargoreceipt(Cargoreceipt cargoReceipt) {
        JsonMessage jsonMessage = new JsonMessage();
        cargoreceiptService.submit(cargoReceipt);

        return jsonMessage ;
    }
    /**
     * 修改货运回执单
     */
    @RequestMapping("/updateCargoreceipt.do")
    public JsonMessage updateCargoreceipt(Cargoreceipt cargoReceipt) {
        JsonMessage jsonMessage = new JsonMessage();
        try {
            cargoreceiptService.updateCargoreceipt(cargoReceipt);
            jsonMessage.setCode(0);
            jsonMessage.setMsg("更新成功！");
        } catch (RuntimeException e) {
            jsonMessage.setCode(1);
            jsonMessage.setMsg(e.getMessage());
        }
        return  jsonMessage ;
    }


    /**
     * 删除货运回执单
     */
    @RequestMapping("/deleteCargoreceipt.do")
    public JsonMessage deleteCargoreceipt(String goodsRevertBillCode) {
        JsonMessage jsonMessage = new JsonMessage();
        try {
            cargoreceiptService.deleteCargoreceipt(goodsRevertBillCode);
            jsonMessage.setCode(0);
            jsonMessage.setMsg("删除成功！");
        } catch (RuntimeException e) {
            jsonMessage.setCode(1);
            jsonMessage.setMsg(e.getMessage());
        }
        return  jsonMessage ;
    }

    /**
     * 查找某一个司机的所有货运合同
     * @param driverId
     * @return
     */
    @RequestMapping( "/findAllCargoreceiptByDriverId.do")
    public JsonMessage findCargoreceiptByDriverId(String driverId, int page, int limit) {
        JsonMessage jsonMessage = cargoreceiptService.findAllCargoreceiptByDriverId(driverId ,page,limit);
        return jsonMessage;
    }

    /**
     * 通过 id 和状态查询司机的所有未到运单
     * @param driverId
     * @param backBillState
     * @param page
     * @param limit
     * @return
     */
    @RequestMapping(value = "/findAllCargoreceiptByDriverIdAndBackBillState.do", method = RequestMethod.GET)
    public JsonMessage findByDriverId(String driverId,String backBillState,int page,int limit) {
        JsonMessage jsonMessage = cargoreceiptService.findAllCargoreceiptByDriverIdAndBackBillState(driverId, backBillState, page ,limit);
        return jsonMessage;

    }

    /**
     *  查询货运回执单 根据 票据
     * @param goodsBillCode
     * @return
     */
    @RequestMapping("/findCargoreceiptdetailByGoodsBillCode.do")
    public JsonMessage findCargoreceiptdetailByGoodsBillCode(String goodsBillCode) {
        JsonMessage jsonMessage = new JsonMessage();
        try {
            Cargoreceiptdetail cargoReceiptDetail = cargoreceiptService.findCargoreceiptdetailByGoodsBillCode(goodsBillCode);
            jsonMessage.setCode(0);
            jsonMessage.setMsg("查询成功！");
            jsonMessage.setData(cargoReceiptDetail);
        } catch (RuntimeException e) {
            jsonMessage.setCode(1);
            jsonMessage.setMsg(e.getMessage());
        }
        return jsonMessage ;
    }

    /**
     * 查询运单状态
     */
    @RequestMapping("/findAllCargoreceiptByEvent.do")
    public JsonMessage findAllCargoreceiptByEvent(String backBillState, @RequestParam("page") int page, @RequestParam("limit") int limit) {
        JsonMessage jsonMessage =
                cargoreceiptService.findAllCargoreceiptByEvent(backBillState ,page,limit);
        return jsonMessage ;
    }

    /**
     * 通过id查询单个货运单
     */
    @RequestMapping("/findCargoReceiptBygoodsRevertBillCode.do")
    public JsonMessage findCargoReceiptBygoodsRevertBillCode(String goodsRevertBillCode) {
        JsonMessage jsonMessage = new JsonMessage();

        try {
            Cargoreceipt cargoReceipt = cargoreceiptService.findCargoReceiptBygoodsRevertBillCode(goodsRevertBillCode);
            jsonMessage.setCode(0);
            jsonMessage.setMsg("查询成功！");
            jsonMessage.setData(cargoReceipt);
        } catch (RuntimeException e) {
            jsonMessage.setCode(1);
            jsonMessage.setMsg(e.getMessage());
        }
        return jsonMessage ;
    }

    /**
     * 查询所有的货运回执单
     * @param page
     * @param limit
     * @return
     */
    @RequestMapping("/findAllCargoreceipt.do")
    public JsonMessage findAllCargoreceipt(int page , int limit){
        JsonMessage jsonMessage =
                cargoreceiptService.findAllCargoreceipt(page,limit);
        return jsonMessage ;
    }

    /**
     * 查询所有的未填写运输合同的 回执
     * @param page
     * @param limit
     * @return
     */
    @RequestMapping("/findAllCargoreceiptdetail.do")
    public JsonMessage findAllCargoreceiptdetail(int page , int limit){
        JsonMessage jsonMessage =
                cargoreceiptService.findAllCargoreceiptdetail(page,limit);
        return jsonMessage ;
    }

    /**
     * 通过货运回执单  查询  客户信息
     * @param goodsRevertBillCode
     * @return
     */
    @RequestMapping("/findGoodsBillByCode.do")
    public JsonMessage findGoodsBillByCode(String goodsRevertBillCode ){
        JsonMessage jsonMessage =
                cargoreceiptService.findGoodsBillByCode(goodsRevertBillCode);
        return jsonMessage ;
    }

















}
