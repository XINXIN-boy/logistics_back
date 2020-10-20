package com.itqf.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itqf.commen.JsonMessage;
import com.itqf.commen.RandomCode;
import com.itqf.dao.EmployeeDao;
import com.itqf.dao.UserDao;
import com.itqf.entity.Employee;
import com.itqf.entity.User;
import com.itqf.entity.Usergroup;
import com.itqf.entity.Userwithgroup;
import com.itqf.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.xml.bind.util.JAXBSource;
import java.util.List;

/**
 * projectName:logistics_back
 *
 * @author: 三毛
 * time:2020/10/718:51
 * description:
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDao employeeDao ;

    @Autowired
    private UserDao userDao ;

    @Transactional
    @Override
    public void insertEmployee(Employee employee) {

        String emplayeeCode = "EM" ;

        while (true){
            emplayeeCode  += RandomCode.getCode() ;

            if (employeeDao.findEmployeeByCode(emplayeeCode) == null){
                break;
            }

        }
        employee.setEmployeeCode(emplayeeCode);

        User user = new User();
        user.setPassword("000000");
        user.setLoginId(emplayeeCode);
        userDao.insertUser(user) ;

        Userwithgroup userwithgroup = new Userwithgroup();
        Usergroup usergroup = userDao.findUserGroupByGroupName(employee.getDepartment()) ;
        userwithgroup.setGroupId((int)usergroup.getId());
        userwithgroup.setUserId(emplayeeCode);
        userDao.insertUserwithgroup(userwithgroup);


        int rows = employeeDao.insertEmployee(employee);
        if (rows > 0){
            //success
        }else {
            throw new RuntimeException("添加失败");
        }
    }
    @Transactional
    @Override
    public void deleteEmployee(String employeeCode) {
        int rows = employeeDao.deleteEmployee(employeeCode);
        if (rows > 0){
            //success
        }else {
            throw new RuntimeException("删除失败！");
        }
    }
    @Transactional
    @Override
    public void updateEmployee(Employee employee) {
        int rows = employeeDao.updateEmployee(employee);
        if (rows > 0){
            //success
        }else {
            throw new RuntimeException("修改失败！");
        }
    }

    @Override
    public JsonMessage findAll(int page, int limit) {
        JsonMessage jsonMessage = new JsonMessage();
        PageHelper.startPage(page,limit) ;
        List<Employee> list =  employeeDao.findAll();

        if (list!= null && list.size()>0){
            jsonMessage.setMsg("查询成功！");
            jsonMessage.setCode(0);
            jsonMessage.setData(list);
            jsonMessage.setCount(((Page)list).getTotal());
        }else {
            jsonMessage.setMsg("未查询到数据！");
            jsonMessage.setCode(1);
        }
        return jsonMessage;
    }

    @Override
    public JsonMessage findEmployeeByCode(String employeeCode) {
        JsonMessage jsonMessage = new JsonMessage();

        Employee employee =  employeeDao.findEmployeeByCode(employeeCode);

        if (employee!=null){
            jsonMessage.setMsg("查询成功！");
            jsonMessage.setCode(0);
            jsonMessage.setData(employee);
        }else {
            jsonMessage.setMsg("未查询到数据！");
            jsonMessage.setCode(1);
        }
        return jsonMessage;
    }
}
