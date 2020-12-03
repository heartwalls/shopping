package com.eastcom.shopping.test;

import com.eastcom.shopping.dao.SalesDao;
import com.eastcom.shopping.entity.Sales;
import com.eastcom.shopping.page.SalesPage;
import org.junit.Test;

public class SalesTest {
    @Test
    public void dailySaleGoodsPageTest() {
        SalesPage.dailySaleGoodsPage();
    }

    @Test
    public void shoppingSettlementTest() {
        SalesDao salesDao = new SalesDao();
        Sales sales = new Sales(1, 1, 101, 1);
        salesDao.shoppingSettlement(sales);
    }
}
