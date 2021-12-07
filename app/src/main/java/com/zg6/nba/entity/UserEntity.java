package com.zg6.nba.entity;

/**
 * @ProjectName: ZG61905Project
 * @Package: com.zg6.nba.entity
 * @ClassName: UserEntity
 * @Description:
 * @Author: 张跃 企鹅：444511958
 * @CreateDate: 2021/12/7 14:01
 * @UpdateUser: 张跃
 * @UpdateDate: 2021/12/7 14:01
 * @UpdateRemark:
 * @Version: 1.0
 */
public class UserEntity {
    private int id;
    private String phoneNumber;
    private String pwd;
    private String address;

    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", pwd='" + pwd + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public UserEntity() {
    }

    public UserEntity(String phoneNumber, String pwd) {
        this.phoneNumber = phoneNumber;
        this.pwd = pwd;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
