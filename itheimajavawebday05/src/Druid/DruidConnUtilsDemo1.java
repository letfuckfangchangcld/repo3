package Druid;

import utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DruidConnUtilsDemo1 {
    public static void main(String[] args) {
        Connection conn=null;
        PreparedStatement pps=null;
        try {
            //创建连接,获取连接对象
            conn = JDBCUtils.getConnection();
            //创立SQL语句
            String sql="update boc set acoount=? where name=?";
            //建立SQL语句配置对象
            pps = conn.prepareStatement(sql);
            //给SQL语句赋值
            pps.setInt(1,2000);
            pps.setString(2,"王五");
            //执行SQLyuju
            pps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(conn,pps);
        }
    }
}
