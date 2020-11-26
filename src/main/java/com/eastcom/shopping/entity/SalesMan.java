package com.eastcom.shopping.entity;

/**
 * 售货员实体类
 */
public class SalesMan {
    private int mId;
    private String mName;
    private String mPassword;

    /**
     * 验证用户登陆
     * @param mId
     * @param mPassword
     */
    public SalesMan(int mId, String mPassword) {
        this.mId = mId;
        this.mPassword = mPassword;
    }

    /**
     * 查询用户，更改用户密码
     * @param mId
     * @param mName
     * @param mPassword
     */
    public SalesMan(int mId, String mName, String mPassword) {
        this.mId = mId;
        this.mName = mName;
        this.mPassword = mPassword;
    }

    /**
     * 添加用户
     * @param mName
     * @param mPassword
     */
    public SalesMan(String mName, String mPassword) {
        this.mName = mName;
        this.mPassword = mPassword;
    }

    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmPassword() {
        return mPassword;
    }

    public void setmPassword(String mPassword) {
        this.mPassword = mPassword;
    }
}
