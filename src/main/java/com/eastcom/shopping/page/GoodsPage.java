package com.eastcom.shopping.page;

import com.eastcom.shopping.dao.GoodsDao;
import com.eastcom.shopping.entity.Goods;
import com.eastcom.shopping.utils.ScannerChoice;

import java.util.ArrayList;

public class GoodsPage extends ScannerChoice {
    /**
     * 添加商品
     */
    public static void addGoodsPage() {
        System.out.println("\t正在执行【添加商品】操作\n");

        System.out.println("\n請輸入添加商品-名称");
        String goodsName = scannerInfoString();

        System.out.println("\n請輸入添加商品-价格");
        double goodsPrice = scannerInfo();

        System.out.println("\n請輸入添加商品-数量");
        int goodsNumber = scannerNum();

        Goods goods = new Goods(goodsName, goodsPrice, goodsNumber);
        boolean b = new GoodsDao().addGoods(goods);
        if (b) {
            System.out.println("\n\t!您已成功添加商品到数据库!");
        } else {
            System.out.println("添加商品失败");
        }
        changedInfoNext("addGoodsPage");
    }

    /**
     * 修改商品
     */
    public static void updateGoodsPage() {
        System.out.println("\t正在执行【更改商品】操作\n");
        // 列出所有商品
        ArrayList<Goods> list = new GoodsDao().displayGoods();
        if (list.size() <= 0) {
            System.out.println("库存为空！");
            MainPage.commodityManagementPage();
        } else {
            System.out.println("\t商品编号\t\t商品名称\t\t商品价格\t\t商品数量\n");
            for (int i = 0; i < list.size(); i++) {
                Goods goods = list.get(i);
                System.out.println("\t" + goods.getgId() + "\t\t" + goods.getgName() + "\t\t" + goods.getgPrice() + "\t\t" + goods.getgNum());
                int num = goods.getgNum();
                if (num == 0) {
                    System.out.println(goods.getgName() + "已售空！");
                }
            }
        }

        System.out.println("\n--------请选择您要更改的内容\n");
        System.out.println("\t1.更改商品");
        System.out.println("\t0.返回上一级菜单");
        do {
            String choice = ScannerChoice.scannerInfoString();
            String regex = "[0-1]";
            if (choice.matches(regex)) {
                int info = Integer.parseInt(choice);
                switch (info) {
                    case 0:
                        MainPage.maintenancePage();
                        break;
                    case 1:
                        System.out.println("请输入想要更改的商品编号：");
                        int id = ScannerChoice.scannerNum();
                        // 列出要修改的商品信息
                        // selectGoodsById(id);
                        // TODO
                        // 只修改其中的一部分信息
                        System.out.println("请输入商品-新名称:");
                        String newName = ScannerChoice.scannerInfoString();
                        System.out.println("请输入商品-新价格:");
                        double newPrice = ScannerChoice.scannerInfo();
                        System.out.println("请输入商品-新数量:");
                        int newNum = ScannerChoice.scannerNum();
                        Goods modifyGoods = new Goods(newName, newPrice, newNum);
                        boolean goods = new GoodsDao().updateGoods(id, modifyGoods);
                        if (goods) {
                            System.out.println("更新商品信息成功！");
                        } else {
                            System.out.println("更新商品信息失败！");
                        }
                    default:
                        break;
                }
            } else {
                System.out.println("输入错误！请重新输入！");
            }
            ScannerChoice.changedInfoNext("updateGoodsPage");
        } while (true);
    }

