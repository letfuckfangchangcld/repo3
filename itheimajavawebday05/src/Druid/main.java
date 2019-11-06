package Druid;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Scanner;

public class main {
    public static void main(String[] args) throws Exception {
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print((j + "*" + i + "=" + (i * j)));
                System.out.print("\t");
            }
            System.out.println("");
        }
    }
}
