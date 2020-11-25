package com.eastcom.shopping.entity;

/**
 * 售货员实体类
 */
public class SalesMan {
    private int sId;
    private String sName;
    private String sPassword;

    /**
     * 验证用户登陆
     * @param sId
     * @param sPassword
     */
    public SalesMan(int sId, String sPassword) {
        this.sId = sId;
        this.sPassword = sPassword;
    }

    /**
     * 查询用户，更改用户密码
     * @param sId
     * @param sName
     * @param sPassword
     */
    public SalesMan(int sId, String sName, String sPassword) {
        this.sId = sId;
        this.sName = sName;
        this.sPassword = sPassword;
    }

    /**
     * 添加用户
     * @param sName
     * @param sPassword
     */
    public SalesMan(String sName, String sPassword) {
        this.sName = sName;
        this.sPassword = sPassword;
    }

    public int getsId() {
        return sId;
    }

    public void setsId(int sId) {
        this.sId = sId;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getsPassword() {
        return sPassword;
    }

    public void setsPassword(String sPassword) {
        this.sPassword = sPassword;
    }
}
