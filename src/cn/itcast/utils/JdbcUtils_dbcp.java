package cn.itcast.utils;

import org.apache.commons.dbcp.BasicDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class JdbcUtils_dbcp {

    private static DataSource ds = null;

    static {
        try {
            InputStream in = JdbcUtils_dbcp.class.getClassLoader().getResourceAsStream("dbcpConfig.properties");
            Properties prop = new Properties();
            prop.load(in);

            BasicDataSourceFactory factory = new BasicDataSourceFactory();

            //创建数据库连接池
            ds = factory.createDataSource(prop);
        } catch (Exception e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    public static Connection getConnection() throws Exception {
        return ds.getConnection();//不会把sql真正的connection返回
    }


    public static void release(Connection conn, Statement st, ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();   //throw new
            } catch (Exception e) {
                e.printStackTrace();
            }
            rs = null;
        }
        if (st != null) {
            try {
                st.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            st = null;
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
