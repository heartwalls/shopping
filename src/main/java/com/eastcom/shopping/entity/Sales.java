package com.eastcom.shopping.entity;

/**
 * 售货实体类
 */
public class Sales {
    private int gId;
    private int sId;
    private int sNum;
    private int mId;
    private String gName;
    private double gPrice;
    private int gNum;
    // 单种商品销量总和
    private int allSNum;

    /**
     * 购物结算
     * @param sId
     * @param gId
     * @param mId
     * @param sNum
     */
    public Sales(int sId, int gId, int mId, int sNum) {
        this.gId = gId;
        this.sId = sId;
        this.mId = mId;
        this.sNum = sNum;
    }

    /**
     * 展示商品列表
     * @param gName
     * @param gPrice
     * @param gNum
     * @param allSNum
     */
    public Sales(String gName, double gPrice, int gNum, int allSNum) {
        this.gName = gName;
        this.gPrice = gPrice;
        this.gNum = gNum;
        this.allSNum = allSNum;
    }

    public int getgId() {
        return gId;
    }

    public void setgId(int gId) {
        this.gId = gId;
    }

    public int getsId() {
        return sId;
    }

    public void setsId(int sId) {
        this.sId = sId;
    }

    public int getsNum() {
        return sNum;
    }

    public void setsNum(int sNum) {
        this.sNum = sNum;
    }

    public String getgName() {
        return gName;
    }

    public void setgName(String gName) {
        this.gName = gName;
    }

    public double getgPrice() {
        return gPrice;
    }

    public void setgPrice(double gPrice) {
        this.gPrice = gPrice;
    }

    public int getgNum() {
        return gNum;
    }

    public void setgNum(int gNum) {
        this.gNum = gNum;
    }

    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }

    public int getAllSNum() {
        return allSNum;
    }

    public void setAllSNum(int allSNum) {
        this.allSNum = allSNum;
    }
}
