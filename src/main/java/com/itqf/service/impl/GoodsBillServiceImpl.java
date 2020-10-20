package com.itqf.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itqf.commen.JsonMessage;
import com.itqf.commen.RandomCode;
import com.itqf.dao.BillDao;
import com.itqf.dao.GoodsBillDao;
import com.itqf.entity.Billinfo;
import com.itqf.entity.Cargoreceiptdetail;
import com.itqf.entity.Goodsbill;
import com.itqf.entity.Goodsbillevent;
import com.itqf.service.GoodsBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * projectName:logistics_back
 *
 * @author: 三毛
 * time:2020/10/811:29
 * description:
 */
@Service
public class GoodsBillServiceImpl implements GoodsBillService {

    @Autowired
    private GoodsBillDao goodsBillDao ;

    @Autowired
    private BillDao billDao ;

    private java.sql.Date currentData =  new java.sql.Date(System.currentTimeMillis());

    @Transactional
    @Override
    public String addGoodsBill(Goodsbill goodsbill) {

        String goodsBillCode = "HY" ;

        while (true) {

            goodsBillCode += RandomCode.getCode();

            if (findGoodsBillByCode(goodsBillCode) == null) {
                break;
            }
        }

        goodsbill.setGoodsBillCode(goodsBillCode);
        goodsbill.setValidity(false);
        goodsbill.setIfAudit(false);
        int rows =  goodsBillDao.addGoodsBill(goodsbill);

        Billinfo billinfo = new Billinfo();
        billinfo.setBillType("货运单");
        billinfo.setBillCode(goodsBillCode);
        billinfo.setBillState("已填");
        billDao.insertBillinfo(billinfo);

        Goodsbillevent goodsbillevent = new Goodsbillevent();
        goodsbillevent.setGoodsBillId(goodsBillCode);
        goodsbillevent.setEventName("待发");
        goodsbillevent.setRemark("单据已填");
        goodsBillDao.insertGoodsbillevent(goodsbillevent);

        if (rows > 0){
            return goodsBillCode ;
        }else {
            throw new RuntimeException("添加失败");
        }

    }
    @Transactional
    @Override
    public void addGoods(Cargoreceiptdetail cargoreceiptdetail, String goodsBillCode) {

        String goodsRevertBillId = "HZ" ;

        while (true) {
            goodsRevertBillId += RandomCode.getCode();
            if (findGoodsBillByCode(goodsRevertBillId) == null) {
                break;
            }
        }

        cargoreceiptdetail.setGoodsBillDetailId(goodsBillCode);
        cargoreceiptdetail.setGoodsRevertBillId(goodsRevertBillId);

        int rows =  goodsBillDao.addGoods(cargoreceiptdetail);
        if (rows == 0){
            throw new RuntimeException("添加失败");
        }

        Goodsbill goodsbill = new Goodsbill();
        goodsbill.setValidity(true);
        goodsbill.setIfAudit(true);
        goodsbill.setGoodsBillCode(cargoreceiptdetail.getGoodsBillDetailId());
        goodsBillDao.updateGoodsBill(goodsbill);
    }

    @Override
    public void deleteGoodsBill(String goodsBillCode) {

    }

    @Override
    public void updateGoodsBill(Goodsbill goodsbill) {
        int rows =  goodsBillDao.updateGoodsBill(goodsbill);

        if (rows == 0){
            throw new RuntimeException("更新失败") ;
        }
    }

    @Override
    public void updateDel(String goodsBillCode) {
        Billinfo billinfo = new Billinfo();
        billinfo.setBillCode(goodsBillCode);
        billinfo.setAcceptStation("货单作废");
        int i = billDao.updateBillInfo(billinfo);
        if (i == 0){
            throw new RuntimeException("删除失败") ;
        }

        Goodsbillevent goodsbillevent = new Goodsbillevent();
        goodsbillevent.setEventName("删除");
        goodsbillevent.setGoodsBillId(goodsBillCode);
        int i1 = goodsBillDao.updateGoodsbillevent(goodsbillevent);
        if (i1 == 0){
            throw new RuntimeException("删除失败") ;
        }
    }

    @Override
    public JsonMessage findAllGoodsBill(int page, int limit) {
        JsonMessage jsonMessage = new JsonMessage();

        PageHelper.startPage(page,limit) ;

        List<Goodsbill> list =  goodsBillDao.findAllGoodsBill() ;
        if(list != null && list.size()>0){
            jsonMessage.setCode(0);
            jsonMessage.setMsg("查询成功");
            jsonMessage.setData(list);
            jsonMessage.setCount(((Page)list).getTotal());
        }else {
            jsonMessage.setCode(1);
            jsonMessage.setMsg("未查询到数据");
        }

        return jsonMessage;
    }


    @Override
    public Goodsbill findGoodsBillByCode(String goodsBillCode) {
       Goodsbill goodsbill =  goodsBillDao.findGoodsBillByCode(goodsBillCode) ;
        return goodsbill;
    }

    @Override
    public Cargoreceiptdetail findCargoreceiptdetailByCode(String goodsRevertBillId) {
        Cargoreceiptdetail cargoreceiptdetail =  goodsBillDao.findCargoreceiptdetailByCode(goodsRevertBillId) ;
        return cargoreceiptdetail;
    }

    @Override
    public JsonMessage findGoodsBillByEvent(String eventName , int page , int limit) {
        JsonMessage jsonMessage = new JsonMessage();

        PageHelper.startPage(page,limit) ;

        if ("".equals(eventName)){
            eventName = null ;
        }

        List<Goodsbillevent> list =  goodsBillDao.findGoodsBillByEvent(eventName) ;

        if(list != null && list.size()>0){
            jsonMessage.setCode(0);
            jsonMessage.setMsg("查询成功");
            jsonMessage.setData(list);
            jsonMessage.setCount(((Page)list).getTotal());
        }else {
            jsonMessage.setCode(1);
            jsonMessage.setMsg("未查询到数据");
        }

        return jsonMessage;
    }

    @Override
    public JsonMessage findAllGoodsBillByEvent(int page, int limit) {
        JsonMessage jsonMessage = new JsonMessage();

        PageHelper.startPage(page,limit) ;

        List<Goodsbillevent> list =  goodsBillDao.findAllGoodsBillByEvent() ;

        if(list != null && list.size()>0){
            jsonMessage.setCode(0);
            jsonMessage.setMsg("查询成功");
            jsonMessage.setData(list);
            jsonMessage.setCount(((Page)list).getTotal());
        }else {
            jsonMessage.setCode(1);
            jsonMessage.setMsg("未查询到数据");
        }

        return jsonMessage;
    }
}
