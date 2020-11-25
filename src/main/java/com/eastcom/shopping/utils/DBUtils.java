package com.eastcom.shopping.utils;

import java.sql.*;

public class DBUtils {

    private static final String username = "root";
    private static final String password = "root";
    private static final String url = "jdbc:mysql://localhost:3306/shopping";
    private static final String driver = "com.mysql.jdbc.Driver";
    //MySQL 8.0 以上版本 - JDBC 驱动名及数据库 URL
    //private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";

    /**
     * 连接数据库
     * @return
     */
    public static Connection connection() {
        Connection connection = null;
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return connection;
    }

    /**
     * 关闭
     * @param preparedStatement
     * @param connection
     */
    public static void close(PreparedStatement preparedStatement, Connection connection) {
        if (preparedStatement != null) {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 关闭数据库连接
     * @param preparedStatement
     * @param resultSet
     * @param connection
     */
    public static void closeConnect(PreparedStatement preparedStatement, ResultSet resultSet, Connection connection) {
        if (preparedStatement != null) {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
