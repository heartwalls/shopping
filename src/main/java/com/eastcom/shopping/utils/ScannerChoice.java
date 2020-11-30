package com.eastcom.shopping.utils;

import com.eastcom.shopping.page.GoodsPage;
import com.eastcom.shopping.page.MainPage;
import com.eastcom.shopping.page.SalesManPage;
import com.eastcom.shopping.page.SalesPage;

import java.util.Scanner;

/**
 * 界面选择操作
 */
public class ScannerChoice {
    /**
     * 键盘获取价格输入
     * @return
     */
    public static double scannerInfo() {
        double num = 0.0;
        do {
            Scanner scanner = new Scanner(System.in);
            System.out.println("请输入（保存到小数点后两位）：");
            String info = scanner.next();
            // 保留小数点后两位
            String reg = "(([1-9][0-9]*)\\.([0-9]{2}))|[0]\\.([0-9]{2})";
            if (info.matches(reg)) {
                num = Double.parseDouble(info);
            } else {
                System.out.println("输入错误！请重新输入！");
                continue;
            }
            break;
        } while (true);

        return num;
    }

    /**
     * 键盘获取整数
     * @return
     */
    public static int scannerNum()
    {
        int num = 0;
        String regex = "([1-9])|([1-9][0-9]+)";
        do
        {
            Scanner sc = new Scanner(System.in);
            System.out.print("请输入：");
            String nums = sc.next();

            if (nums.matches(regex))
            {
                num = Integer.parseInt(nums);
            }else
            {
                System.err.println("！输入有误！");
                continue;
            }
            break;
        } while (true);
        return num;
    }

    /**
     * 获取的键盘输入
     * @return
     */
    public static String scannerInfoString()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入：");
        return scanner.next();
    }

    /**
     * 获取用户下一步操作
     * @param operator
     */
    public static void changedInfoNext(String operator) {
        do {
            System.out.println("是否继续进行-当前操作:(Y/N)");
            String choice = ScannerChoice.scannerInfoString();

            if ("y".equals(choice) || "Y".equals(choice))
            {
                if ("updateGoodsPage".equals(operator)) {
                    GoodsPage.updateGoodsPage();
                } else if ("deleteGoodsPage".equals(operator)) {
                    GoodsPage.deleteGoodsPage();
                } else if ("addGoodsPage".equals(operator)) {
                    GoodsPage.addGoodsPage();
                } else if ("queryGoodsPage".equals(operator)) {
                    GoodsPage.queryGoodsPage();
                }
            } else if ("N".equals(choice) || "n".equals(choice)) {
                MainPage.maintenancePage();
            }
            System.out.println("\n输入有误！请重新输入！");
        } while (true);
    }

    public static void choiceSalesManNext(String operator) {
        do {
            System.out.println("是否继续进行-当前操作:(Y/N)");
            String choice = ScannerChoice.scannerInfoString();

            if ("y".equals(choice) || "Y".equals(choice))
            {
                if ("updateSalesManPage".equals(operator)) {
                    SalesManPage.updateSalesManPage();
                } else if ("deleteSalesManPage".equals(operator)) {
                    SalesManPage.deleteSalesManPage();
                } else if ("addSalesManPage".equals(operator)) {
                    SalesManPage.addSalesManPage();
                } else if ("querySalesManPage".equals(operator)) {
                    SalesManPage.querySalesManPage();
                }
            } else if ("N".equals(choice) || "n".equals(choice)) {
                MainPage.salesManManagementPage();
            }
            System.out.println("\n输入有误！请重新输入！");
        } while (true);
    }
}
