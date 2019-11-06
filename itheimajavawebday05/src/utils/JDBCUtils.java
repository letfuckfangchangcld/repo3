package utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCUtils {
    private static DataSource ds;
    private static Properties ppt;
    static{
        try {
            //创建集合对象,用properties来加载配置文件
            ppt = new Properties();
            InputStream res = JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties");
            ppt.load(res);
                //创建常量池对象
                ds = DruidDataSourceFactory.createDataSource(ppt);

            } catch (Exception e) {
                e.printStackTrace();
            }finally {

            }
        }
        public static Connection getConnection() throws SQLException {
            return ds.getConnection();
        }
        public static void close(Connection conn, Statement stmt, ResultSet rs){
            if (conn!=null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (stmt!=null){
                try {
                    stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public static void close(Connection conn, Statement stmt){
        if (conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (stmt!=null){
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    //获取连接池的方法
    public static DataSource getDataSource(){
        return ds;
    }
}
