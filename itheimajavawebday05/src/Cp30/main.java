package Cp30;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class main {
    public static void main(String[] args) throws SQLException {
        //因为自动读取配置文件，所以直接创建对象
        DataSource cpds = new ComboPooledDataSource();
        //获取连接对象
        Connection conn = cpds.getConnection();
        //输出
        System.out.println(conn);
    }
}
