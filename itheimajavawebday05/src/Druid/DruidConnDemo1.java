package Druid;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

public class DruidConnDemo1 {
    public static void main(String[] args) throws Exception {
        //因为Driuid不能自动读取配置的文件，所以要自己导入,
        Properties pro = new Properties();
        InputStream is = DruidConnDemo1.class.getClassLoader().getResourceAsStream("druid.properties");
        pro.load(is);
        //获取连接池对象
        DataSource ds = DruidDataSourceFactory.createDataSource(pro);

        Connection conn = ds.getConnection();
        System.out.println(conn);

    }
}
