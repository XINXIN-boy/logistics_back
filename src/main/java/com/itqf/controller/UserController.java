package com.itqf.controller;

import com.itqf.commen.Constent;
import com.itqf.commen.JsonMessage;
import com.itqf.entity.User;
import com.itqf.entity.Usergroup;
import com.itqf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * projectName:logistics_back
 *
 * @author: 三毛
 * time:2020/10/516:23
 * description:
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
   private UserService userService ;

    /**
     * 添加用户组
     * @param usergroup
     * @return
     */
    @RequestMapping("/addUserGroup.do")
    public JsonMessage addUserGroup(Usergroup usergroup){
        JsonMessage jsonMessage = new JsonMessage();
        try {
            userService.addUserGroup(usergroup);
            jsonMessage.setCode(0);
            jsonMessage.setMsg("添加成功");
        } catch (RuntimeException e) {
            jsonMessage.setCode(1);
            jsonMessage.setMsg(e.getMessage());
        }
        return  jsonMessage ;
    }

    /**
     * 删除用户组
     * @param id
     * @return
     */
    @RequestMapping("/deleteUserGroup.do")
    public JsonMessage deleteUserGroup(int id){
        JsonMessage jsonMessage = new JsonMessage();
        try {
            userService.deleteUserGroup(id);
            jsonMessage.setCode(0);
            jsonMessage.setMsg("修改成功");
        } catch (RuntimeException e) {
            jsonMessage.setCode(1);
            jsonMessage.setMsg(e.getMessage());
        }
        return  jsonMessage ;
    }

    /**
     * 修改密码
     * @param user
     * @return
     */
    @RequestMapping("/updateUserPassword.do")
    public JsonMessage updateUserPassword(User user){
        JsonMessage jsonMessage = new JsonMessage();
        try {
           userService.updateUserPassword(user);
            jsonMessage.setCode(0);
            jsonMessage.setMsg("修改成功");
        } catch (RuntimeException e) {
            jsonMessage.setCode(1);
            jsonMessage.setMsg(e.getMessage());
        }

        return  jsonMessage ;
    }

    @RequestMapping("/updateUserGroupDe.do")
    public JsonMessage updateUserGroupDe(Usergroup usergroup){
        JsonMessage jsonMessage = new JsonMessage();
        try {
            userService.updateUserGroupDe(usergroup);
            jsonMessage.setCode(0);
            jsonMessage.setMsg("修改成功");
        } catch (RuntimeException e) {
            jsonMessage.setCode(1);
            jsonMessage.setMsg(e.getMessage());
        }

        return  jsonMessage ;
    }
    /**
     * 登录
     * @param session
     * @param loginId
     * @param password
     * @return
     */
    @RequestMapping("/login.do")
    public JsonMessage login(HttpSession session ,String loginId , String password ){
        JsonMessage jsonMessage = new JsonMessage();

        try {
            User user =  userService.findUser(loginId , password);
            jsonMessage.setCode(0);
            jsonMessage.setData(user);
            session.setAttribute(Constent.LOGIN_USER , user);
        } catch (RuntimeException e) {
            jsonMessage.setCode(1);
            jsonMessage.setMsg(e.getMessage());
        }

        return  jsonMessage ;
    }

    /**
     * 查询所有的用户组
     * @return
     */
    @RequestMapping("/findAllUserGroup.do")
    public JsonMessage findAllUserGroup(){
        JsonMessage jsonMessage = userService.findAllUserGroup();
        return jsonMessage ;
    }

    /**
     * 查询用户组
     * @param id
     * @return
     */
    @RequestMapping("/findUserGroup.do")
    public JsonMessage findUserGroup(int id ){
        JsonMessage jsonMessage = new JsonMessage();
        try {
           Usergroup usergroup =  userService.findUserGroup(id);
            jsonMessage.setCode(0);
           jsonMessage.setData(usergroup);
        } catch (RuntimeException e) {
            jsonMessage.setCode(1);
            jsonMessage.setMsg(e.getMessage());
        }
        return  jsonMessage ;
    }
    /**
     * 判断登录状态
     * @param session
     * @return
     */
    @RequestMapping("/judgeLoginStatus.do")
    public JsonMessage judgeLoginStatus(HttpSession session  ){
        JsonMessage jsonMessage = new JsonMessage();

        User user = (User) session.getAttribute(Constent.LOGIN_USER);

        if (user!= null ){
            jsonMessage.setCode(0);
            jsonMessage.setData(user);
        }else {
            jsonMessage.setCode(1);
            jsonMessage.setMsg("未登录");
        }
        return  jsonMessage ;
    }

    /***
     *判断旧密码
     * @param session
     * @param oldPassword
     * @return
     */
    @RequestMapping("/judgeOldPassword.do")
    public JsonMessage judgeOldPassword(HttpSession session ,String oldPassword ){
        JsonMessage jsonMessage = new JsonMessage();
        User user = (User) session.getAttribute(Constent.LOGIN_USER);
        System.out.println("user = " + user);
        System.out.println(oldPassword);
        if (user.getPassword().equals(oldPassword) ){
            jsonMessage.setCode(0);
            jsonMessage.setMsg("密码正确");
        }else {
            jsonMessage.setCode(1);
            jsonMessage.setMsg("密码错误");
        }
        return  jsonMessage ;
    }
}
