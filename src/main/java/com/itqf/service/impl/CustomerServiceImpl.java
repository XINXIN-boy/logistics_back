package com.itqf.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itqf.commen.JsonMessage;
import com.itqf.commen.RandomCode;
import com.itqf.dao.CustomerDao;
import com.itqf.dao.UserDao;
import com.itqf.entity.Customerinfo;
import com.itqf.entity.User;
import com.itqf.entity.Usergroup;
import com.itqf.entity.Userwithgroup;
import com.itqf.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * projectName:logistics_back
 *
 * @author: 三毛
 * time:2020/10/619:53
 * description:
 */
@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDao customerDao ;

    @Autowired
    private UserDao userDao ;

    @Override
    public void insertCustomer(Customerinfo customerinfo) {

        String customerCode = "CU" ;

        while (true){
            customerCode  += RandomCode.getCode() ;

            if (customerDao.findCustomerByCode(customerCode) == null){
                break;
            }

        }
        customerinfo.setCustomerCode(customerCode);
        int rows = customerDao.insertCustomer(customerinfo) ;

        User user = new User();
        user.setPassword("000000");
        user.setLoginId(customerCode);
        userDao.insertUser(user) ;

        Userwithgroup userwithgroup = new Userwithgroup();
        userwithgroup.setGroupId(6);
        userwithgroup.setUserId(customerCode);
        userDao.insertUserwithgroup(userwithgroup);

        if (rows > 0){
            //success
        }else {
            throw new RuntimeException("添加失败！");
        }

    }
    @Transactional
    @Override
    public JsonMessage findAll(int page, int limit) {
        if(page == 0){
            page = 1 ;
        }
        if (limit == 0){
            limit = 10 ;
        }
        PageHelper.startPage(page, limit) ;
        List<Customerinfo> list =  customerDao.findAll();

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

    @Override
    public void deleteCustomer(String customerCode) {
        int rows = customerDao.deleteCustomer(customerCode) ;
        if (rows > 0){
            //success
        }else {
            throw new RuntimeException("删除失败！");
        }
    }


    @Override
    public JsonMessage findCustomerByCode(String customerCode) {
        Customerinfo customerinfo =  customerDao.findCustomerByCode(customerCode);

        JsonMessage jsonMessage = new JsonMessage();

        if (customerinfo!= null){
            jsonMessage.setCode(0);
            jsonMessage.setMsg("查询成功！");
            jsonMessage.setData(customerinfo);
        }else {
            jsonMessage.setCode(1);
            jsonMessage.setMsg("未查询到数据！");
        }
        return jsonMessage;
    }

    @Transactional
    @Override
    public void updateCustomerInfo(Customerinfo customerinfo) {
        int rows = customerDao.updateCustomerInfo(customerinfo) ;
        if (rows > 0){
            //success
        }else {
            throw new RuntimeException("更新失败！");
        }
    }


}
