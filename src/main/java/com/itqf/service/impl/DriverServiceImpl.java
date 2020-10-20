package com.itqf.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itqf.commen.Constent;
import com.itqf.commen.JsonMessage;
import com.itqf.commen.RandomCode;
import com.itqf.dao.DriverDao;
import com.itqf.dao.UserDao;
import com.itqf.entity.Driverinfo;
import com.itqf.entity.User;
import com.itqf.entity.Userwithgroup;
import com.itqf.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * projectName:logistics_back
 *
 * @author: 三毛
 * time:2020/10/621:52
 * description:
 */
@Service
public class DriverServiceImpl implements DriverService {

    @Autowired
    private DriverDao driverDao ;

    @Autowired
    private UserDao userDao ;

    @Transactional
    @Override
    public void insertDriver(Driverinfo driverinfo) {

        String driverId = "DR" ;

        while (true){
            driverId  += RandomCode.getCode() ;

            if (driverDao.findDriverByCode(driverId) == null){
                break;
            }

        }
        driverinfo.setId(driverId);
        if (driverinfo.getState() == null ){
            driverinfo.setState(Constent.DEFAULT_DRIVER_STATUS);
        }
        int rows = driverDao.insertDriver(driverinfo) ;
        if (rows > 0){
            //success
        }else {
            throw new RuntimeException("添加失败！");
        }

        User user = new User();
        user.setPassword("000000");
        user.setLoginId(driverId);
        userDao.insertUser(user) ;

        Userwithgroup userwithgroup = new Userwithgroup();
        userwithgroup.setGroupId(7);
        userwithgroup.setUserId(driverId);
        userDao.insertUserwithgroup(userwithgroup);



    }

    @Override
    public JsonMessage findAll(int page, int limit) {
        if(page == 0){
            page = 1 ;
        }
        if (limit == 0){
            limit = 10 ;
        }
        PageHelper.startPage(page, limit) ;
        List<Driverinfo> list =  driverDao.findAll();

        JsonMessage jsonMessage = new JsonMessage();

        if (list != null && list.size() > 0){
            jsonMessage.setCode(0);
            jsonMessage.setMsg("查询成功！");
            jsonMessage.setData(list);
            jsonMessage.setCount(((Page)list).getTotal());
        }else {
            jsonMessage.setCode(1);
            jsonMessage.setMsg("未查询到数据！");
        }
        return jsonMessage;
    }
    @Transactional
    @Override
    public void deleteDriver(String id) {
        int rows = driverDao.deleteDriver(id) ;
        if (rows > 0){
            //success
        }else {
            throw new RuntimeException("删除失败！");
        }
    }

    @Override
    public JsonMessage findDriverByCode(String id) {
        Driverinfo driverinfo =  driverDao.findDriverByCode(id);

        JsonMessage jsonMessage = new JsonMessage();

        if (driverinfo!= null){
            jsonMessage.setCode(0);
            jsonMessage.setMsg("查询成功！");
            jsonMessage.setData(driverinfo);
        }else {
            jsonMessage.setCode(1);
            jsonMessage.setMsg("未查询到数据！");
        }
        return jsonMessage;
    }
    @Transactional
    @Override
    public void updateDriver(Driverinfo driverinfo) {
        int rows = driverDao.updateDriver(driverinfo) ;
        if (rows > 0){
            //success
        }else {
            throw new RuntimeException("更新失败！");
        }
    }
}
