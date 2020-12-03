package com.eastcom.shopping.page;

import com.eastcom.shopping.dao.SalesDao;
import com.eastcom.shopping.entity.Sales;
import com.eastcom.shopping.utils.ScannerChoice;

import java.util.ArrayList;

/**
 * 当日商品销售展示页面
 */
public class SalesPage {
    public static void dailySaleGoodsPage() {
        System.out.println("\t正在执行列出当日售出商品列表操作\n");
        ArrayList<Sales> salesList = new SalesDao().dailySales();

        if (salesList.size() <= 0) {
            System.out.println("\t今日无商品出售！");
            MainPage.commodityManagementPage();
        } else {
            System.out.println("\t\t\t\t今日售出商品列表\n");
            System.out.println("\t商品名称\t\t商品价格\t\t商品数量\t\t销量\n");
            for (int i = 0; i < salesList.size(); i++) {
                Sales sales = salesList.get(i);
                System.out.println("\t"+sales.getgName()+"\t\t"+sales.getgPrice()+" $\t\t"+sales.getgNum()+"\t\t"+sales.getAllSNum());
            }
            System.out.println("------------------------------");
            do {
                System.out.println("输入 0 返回上一级菜单:");
                String choice = ScannerChoice.scannerInfoString();
                if ("0".equals(choice)) {
                    MainPage.commodityManagementPage();
                }
                System.out.println("输入错误！请重新输入！");
            } while (true);
        }
    }
}
