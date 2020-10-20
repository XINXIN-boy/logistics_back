package com.itqf.controller;

import com.itqf.commen.JsonMessage;
import com.itqf.entity.Cargoreceiptdetail;
import com.itqf.entity.Goodsbill;
import com.itqf.service.GoodsBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * projectName:logistics_back
 *
 * @author: 三毛
 * time:2020/10/811:09
 * description:
 */
@RestController
@RequestMapping("/goodsBill")
public class GoodsBillController {

    @Autowired
    private GoodsBillService goodsBillService ;

    @RequestMapping("/addGoodsBill.do")
    public JsonMessage addGoodsBill(Goodsbill goodsbill){
        JsonMessage jsonMessage = new JsonMessage();
        try {
            String goodsBillCode = goodsBillService.addGoodsBill(goodsbill);
            jsonMessage.setCode(0);
            jsonMessage.setMsg("添加成功");
            jsonMessage.setData(goodsBillCode);
        } catch (RuntimeException e) {
            jsonMessage.setCode(1);
            jsonMessage.setMsg(e.getMessage());
        }
        return jsonMessage ;
    }
    @RequestMapping("/addGoods.do")
    public JsonMessage addGoods(Cargoreceiptdetail cargoreceiptdetail , String goodsBillCode){
        JsonMessage jsonMessage = new JsonMessage();
        try {
            goodsBillService.addGoods(cargoreceiptdetail , goodsBillCode);
            jsonMessage.setCode(0);
            jsonMessage.setMsg("添加成功");
        } catch (RuntimeException e) {
            jsonMessage.setCode(1);
            jsonMessage.setMsg(e.getMessage());
        }
        return jsonMessage ;
    }
    @RequestMapping("/deleteGoodsBill.do")
    public JsonMessage deleteGoodsBill(String goodsBillCode){
        JsonMessage jsonMessage = new JsonMessage();
        try {
            goodsBillService.deleteGoodsBill(goodsBillCode);
            jsonMessage.setCode(0);
            jsonMessage.setMsg("删除成功");
        } catch (RuntimeException e) {
            jsonMessage.setCode(1);
            jsonMessage.setMsg(e.getMessage());
        }
        return jsonMessage ;
    }

    @RequestMapping("/updateGoodsBill.do")
    public JsonMessage updateGoodsBill(Goodsbill goodsbill){
        JsonMessage jsonMessage = new JsonMessage();
        try {
            goodsBillService.updateGoodsBill(goodsbill);
            jsonMessage.setCode(0);
            jsonMessage.setMsg("更新成功");
        } catch (RuntimeException e) {
            jsonMessage.setCode(1);
            jsonMessage.setMsg(e.getMessage());
        }
        return jsonMessage ;
    }

    /**
     * 删除  但是不删除数据库 修改状态
     * @param goodsBillCode
     * @return
     */
    @RequestMapping("/updateDel.do")
    public JsonMessage updateDel(String goodsBillCode){
        JsonMessage jsonMessage = new JsonMessage();
        try {
            goodsBillService.updateDel(goodsBillCode);
            jsonMessage.setCode(0);
            jsonMessage.setMsg("删除成功");
        } catch (RuntimeException e) {
            jsonMessage.setCode(1);
            jsonMessage.setMsg(e.getMessage());
        }
        return jsonMessage ;
    }


    @RequestMapping("/findAllGoodsBill.do")
    public JsonMessage findAllGoodsBill(int page , int limit){
        JsonMessage jsonMessage = goodsBillService.findAllGoodsBill(page , limit);
        return jsonMessage ;
    }

    @RequestMapping("/findGoodsBillByCode.do")
    public JsonMessage findGoodsBillByCode(String goodsBillCode){
        JsonMessage jsonMessage = new JsonMessage();
        Goodsbill goodsbill = goodsBillService.findGoodsBillByCode(goodsBillCode);

        if (goodsbill != null ){
            jsonMessage.setCode(0);
            jsonMessage.setMsg("查询成功");
            jsonMessage.setData(goodsbill);
        }else {
            jsonMessage.setCode(0);
            jsonMessage.setMsg("未查询到数据");
        }
        return jsonMessage ;
    }

    @RequestMapping("/findGoodsBillByEvent.do")
    public JsonMessage findGoodsBillByEvent(String eventName , int page , int limit){
        JsonMessage jsonMessage = goodsBillService.findGoodsBillByEvent(eventName , page , limit);
        return jsonMessage ;
    }

    @RequestMapping("/findAllGoodsBillByEvent.do")
    public JsonMessage findAllGoodsBillByEvent(int page , int limit){
        JsonMessage jsonMessage = goodsBillService.findAllGoodsBillByEvent(page , limit);
        return jsonMessage ;
    }
}
