package cn.itcast.demo;

import cn.itcast.utils.JdbcUtils_c3p0;
import cn.itcast.utils.JdbcUtils_dbcp;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created by yvettee on 2017/9/28.
 */
public class TestDataSource {

    @Test
    public void TestDataSource() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtils_c3p0.getConnection();
            System.out.println(conn.getClass().getName());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtils_dbcp.release(conn, ps, rs);
        }
    }
}
