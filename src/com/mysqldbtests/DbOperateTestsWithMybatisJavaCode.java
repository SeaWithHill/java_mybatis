/**  
 * @Title: DbOperateTests.java
 * @Package cn.com.yusys.yusp.yuin.db.tests
 * @Description: TODO
 * @author mabf
 * @date 2019年4月28日
 */
package com.mysqldbtests;
/** 
*@author  mabf
*@date 创建时间：2019年4月28日 上午1:34:43 
*@version 1.0 
*@parameter  
*@since 
*@return 
*/
/**
 * ClassName: DbOperateTests 
 * @Description: TODO
 * @author mabf
 * @date 2019年4月28日
 */

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

 
public class DbOperateTestsWithMybatisJavaCode
{
	private static String table = "";
	private static Connection connect = null;
	private static InputStream inputStream = null;
	private static PreparedStatement prestmt = null;
    private static SqlSessionFactory factory = null;
    private static Statement stmt = null;
    
    
    static {
//		try {
//	        Proxy.newProxyInstance(loader, interfaces, handler);
//
//			DataSource dataSource = BlogDataSourceFactory.getBlogDataSource();
//			TransactionFactory transactionFactory = new JdbcTransactionFactory();
//			Environment environment = new Environment("development", transactionFactory, dataSource);
//			Configuration configuration = new Configuration(environment);
//			configuration.addMapper(BlogMapper.class);
//			factory = new SqlSessionFactoryBuilder().build(configuration);//需创建为单例模式
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
    }
    
    /**
     * @return
         * 返回sqlsessionfactory的单例模式
     */
    private static SqlSessionFactory getSqlSessionFactory() {
    	return DbOperateTestsWithMybatisJavaCode.factory;
    }
    
    @BeforeClass
    public static void startCall() {
        System.out.println("开始调用并设置全局变量");
      
        try
        {
            Connection con = DriverManager.getConnection("jdbc:mysql://47.98.125.109:3306/YUIN", "root", "rootroot");
            Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
            List arrlist = new ArrayList();
            ResultSet rs=st.executeQuery("select * from PUBSPDPARM");           
            while (rs.next())
            {
                System.out.println(rs.getString("sysid"));
                arrlist.add(rs.getString("sysid"));
            } 
        } catch (SQLException e)
        {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        }
        
   
    }

    /**
    	 * Briefly: <一句话简述>
     * Description: <功能详细描述>
    	 * @author : mabf
     */
    
    @Test
    public void testSelectDbparm()
    {
//        String sql = "select * from PUBSPDPARM";
////        connect = sqlSessionFactory.openSession().getConnection();
//        try
//        {
//              System.out.println("createPreparedStatement");
//            // 创建statement
//            stmt = DBUtil.createPreparedStatement("MYSQL", connect, sql, new HashMap<String, Object>());
//            // 执行SQL
//            ResultSet rs = stmt.executeQuery(sql);
//        } catch (SQLException e)
//        {
//            // TODO 自动生成的 catch 块
//            e.printStackTrace();
//        } catch (Exception e)
//        {
//            // TODO 自动生成的 catch 块
//            e.printStackTrace();
//        }
        System.out.println("test");

    }
    
    @AfterClass
    public static void endCall() {
//        try
//        {
//            connect.close();
//        } catch (SQLException e)
//        {
//            // TODO 自动生成的 catch 块
//            e.printStackTrace();
//        }
//        try
//        {
//            inputStream.close();
//        } catch (IOException e)
//        {
//            // TODO 自动生成的 catch 块
//            e.printStackTrace();
//        }
//        try
//        {
//            stmt.close();
//        } catch (SQLException e)
//        {
//            // TODO 自动生成的 catch 块
//            e.printStackTrace();
//        }
        System.out.println("结束调用并清空全局变量");
    }
}
