package Cp30;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.mchange.v2.c3p0.DataSources;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class Cp30ConnDemo {
    public static void main(String[] args) throws SQLException {
        //建立数据库连接池对象
        DataSource cpds = new ComboPooledDataSource();
        //获取连接对象
        Connection conn = cpds.getConnection();
        System.out.println(conn);
    }
}