    /**
     * 删除商品
     */
    public static void deleteGoodsPage() {
        System.out.println("\t正在执行【删除商品】操作\n");
        // TODO
        // 列出所有商品
        System.out.println("\n--------请选择您要删除的商品\n");
        System.out.println("\t1.删除商品");
        System.out.println("\t0.返回上一级菜单");
        do {
            String choice = ScannerChoice.scannerInfoString();
            String regex = "[0-1]";
            if (choice.matches(regex)) {
                int info = Integer.parseInt(choice);
                switch (info) {
                    case 0:
                        MainPage.maintenancePage();
                        break;
                    case 1:
                        System.out.println("请输入想要删除的商品编号：");
                        int gId = ScannerChoice.scannerNum();
                        // TODO
                        // 商品编号不存在
                        System.out.println("\n确认删除该商品：Y/N");
                        String del = ScannerChoice.scannerInfoString();
                        if ("y".equals(del) || "Y".equals(del)) {
                            boolean b = new GoodsDao().deleteGoods(gId);
                            if (b) {
                                System.out.println("删除商品成功！");
                            } else {
                                System.out.println("删除商品失败！");
                            }
                        } else if ("n".equals(del) || "N".equals(del)) {
                            MainPage.maintenancePage();
                        } else {
                            System.out.println("输入错误！请重新输入！");
                        }
                        break;
                    default:
                        break;
                }
            } else {
                System.out.println("输入错误！请重新输入！");
            }
            ScannerChoice.changedInfoNext("deleteGoodsPage");
        } while (true);
    }

    /**
     * 查询商品
     */
    public static void queryGoodsPage() {
        System.out.println("\t\t  正在执行查询商品操作\n");
        System.out.println("\t\t1.按照商品 名称升序 查询");
        System.out.println("\t\t2.按照商品 价格升序 查询");
        System.out.println("\t\t3.按照商品 数量升序 查询");
        System.out.println("\n请输入选项,或者按0返回上一级菜单.");
        do {
            String choice = ScannerChoice.scannerInfoString();
            String regex = "[0-3]";
            if (choice.matches(regex)) {
                int info = Integer.parseInt(choice);
                switch (info) {
                    case 0:
                        MainPage.maintenancePage();
                        break;
                    case 1:
                    case 2:
                    case 3:
                        ArrayList<Goods> list = new GoodsDao().queryGoods(info);
                        if (list == null || list.size() <= 0) {
                            System.err.println("\n\t!!您查询的商品不存在!!\n");
                        } else {
                            if (info == 1) {
                                System.out.println("\t\t\t\t\t商品按照 名称升序 列表\n\n");
                            } else if (info == 2) {
                                System.out.println("\t\t\t\t\t商品按照 价格升序 列表\n\n");
                            } else {
                                System.out.println("\t\t\t\t\t商品按照 数量升序 列表\n\n");
                            }
                            System.out.println("\t商品编号\t\t商品名称\t\t商品价格\t\t商品数量\n");
                            for (int i = 0; i < list.size(); i++) {
                                Goods goods = list.get(i);
                                System.out.println("\t"+goods.getgId()+"\t\t"+goods.getgName()+"\t\t"+goods.getgPrice()+"\t\t"+goods.getgNum());
                                int num = goods.getgNum();
                                if (num == 0) {
                                    System.out.println(goods.getgName() + "已售空！");
                                }
                            }
                        }
                        break;
                    default:
                        System.out.println("输入错误！请重新输入！");
                        break;
                }
            } else {
                System.out.println("输入错误！请重新输入！");
            }
            ScannerChoice.changedInfoNext("queryGoodsPage");
        } while (true);
    }

    /**
     * 展示所有商品
     */
    public static void displayGoodsPage() {
        System.out.println("\t\t\t\t\t所有商品列表\n\n");
        ArrayList<Goods> list = new GoodsDao().displayGoods();
        if (list.size() <= 0) {
            System.out.println("库存为空！");
//            MainPage.maintenancePage();
        } else {
            System.out.println("\t商品编号\t\t商品名称\t\t商品价格\t\t商品数量\n");
            for (int i = 0; i < list.size(); i++) {
                Goods goods = list.get(i);
                System.out.println("\t" + goods.getgId() + "\t\t" + goods.getgName() + "\t\t" + goods.getgPrice() + "\t\t" + goods.getgNum());
                int num = goods.getgNum();
                if (num == 0) {
                    System.out.println(goods.getgName() + "已售空！");
                }
            }
        }
        System.out.println("------------------------------");
        do {
            System.out.println("输入 0 返回上一级菜单:");
            String choice = ScannerChoice.scannerInfoString();
            if ("0".equals(choice)) {
                MainPage.maintenancePage();
            }
            System.out.println("输入错误！请重新输入！");
        } while (true);
    }
}
