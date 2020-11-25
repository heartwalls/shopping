package com.eastcom.shopping.test;

import com.eastcom.shopping.dao.GoodsDao;
import com.eastcom.shopping.entity.Goods;
import com.eastcom.shopping.utils.DBUtils;
import org.junit.Test;

import java.sql.Connection;

public class GoodsTest {

    Goods goods = new Goods();
    GoodsDao goodsDao = new GoodsDao();

    @Test
    public void connection() {
        System.out.println(DBUtils.connection());
    }

    @Test
    public void addGoods() {
        goods.setgName("Huawei P40");
        goods.setgPrice(5999);
        goods.setgNum(10);
        boolean b = goodsDao.addGoods(goods);
        if (b) {
            System.out.println("添加商品成功");
        } else {
            System.out.println("添加商品失败");
        }
    }

    @Test
    public void updateGoods() {
        goods.setgName("Iphone 12");
        goods.setgPrice(6799);
        goods.setgNum(10);
        goodsDao.updateGoods(1, goods);
    }

    @Test
    public void deleteGoods() {
        goodsDao.deleteGoods(2);
    }

    @Test
    public void sortGoods() {
        goodsDao.queryGoods(1);
    }

    @Test
    public void selectGoods() {
        goodsDao.displayGoods();
    }
}
