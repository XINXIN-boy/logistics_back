package com.itqf.service.impl;

import com.itqf.commen.JsonMessage;
import com.itqf.dao.UserDao;
import com.itqf.entity.User;
import com.itqf.entity.Usergroup;
import com.itqf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * projectName:logistics_back
 *
 * @author: 三毛
 * time:2020/10/516:37
 * description:
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao ;

    @Transactional
    @Override
    public void addUserGroup(Usergroup usergroup) {
        int i = userDao.judgeUserGroupName(usergroup.getGroupName());
        if (i>0){
            throw  new RuntimeException("组名已经存在");
        }
        int rows = userDao.addUserGroup(usergroup) ;
        if (rows > 0){
            //success
        }else {
            throw new RuntimeException("添加失败");
        }
    }
    @Transactional
    @Override
    public void deleteUserGroup(int id) {
        int i = userDao.judgeUserGroupUse(id);
        if (i>0){
            throw new RuntimeException("用户组有员工，不能删除");
        }
        int rows = userDao.deleteUserGroup(id) ;
        if (rows > 0){
            //success
        }else {
            throw new RuntimeException("删除失败");
        }
    }
    @Transactional
    @Override
    public void updateUserPassword(User user) {
        int rows = userDao.updateUserPassword(user);
        if (rows > 0){
            //success
        }else {
            throw new RuntimeException("修改密码失败");
        }

    }
    @Transactional
    @Override
    public void updateUserGroupDe(Usergroup usergroup) {
        int rows = userDao.updateUserGroupDe(usergroup);
        if (rows > 0){
            //success
        }else {
            throw new RuntimeException("修改密码失败");
        }
    }
    @Override
    public User findUser(String loginId, String password) {

        User user  =  userDao.findUser(loginId);

        if (user == null) {
            throw new RuntimeException("查无此人");
        }

        if (!password.equals(user.getPassword()))
        {
            throw new RuntimeException("密码错误") ;
        }

        return user;
    }

    @Override
    public JsonMessage findAllUserGroup() {
        JsonMessage jsonMessage = new JsonMessage();

       List<Usergroup> list =  userDao.findAllUserGroup();

       if (list!=null && list.size()>0){
           jsonMessage.setData(list);
           jsonMessage.setCode(0);
       }else {
           jsonMessage.setMsg("未查询到数据！");
           jsonMessage.setCode(1);
       }
        return jsonMessage;
    }

    @Override
    public Usergroup findUserGroup(int id) {
        Usergroup usergroup = userDao.findUserGroup(id);
        if (usergroup != null){
            return usergroup ;
        }else {
            throw new RuntimeException("未查询到数据！");
        }
    }


}
