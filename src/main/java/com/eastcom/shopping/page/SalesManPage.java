package com.eastcom.shopping.page;

import com.eastcom.shopping.dao.SalesManDao;
import com.eastcom.shopping.entity.SalesMan;
import com.eastcom.shopping.utils.ScannerChoice;

public class SalesManPage extends ScannerChoice {
    /**
     * 添加售货员
     */
    public static void addSalesManPage() {
        System.out.println("\t正在执行添加售货员操作\n");
        System.out.println("\n添加售货员-姓名");
        int mId = ScannerChoice.scannerNum();
        System.out.println("\n添加售货员-姓名");
        String mName = ScannerChoice.scannerInfoString();
        System.out.println("\n添加售货员-密码");
        String mPassword = ScannerChoice.scannerInfoString();
        SalesMan salesMan = new SalesMan(mId, mName, mPassword);
        boolean b = new SalesManDao().addSalesMan(salesMan);
        if (b) {
            System.out.println("\n\t!您已成功添加售货员到数据库!");
        } else {
            System.out.println("添加售货员失败");
        }
        choiceSalesManNext("addSalesManPage");
    }

    /**
     * 更新售货员信息
     */
    public static void updateSalesManPage() {

    }

    public static void deleteSalesManPage() {

    }

    public static void querySalesManPage() {

    }

    public static void displaySalesManPage() {

    }
}
