package com.roy.tools.services.impl;

import com.roy.tools.moduls.Commodity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import java.util.List;

/**
 * Created by roy on 2018/1/4.
 */
@Service
public class DbConnection {

    @Autowired
    private Search search;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void testOracle(String jndi,String duns) {
        Connection con = null;// 创建一个数据库连接

        try {
            String[] urls = jndi.split(";");
            String driverClassName = urls[0].replaceAll("driverClassName=", "");
            String url = urls[1].replaceAll("url=", "");
            String username = urls[2].replaceAll("username=", "");
            String password = "mysdc";
            for(String val:urls){
                if(val.startsWith("username"))
                    username=val.replaceAll("username=", "");
                else if(val.startsWith("password"))
                    password=val.replaceAll("password=", "");
            }
            Class.forName(driverClassName);// 加载Oracle驱动程序

            System.out.println("开始尝试连接数据库！");
//            String url = "jdbc:oracle:" + "thin:@10.63.72.14:1521:orclbaoji";// 127.0.0.1是本机地址，XE是精简版Oracle的默认数据库名
//            String user = "ehr_linyouxian";// 用户名,系统默认的账户名
//            String password = "mysdc";// 你安装时选设置的密码
            con = DriverManager.getConnection(url, username, password);// 获取连接

            System.out.println("连接成功！");

            List<Commodity> commodityList = search.getEhrModul();
            for(Commodity commodity : commodityList) {
                PreparedStatement pre = null;// 创建预编译语句对象，一般都是用这个而不用Statement
                ResultSet result = null;// 创建一个结果集对象
                String sql = "";
                try {

                    sql = "select max(" + commodity.getCountCol().trim() + ") from " + commodity.getTableName();// 预编译语句，“？”代表参数
                    pre = con.prepareStatement(sql);// 实例化预编译语句
                    result = pre.executeQuery();// 执行查询，注意括号中不需要再加参数
                    while (result.next()) {
                        if (commodity.getCountColType().contains("DATE")) {
                            Date resVal = result.getTimestamp("max("+commodity.getCountCol()+")");
                            System.out.println("表名:" + commodity.getTableName() + " 列名:" + commodity.getCountCol() + " 值:" + resVal);
                            String ressql = "update etl_his set STATUS = '1' , COUNT_COL = '"+commodity.getCountCol()+"' ,COUNT_COL_TYPE = '"+commodity.getCountColType()+"' ,LAST_VAL = '"+resVal+ "' where DUNS = '"+duns+"' and table_name = '"+commodity.getTableName()+"'";
                            System.out.println(ressql);
                            int re = jdbcTemplate.update(ressql);
                            System.out.println("更新结果:"+re);
                        } else {
                            String lastVal = result.getString("max("+commodity.getCountCol()+")");
                            System.out.println("表名:" + commodity.getTableName() + " 列名:" + commodity.getCountCol() + " 值:" + lastVal);
                            String ressql = "update etl_his set STATUS = '1' , COUNT_COL = '"+commodity.getCountCol()+"' ,COUNT_COL_TYPE = '"+commodity.getCountColType()+"' ,LAST_VAL = '"+lastVal+ "' where DUNS = '"+duns+"' and table_name = '"+commodity.getTableName()+"'";
                            System.out.println(ressql);
                            int re = jdbcTemplate.update(ressql);
                            System.out.println("更新结果:"+re);
                        }
                    }
                }catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("sql异常了:"+sql);
                    try {
                        // 逐一将上面的几个对象关闭，因为不关闭的话会影响性能、并且占用资源
                        // 注意关闭的顺序，最后使用的最先关闭
                        if (result != null)
                            result.close();
                        if (pre != null)
                            pre.close();
                        System.out.println("已关闭！");
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
                } finally {
                    if (result != null)
                        result.close();
                    if (pre != null)
                        pre.close();
                }
            }
//            String sql = "select max(CREATED_DATE) as CREATED_DATE from ETLSYNHISTORY";// 预编译语句，“？”代表参数
//            pre = con.prepareStatement(sql);// 实例化预编译语句
//            pre.setString(1, "小茗同学");// 设置参数，前面的1表示参数的索引，而不是表中列名的索引
//            result = pre.executeQuery();// 执行查询，注意括号中不需要再加参数
//            while (result.next())
                // 当结果集不为空时
//                System.out.println(" last_val " + result.getTimestamp("CREATED_DATE"));
//                System.out.println("学号:" + result.getInt("id") + "姓名:"
//                        + result.getString("name"));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // 逐一将上面的几个对象关闭，因为不关闭的话会影响性能、并且占用资源
                // 注意关闭的顺序，最后使用的最先关闭
//                if (result != null)
//                    result.close();
//                if (pre != null)
//                    pre.close();
                if (con != null)
                    con.close();
                System.out.println("数据库连接已关闭！");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
