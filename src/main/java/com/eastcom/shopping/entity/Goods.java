package com.eastcom.shopping.entity;

/**
 * 商品实体类
 */
public class Goods {

    // 数据库Goods表主鍵
    private int gId;
    private String gName;
    private double gPrice;
    private int gNum;

    public Goods() {
    }

    /**
     * 添加商品信息
     * @param gName
     * @param gPrice
     * @param gNum
     */
    public Goods(String gName, double gPrice, int gNum) {
        this.gName = gName;
        this.gPrice = gPrice;
        this.gNum = gNum;
    }

    /**
     * 展示所有商品
     * @param gId
     * @param gName
     * @param gPrice
     * @param gNum
     */
    public Goods(int gId, String gName, double gPrice, int gNum) {
        this.gId = gId;
        this.gName = gName;
        this.gPrice = gPrice;
        this.gNum = gNum;
    }

    /**
     * 根据编号更改商品数量
     * @param gId
     * @param gNum
     */
    public Goods(int gId, int gNum) {
        this.gId = gId;
        this.gNum = gNum;
    }

    /**
     * 根据编号更改商品价格
     * @param gId
     * @param gPrice
     */
    public Goods(int gId, double gPrice) {
        this.gId = gId;
        this.gPrice = gPrice;
    }

    /**
     * 根据编号更改商品名称
     * @param gId
     * @param gName
     */
    public Goods(int gId, String gName) {
        this.gId = gId;
        this.gName = gName;
    }

    public int getgId() {
        return gId;
    }

    public void setgId(int gId) {
        this.gId = gId;
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
}
