package com.eastcom.shopping.page;

import com.eastcom.shopping.dao.SalesManDao;
import com.eastcom.shopping.entity.SalesMan;
import com.eastcom.shopping.utils.ScannerChoice;

import java.util.ArrayList;

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
        System.out.println("\n*******欢迎使用商超购物管理系统*******\n");
        System.out.println("\t 1.登录系统\n");
        System.out.println("\t 2.退出系统\n");
        System.out.println("-----------------------------");
        System.out.println("请输入选项,或者按 0 返回上一级菜单.");

        do {
            String choice = ScannerChoice.scannerInfoString();
            String regex = "[0-2]";
            if (choice.matches(regex)) {
                int i = Integer.parseInt(choice);
                switch (i) {
                    case 0:
                        MainPage.mainPage();
                        break;
                    case 1:
                        // 登陆次数限制
                        int loginLimit = 5;
                        while (loginLimit != 0) {
                            loginLimit--;
                            System.out.println("---用户名---");
                            String mName = scannerInfoString();
                            System.out.println("---密码---");
                            String mPassword = scannerInfoString();
                            ArrayList<SalesMan> list = new SalesManDao().cashRegisterLog(mName);
                            if (list == null || list.size() == 0) {
                                System.out.println("用户不存在！");
                                System.out.println("\n剩余登陆次数："+loginLimit);
                            } else {
                                // 返回一个数组
                                SalesMan salesMan = list.get(0);
                                if (mPassword.equals(salesMan.getmPassword())) {
                                    System.out.println("\t  ---账户成功登陆---");
                                    shoppingSettlementPage(salesMan.getmId());
                                } else {
                                    System.err.println("\t!!用户名或密码错误!!\n");
                                    System.out.println("\n剩余登陆次数："+loginLimit);
                                }
                            }
                        }
                        System.out.println("------------------");
                        // TODO
                        // 密码错误登陆限制，设计到数据库中
                        System.err.println("\t！！您已被强制退出系统！！");
                        break;
                    case 2:
                        System.out.println("------------------");
                        System.out.println("您已经退出系统!");
                        System.exit(-1);
                        break;
                    default:
                        break;
                }
            }
            System.err.println("!输入有误!");
            System.out.println("重新输入或按 0 返回上一级菜单");
        } while (true);
    }

    /**
     * 商品管理界面
     */
    public static void commodityManagementPage() {
        // TODO
        System.out.println("商品管理开发中...");
    }

    /**
     * 购物结算界面
     */
    public static void shoppingSettlementPage(int salesManId) {
        // TODO
        System.out.println("购物结算界面开发中...");
    }

    /**
     * 售货员管理界面
     */
    public static void salesManManagementPage() {
        // TODO
    }

    /**
     * 程序入口
     * @param args
     */
    public static void main(String[] args) {
        mainPage();
    }
}
