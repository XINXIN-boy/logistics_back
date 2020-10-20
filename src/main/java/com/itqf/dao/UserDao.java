package com.itqf.dao;

import com.itqf.entity.User;
import com.itqf.entity.Usergroup;
import com.itqf.entity.Userwithgroup;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * projectName:logistics_back
 *
 * @author: 三毛
 * time:2020/10/516:38
 * description:\
 */
@Repository
public interface UserDao {

    int addUserGroup(Usergroup usergroup);

    void insertUser(User user);

    void insertUserwithgroup(Userwithgroup userwithgroup);

    int deleteUserGroup(int id);

    int updateUserPassword(User user);
    int updateUserGroupDe(Usergroup usergroup);

    User findUser(String loginId);
    List<Usergroup> findAllUserGroup();
    Usergroup findUserGroup(int id);

    int judgeUserGroupUse(int id);
    int judgeUserGroupName(String groupName);


    Usergroup findUserGroupByGroupName(String department);
}
