package com.itqf.entity;

/**
 * projectName:logistics_back
 *
 * @author: 三毛
 * time:2020/10/516:35
 * description:
 */
public class User {
    private String loginId ;
    private String password ;
    private int ifOnline ;

    @Override
    public String toString() {
        return "User{" +
                "loginId='" + loginId + '\'' +
                ", password='" + password + '\'' +
                ", ifOnline=" + ifOnline +
                '}';
    }

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getIfOnline() {
        return ifOnline;
    }

    public void setIfOnline(int ifOnline) {
        this.ifOnline = ifOnline;
    }
}
