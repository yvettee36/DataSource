package cn.itcast.demo;

import cn.itcast.utils.JdbcUtils;
import cn.itcast.utils.JdbcUtils_c3p0;
import org.junit.Test;

import java.sql.*;

/**
 * Created by yvettee on 2017/9/30.
 */
public class TestMetaData {
    @Test

    public void testMetaData() throws Exception {
        Connection conn = null;
        conn = JdbcUtils_c3p0.getConnection();
        DatabaseMetaData meta = conn.getMetaData();
        System.out.println(meta.getDatabaseProductVersion());
        System.out.println(meta.getDatabaseMajorVersion());
        System.out.println(meta.getDatabaseMinorVersion());
        System.out.println(meta.getDatabaseProductName());
    }

    @Test
    public void testParameterData() throws Exception {
        Connection conn = JdbcUtils_c3p0.getConnection();
        String sql = "insert into user(id,name) values(?,?)";
        PreparedStatement ps = conn.prepareStatement(sql);

        //得到sql语句的参数元数据
        ParameterMetaData meta = ps.getParameterMetaData();
        //得到要往里面插入几个参数，也就是有几个问号
        System.out.println(meta.getParameterCount());
    }

    @Test
    public void testResultSetData() throws Exception {
        Connection conn = JdbcUtils_c3p0.getConnection();
        String sql = "select * from account";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        ResultSetMetaData meta = rs.getMetaData();

        //得到结果集的列数
        System.out.println(meta.getColumnCount());
        //得到每列的属性
        System.out.println(meta.getColumnName(1));
        System.out.println(meta.getColumnName(2));
        System.out.println(meta.getColumnName(3));

    }
}
