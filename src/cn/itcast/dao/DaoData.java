package cn.itcast.dao;


import cn.itcast.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.SQLException;

public class DaoData {
    public void add() {
        Connection conn = null;
        try {
            conn = JdbcUtils.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(conn.getClass().getName());
    }

}
