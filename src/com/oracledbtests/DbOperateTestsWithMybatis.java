/**  
 * @Title: DbOperateTests.java
 * @Package cn.com.yusys.yusp.yuin.db.tests
 * @Description: TODO
 * @author mabf
 * @date 2019年4月28日
 */
package com.oracledbtests;
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

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

 
public class DbOperateTestsWithMybatis
{
    public static String table = "";
    public static Connection connect = null;
    public static InputStream inputStream = null;
    public static PreparedStatement prestmt = null;
    public static Statement stmt = null;
    
    @BeforeClass
    public static void startCall() {
        System.out.println("开始调用并设置全局变量");
//        inputStream = new FileInputStream( new File("D:\\config\\mybatis.xml"));
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
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
        } catch (ClassNotFoundException e)
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
