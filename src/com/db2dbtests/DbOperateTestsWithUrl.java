/**  
 * @Title: DbOperateTests.java
 * @Package cn.com.yusys.yusp.yuin.db.tests
 * @Description: TODO
 * @author mabf
 * @date 2019年4月28日
 */
package com.db2dbtests;

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

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class DbOperateTestsWithUrl
{
    public static String table = "";
    public static Connection con = null;
    public static Statement stmt = null;

    @BeforeClass
    public static void startCall()
    {
        System.out.println("开始调用并设置全局变量");
        // inputStream = new FileInputStream( new File("D:\\config\\mybatis.xml"));
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://47.98.125.109:3306/YUIN", "root", "rootroot");
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            table = "PUBSPDPARM";
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
     * Briefly: 查询PUBSPDPARM产品参数表
     * 
     * @author : mabf
     */

    @Test
    public void testSelectDbparm()
    {
        String sql = String.format("select * from %s", table);
        List arrlist = new ArrayList();
        try
        {
            ResultSet rs = stmt.executeQuery(sql);
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
    
    

    @AfterClass
    public static void endCall()
    {
        try
        {
            con.close();
            stmt.close();
        } catch (SQLException e)
        {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        }
        System.out.println("结束调用并清空全局变量");
    }
}
