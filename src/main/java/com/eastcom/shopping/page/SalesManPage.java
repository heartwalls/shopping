package com.eastcom.shopping.page;

import com.eastcom.shopping.dao.SalesManDao;
import com.eastcom.shopping.entity.SalesMan;
import com.eastcom.shopping.utils.ScannerChoice;

import java.util.ArrayList;

public class SalesManPage extends ScannerChoice {
    /**
     * 添加售货员
     */
    public static void addSalesManPage() {
        System.out.println("\t正在执行添加售货员操作\n");
        System.out.println("\n添加售货员-工号");
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
        System.out.println("\t正在执行更改售货员操作\n");
        System.out.println("请输入想要更改的售货员名字");
        String mName = ScannerChoice.scannerInfoString();
        ArrayList<SalesMan> list = new SalesManDao().querySalesMan(mName);
        if (list.size() <= 0) {
            System.err.println("\t！！查无此人！！");
            ScannerChoice.choiceSalesManNext("updateSalesManPage");
        } else {
            System.out.println("\t\t\t售货员信息\n\n");
            System.out.println("\t售货员编号\t\t售货员姓名\t\t售货员密码");
            // 查询出来的数据只有一个值
            SalesMan salesMan = list.get(0);
            System.out.println("\t"+salesMan.getmId()+"\t\t\t\t"+salesMan.getmName()+"\t\t\t\t"+salesMan.getmPassword());
            System.out.println();

            System.out.println("\n--------请更改售货员信息\n");
            System.out.println("\t1.更改售货员信息");
            System.out.println("\t0.返回上一级菜单");
            do {
                String choice = ScannerChoice.scannerInfoString();
                String regex = "[0-1]";
                if (choice.matches(regex)) {
                    int info = Integer.parseInt(choice);
                    switch (info) {
                        case 0:
                            MainPage.salesManManagementPage();
                            break;
                        case 1:
                            System.out.println("更改售货员-新工号");
                            int id = ScannerChoice.scannerNum();
                            System.out.println("更改售货员-新姓名");
                            String newName = ScannerChoice.scannerInfoString();
                            System.out.println("更改售货员-新密码");
                            String newPassword = ScannerChoice.scannerInfoString();
                            boolean b = new SalesManDao().updateSalesMan(id, new SalesMan(id, newName, newPassword));
                            if (b) {
                                System.out.println("更新售货员信息成功！");
                            } else {
                                System.out.println("更新售货员信息失败！");
                            }
                    }
                } else {
                    System.out.println("输入错误！请重新输入！");
                }
                ScannerChoice.choiceSalesManNext("updateSalesManPage");
            } while (true);
        }
    }

    /**
     * 删除售货员
     */
    public static void deleteSalesManPage() {
        System.out.println("\t正在执行 删除售货员 操作\n");
        System.out.println("请输入想要删除的售货员名字");
        // TODO
        // 查询时可以模糊查询，但是删除时会删除失败，必须以全名搜索才能删除
        String mName = ScannerChoice.scannerInfoString();
        ArrayList<SalesMan> man = new SalesManDao().querySalesMan(mName);
        if (man.size() <= 0) {
            System.err.println("\t！！查无此人！！");
            ScannerChoice.choiceSalesManNext("deleteSalesManPage");
        } else {
            System.out.println("\t\t\t删除售货员信息\n\n");
            System.out.println("\t售货员编号\t\t售货员姓名");
            for (int i = 0; i < man.size(); i++) {
                SalesMan salesMan = man.get(i);
                System.out.println("\t"+salesMan.getmId()+"\t\t\t\t"+salesMan.getmName());
                System.out.println();
            }
            do {
                System.out.println("\n确认删除该售货员：Y/N");
                String choice = ScannerChoice.scannerInfoString();
                if ("y".equals(choice) || "Y".equals(choice)) {
                    boolean b = new SalesManDao().deleteSalesMan(mName);
                    if (b) {
                        System.err.println("\t！！已成功刪除该售货员！！\n");
                    } else {
                        System.err.println("\t！！刪除该售货员失敗！！");
                    }
                    ScannerChoice.choiceSalesManNext("deleteSalesManPage");
                } else if ("N".equals(choice) || "n".equals(choice)) {
                    MainPage.salesManManagementPage();
                }
                System.err.println("\t!!输入有误,请重新输入!!");
            } while (true);
        }
    }

    /**
     * 查询售货员信息
     */
    public static void querySalesManPage() {
        System.out.println("\t\t  正在执行查询售货员操作\n");
        System.out.println("要查询的售货员关键字");
        String mName = scannerInfoString();
        ArrayList<SalesMan> list = new SalesManDao().querySalesMan(mName);
        if (list.size() <= 0) {
            System.err.println("\t！没有人员符合查询条件！");
        } else {
            System.out.println("\t\t\t所有售货员列表\n\n");
            System.out.println("\t售货员编号\t\t售货员姓名");
            for (int i = 0; i < list.size(); i++) {
                SalesMan salesMan = list.get(i);
                System.out.println("\t"+salesMan.getmId()+"\t\t\t\t"+salesMan.getmName());
            }
        }
        ScannerChoice.choiceSalesManNext("querySalesManPage");
    }

    /**
     * 列出所有售货员信息
     */
    public static void displaySalesManPage() {
        ArrayList<SalesMan> salesManList = new SalesManDao().displaySaleMan();
        if (salesManList.size() <= 0) {
            System.err.println("\t！！售货员列表为空！！");
            MainPage.salesManManagementPage();
        } else {
            System.out.println("\t\t\t所有售货员列表\n\n");
            System.out.println("\t售货员编号\t\t售货员姓名");
            for (int i = 0; i < salesManList.size(); i++) {
                SalesMan salesMan = salesManList.get(i);
                System.out.println("\t"+salesMan.getmId()+"\t\t\t\t"+salesMan.getmName());
                System.out.println();
            }
            do {
                System.out.println("\n\n输入 0 返回上一级菜单");
                String choice = scannerInfoString();
                if ("0".equals(choice)) {
                    MainPage.salesManManagementPage();
                } else {
                    System.err.print("\t输入有误！");
                }
            } while (true);
        }
    }
}
