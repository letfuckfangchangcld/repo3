package Template;

import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import utils.JDBCUtils;

import java.util.List;
import java.util.Map;

public class JdbcTemplateCRUDDemo1 {
    //创建牛皮的对象
    JdbcTemplate jt = new JdbcTemplate(JDBCUtils.getDataSource());

    //1.将孙悟空的工资修改为10000
    @Test
    public void test1() {
        String sql1 = "update emp set salary=10000 where id=?";
        jt.update(sql1, 1001);
    }

    //2.添加一条记录
    @Test
    public void test2() {
        String sql2 = "insert into emp(id,ename,job_id,mgr,joindate,salary,bonus,dept_id)values(?,?,?,?,?,?,?,?)";
        jt.update(sql2, 1015, "如来佛祖", 4, 1009, null, 99999, 99999, 20);
    }

    //4.查询id为1的记录，将其封装为MAP集合,这个方法只能打印一条信息！！！
    @Test
    public void test3() {
        String sql3 = "select * from emp where id=?";
        //List<Map<String, Object>> maps = jt.queryForList(sql3, 1001);
        Map<String, Object> stringObjectMap = jt.queryForMap(sql3, 1001);
        System.out.println(stringObjectMap);
    }

    //5.查询所有记录，将其封装为List集合
    @Test
    public void test4() {
        String sql3 = "select * from emp";
        List<Map<String, Object>> maps = jt.queryForList(sql3);
        for (Map<String, Object> m : maps) {
            System.out.println(m);
        }
    }

    //6.查询所有记录，将其封装为EMP对象的List集合
    @Test
    public void test5() {
        String sql4 = "select * from emp";
        List<Emp> empList = jt.query(sql4, new BeanPropertyRowMapper<Emp>(Emp.class));
        for (Emp e : empList) {
            System.out.println(e);
        }
    }

    //7.查询总记录数
    @Test
    public void test6() {
        String sql = "select count(id)from emp";
        Integer num = jt.queryForObject(sql, Integer.class);
        System.out.println(num);
    }
}
