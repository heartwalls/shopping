package com.eastcom.shopping.page;

import com.eastcom.shopping.utils.ScannerChoice;

public class MainPage extends ScannerChoice {
    /**
     * 程序主界面
     */
    public static void mainPage() {
        System.out.println("***************************\n");
        System.out.println("\t 1.商品维护\n");
        System.out.println("\t 2.前台收银\n");
        System.out.println("\t 3.商品管理\n");
        System.out.println("***************************");

        System.out.println("\n请输入选项,或者按0退出.");
        do {
            String choice = ScannerChoice.scannerInfoString();
            String regex = "[0-3]";
            if (choice.matches(regex)) {
                int i = Integer.parseInt(choice);
                switch (i) {
                    case 0:
                        System.out.println("------------------");
                        System.out.println("您已经退出系统!");
                        System.exit(1);
                        break;
                    case 1:
                        maintenancePage();
                        break;
                    case 2:
                        cashRegisterPage();
                        break;
                    case 3:
                        commodityManagementPage();
                        break;
                    default:
                        break;
                }
            } else {
                System.out.println("输入错误！请重新输入！");
            }
        } while (true);
    }

    /**
     * 商品维护界面
     */
    public static void maintenancePage() {
        System.out.println("***************************\n");
        System.out.println("\t 1.添加商品\n");
        System.out.println("\t 2.更改商品\n");
        System.out.println("\t 3.删除商品\n");
        System.out.println("\t 4.查询商品\n");
        System.out.println("\t 5.显示所有商品\n");
        System.out.println("***************************");

        System.out.println("\n请输入选项,或者按 0 返回上一级菜单.");
        do {
            String choice = ScannerChoice.scannerInfoString();
            String regex = "[0-5]";
            if (choice.matches(regex)) {
                int i = Integer.parseInt(choice);
                switch (i) {
                    case 0:
                        mainPage();
                        break;
                    case 1:
                        GoodsPage.addGoodsPage();
                        break;
                    case 2:
                        GoodsPage.updateGoodsPage();
                        break;
                    case 3:
                        GoodsPage.deleteGoodsPage();
                        break;
                    case 4:
                        GoodsPage.queryGoodsPage();
                        break;
                    case 5:
                        GoodsPage.displayGoodsPage();
                        break;
                    default:
                        break;
                }
            } else {
                System.out.println("输入错误！请重新输入！");
            }
        } while (true);
    }

    /**
     * 前台收银界面
     */
    public static void cashRegisterPage() {
        // TODO
        System.out.println("前台收银开发中...");
    }

    /**
     * 商品管理界面
     */
    public static void commodityManagementPage() {
        // TODO
        System.out.println("商品管理开发中...");
    }

    /**
     * 程序入口
     * @param args
     */
    public static void main(String[] args) {
        mainPage();
    }
}
