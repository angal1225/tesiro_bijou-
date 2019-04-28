package com.wzh.ershoujiaoyi.bean;

/**
 * Created with IntelliJ IDEA.
 * User: wzh
 * Date: 2019/4/7
 * Time: 15:11
 * Description: 用户的bean，包含用户名，密码,手机号及大学
 */
public class User {
    private Integer id;
    private String userName;
    private String password;
    private String phone;
    private String college;
    private String addr;

    public User() {
    }

    public User(String userName, String password, String phone, String addr) {
        this.userName = userName;
        this.password = password;
        this.phone = phone;
        this.addr = addr;
    }

    public User(Integer id, String userName, String password, String phone, String college) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.phone = phone;
        this.college = college;
    }

    public User(String userName, String password, String phone, String college, String addr) {
        this.userName = userName;
        this.password = password;
        this.phone = phone;
        this.college = college;
        this.addr = addr;
    }

    public User(Integer id, String userName, String password, String phone, String college, String addr) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.phone = phone;
        this.college = college;
        this.addr = addr;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", college='" + college + '\'' +
                ", addr='" + addr + '\'' +
                '}';
    }
}
