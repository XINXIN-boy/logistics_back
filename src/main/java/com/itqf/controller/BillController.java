package com.itqf.controller;

import com.itqf.commen.JsonMessage;
import com.itqf.entity.Billrelease;
import com.itqf.entity.Goodsreceiptinfo;
import com.itqf.service.BillService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * projectName:logistics_back
 *
 * @author: 三毛
 * time:2020/10/810:34
 * description:
 */
@RestController
@RequestMapping("/bill")
public class BillController {

    @Autowired
    private BillService billService ;

    /**
     * 添加数据分发信息
     * @param billCode
     * @param billRelease
     * @return
     */
    @RequestMapping("/addBillRelease.do")
    public JsonMessage addRelease(String billCode, Billrelease billRelease) {
        JsonMessage jsonMessage = new JsonMessage();
        try {
            billService.addBillRelease(billRelease);
            jsonMessage.setCode(0);
            jsonMessage.setMsg("添加成功");
        } catch (RuntimeException e) {
            jsonMessage.setCode(1);
            jsonMessage.setMsg(e.getMessage());
        }
        return jsonMessage ;
    }

    /**
     *添加回执单
     * @param goodsRevertCode
     * @param goodsReceiptInfo
     * @return
     */
    @RequestMapping("/addGoodsReceiptInfo.do")
    public JsonMessage addGoodsReceiptInfo( String goodsRevertCode, Goodsreceiptinfo goodsReceiptInfo) {
        JsonMessage jsonMessage = new JsonMessage();

        try {
            billService.addGoodsReceiptInfo(goodsReceiptInfo);
            jsonMessage.setCode(0);
            jsonMessage.setMsg("添加成功");
        } catch (RuntimeException e) {
            jsonMessage.setCode(1);
            jsonMessage.setMsg(e.getMessage());
        }
        return jsonMessage ;
    }


    /**
     * 查询未分发的运单信息
     * @param page
     * @param limit
     * @return
     */
    @RequestMapping(value = "/findAllNotRelease.do")
    public JsonMessage findAllNotRelease(int page, int limit) {
        JsonMessage jsonMessage = billService.findNotRelease(page , limit);
        return jsonMessage ;
    }
    /**
     * 分页查询suoyiou 单据信息
     * @param page
     * @param limit
     * @return
     */
    @RequestMapping("/findAll.do")
    public JsonMessage findAll(int page , int limit ){
        JsonMessage jsonMessage = billService.findAll(page , limit);
        return jsonMessage ;
    }

}
