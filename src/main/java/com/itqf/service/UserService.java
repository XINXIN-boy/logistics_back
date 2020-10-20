package com.itqf.service;

import com.itqf.commen.JsonMessage;
import com.itqf.entity.User;
import com.itqf.entity.Usergroup;

/**
 * projectName:logistics_back
 *
 * @author: 三毛
 * time:2020/10/516:37
 * description:
 */
public interface UserService {

    void addUserGroup(Usergroup usergroup);

    void deleteUserGroup(int id);

    void updateUserPassword(User user);

    void updateUserGroupDe(Usergroup usergroup);

    User findUser(String loginId, String password);

    JsonMessage findAllUserGroup();

    Usergroup findUserGroup(int id);

}
