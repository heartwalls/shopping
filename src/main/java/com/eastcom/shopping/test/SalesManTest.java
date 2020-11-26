package com.eastcom.shopping.test;

import com.eastcom.shopping.dao.SalesManDao;
import com.eastcom.shopping.entity.SalesMan;
import org.junit.Test;

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
}
