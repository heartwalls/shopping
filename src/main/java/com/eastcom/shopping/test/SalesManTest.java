package com.eastcom.shopping.test;

import com.eastcom.shopping.dao.SalesManDao;
import com.eastcom.shopping.entity.SalesMan;
import org.junit.Test;

import java.util.ArrayList;

public class SalesManTest {
    @Test
    public void addSalesManTest() {
        SalesManDao salesManDao = new SalesManDao();
        SalesMan salesMan = new SalesMan(101,"joker", "USJoker");
        boolean b = salesManDao.addSalesMan(salesMan);
        if (b) {
            System.out.println("添加成功");
        } else {
            System.out.println("添加失败");
        }
    }

    @Test
    public void cashRegisterLogTest() {
        SalesManDao salesManDao = new SalesManDao();
        ArrayList<SalesMan> list = salesManDao.cashRegisterLog("joker");
        if (list.size() >= 0) {
            System.out.println("验证成功");
        } else {
            System.out.println("验证失败");
        }
    }

    @Test
    public void updateSalesManTest() {
        SalesManDao salesManDao = new SalesManDao();
        // 实际修改时，需要遍历整个列表，然后搜索编号更改
        SalesMan salesMan = new SalesMan(101, "Joker", "USJoker");
        salesMan.setmName("Hali");
        salesManDao.updateSalesMan(101, salesMan);
    }

    @Test
    public void deleteSalesManTest() {
        SalesManDao salesManDao = new SalesManDao();
        salesManDao.deleteSalesMan("Hali");
    }

    @Test
    public void querySalesManTest() {
        ArrayList<SalesMan> list = new SalesManDao().querySalesMan("Joker");
        for (int i = 0; i < list.size(); i++) {
            SalesMan salesMan = list.get(i);
            System.out.println(salesMan.getmId() + "," + salesMan.getmName());
        }
    }
}