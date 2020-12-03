package com.eastcom.shopping.dao;

import com.eastcom.shopping.entity.Goods;
import com.eastcom.shopping.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class GoodsDao {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    /**
     * 新增商品
     * @param goods
     * @return
     */
    public boolean addGoods(Goods goods) {
        boolean bool = false;
        connection = DBUtils.connection();
        String insert = "INSERT INTO goods(gName,gPrice,gNum) VALUES (?,?,?)";
        try {
            preparedStatement = connection.prepareStatement(insert);
            preparedStatement.setString(1, goods.getgName());
            preparedStatement.setDouble(2, goods.getgPrice());
            preparedStatement.setInt(3, goods.getgNum());
            int i = preparedStatement.executeUpdate();
            if (i > 0) {
                bool = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                DBUtils.close(preparedStatement, connection);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return bool;
    }

    /**
     * 更新商品
     * @param goods
     * @return
     */
    public boolean updateGoods(int id, Goods goods) {
        boolean bool = false;
        connection = DBUtils.connection();
        String update = "UPDATE goods set gName=?,gPrice=?,gNum=? where gId=?";
        try {
            preparedStatement = connection.prepareStatement(update);
            preparedStatement.setString(1, goods.getgName());
            preparedStatement.setDouble(2, goods.getgPrice());
            preparedStatement.setInt(3, goods.getgNum());
            preparedStatement.setInt(4, id);
            int i = preparedStatement.executeUpdate();
            if (i > 0) {
                bool = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                DBUtils.close(preparedStatement, connection);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return bool;
    }

    /**
     * 删除商品
     * @param gId
     * @return
     */
    public boolean deleteGoods(int gId) {
        boolean bool = false;
        connection = DBUtils.connection();
        String delete = "delete from goods where gid=?";
        try {
            preparedStatement = connection.prepareStatement(delete);
            preparedStatement.setInt(1, gId);
            int i = preparedStatement.executeUpdate();
            if (i > 0) {
                bool = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                DBUtils.close(preparedStatement, connection);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return bool;
    }

    /**
     * 根据名称查找商品
     * @param name
     * @return
     */
    public ArrayList<Goods> selectGoodsByName(String name) {
        ArrayList<Goods> goodsList = new ArrayList<>();
        connection = DBUtils.connection();
        String selectName = "select * from goods where gName=?";
        try {
            preparedStatement = connection.prepareStatement(selectName);
            preparedStatement.setString(1, name);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String gName = resultSet.getString(2);
                double price = resultSet.getDouble(3);
                int num = resultSet.getInt(4);
                Goods goods = new Goods(id, gName, price, num);
                goodsList.add(goods);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtils.closeConnect(preparedStatement, resultSet, connection);
        }
        return goodsList;
    }


    /**
     * 查询商品信息
     * @param
     * @return
     */
    public ArrayList<Goods> queryGoods(int key) {
        ArrayList<Goods> list = new ArrayList<Goods>();
        connection = DBUtils.connection();
        String sortByName = "select gId,gName,gPrice,gNum from goods order by gName";
        String sortByPrice = "select gId,gName,gPrice,gNum from goods order by gPrice";
        String sortByNum = "select gId,gName,gPrice,gNum from goods order by gNum";
        try {
            if (key == 1) {
                preparedStatement = connection.prepareStatement(sortByName);
            } else if (key == 2) {
                preparedStatement = connection.prepareStatement(sortByPrice);
            } else if (key == 3) {
                preparedStatement = connection.prepareStatement(sortByNum);
            }
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int gId = resultSet.getInt("gId");
                String gName = resultSet.getString(2);
                double gPrice = resultSet.getDouble(3);
                int gNum = resultSet.getInt(4);

                Goods goods = new Goods(gId, gName, gPrice, gNum);
                list.add(goods);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                DBUtils.closeConnect(preparedStatement, resultSet, connection);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return list;
    }

    /**
     * 展示所有商品
     * @return
     */
    public ArrayList<Goods> displayGoods() {
        ArrayList<Goods> list = new ArrayList<Goods>();
        connection = DBUtils.connection();
        String selectAll = "select * from goods";
        try {
            preparedStatement = connection.prepareStatement(selectAll);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int gId = resultSet.getInt(1);
                String gName = resultSet.getString(2);
                double gPrice = resultSet.getDouble(3);
                int gNum = resultSet.getInt(4);

                Goods goods = new Goods(gId, gName, gPrice, gNum);
                list.add(goods);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                DBUtils.closeConnect(preparedStatement, resultSet, connection);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return list;
    }
}
