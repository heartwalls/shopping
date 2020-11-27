package com.eastcom.shopping.dao;

import com.eastcom.shopping.entity.SalesMan;
import com.eastcom.shopping.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SalesManDao {
    Connection connection = null;
    PreparedStatement ps = null;
    ResultSet resultSet = null;

    /**
     * 登陆
     * @param mName
     * @return
     */
    public ArrayList<SalesMan> cashRegisterLog(String mName) {
        ArrayList<SalesMan> salesManList = new ArrayList<>();
        connection = DBUtils.connection();
        String sql = "select mId,mPassword from salesman where mName=?";
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, mName);
            resultSet = ps.executeQuery();
            while (resultSet.next()) {
                int mId = resultSet.getInt("mId");
                String mPassword = resultSet.getString("mPassword");
                SalesMan salesMan = new SalesMan(mId, mPassword);
                salesManList.add(salesMan);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtils.closeConnect(ps, resultSet, connection);
        }
        return salesManList;
    }

    /**
     * 添加售货员
     * @param man
     * @return
     */
    public boolean addSalesMan(SalesMan man) {
        boolean bool = false;
        connection = DBUtils.connection();
        String add = "insert into salesman(mId, mName,mPassword) values(?,?,?)";
        try {
            ps = connection.prepareStatement(add);
            ps.setInt(1, man.getmId());
            ps.setString(2, man.getmName());
            ps.setString(3, man.getmPassword());
            int i = ps.executeUpdate();
            if (i > 0) {
                bool = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                DBUtils.close(ps, connection);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return bool;
    }

    /**
     * 修改售货员信息
     * @param id 根据id修改信息
     * @param salesMan
     * @return
     */
    public boolean updateSalesMan(int id, SalesMan salesMan) {
        boolean bool = false;
        connection = DBUtils.connection();
        String update = "update salesman set mName=?,mPassword=? where mId=?";
        try {
            ps = connection.prepareStatement(update);
            ps.setString(1, salesMan.getmName());
            ps.setString(2, salesMan.getmPassword());
            ps.setInt(3, salesMan.getmId());
            int i = ps.executeUpdate();
            if (i > 0) {
                bool = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                DBUtils.close(ps, connection);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return bool;
    }

    /**
     * 删除售货员
     * @param mName
     * @return
     */
    public boolean deleteSalesMan(String mName) {
        boolean bool = false;
        connection = DBUtils.connection();
        String delete = "DELETE FROM salesman WHERE mName=?";
        try
        {
            ps = connection.prepareStatement(delete);
            ps.setString(1,mName);
            int rs = ps.executeUpdate();
            if (rs > 0)
            {
                bool = true;
            }
        } catch (SQLException e)
        {
            e.printStackTrace();
        }finally{
            DBUtils.close(ps, connection);
        }
        return bool;
    }

    /**
     * 模糊查询售货员
     * @param mName
     * @return
     */
    public ArrayList<SalesMan> querySalesMan(String mName) {
        ArrayList<SalesMan> salesManList = new ArrayList<>();
        connection = DBUtils.connection();
        mName = "%" + mName + "%";
        String query = "select mId,mName,mPassword from salesman where mName like ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, mName);
            resultSet = ps.executeQuery();
            while (resultSet.next()) {
                int mId = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String mPassword = resultSet.getString(3);
                SalesMan salesMan = new SalesMan(mId, name, mPassword);
                salesManList.add(salesMan);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtils.closeConnect(ps, resultSet, connection);
        }
        return salesManList;
    }
}
