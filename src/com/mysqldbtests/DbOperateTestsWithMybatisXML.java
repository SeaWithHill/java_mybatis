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

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;


public class DbOperateTestsWithMybatisXML {
	private static InputStream inputStream = null;
	private static SqlSessionFactory factory = null;
    private static Logger log = Logger.getLogger(DbOperateTestsWithMybatisXML.class.getName());

	public static void main(String[] args) {
		System.out.println("test");
		try {
			inputStream = new FileInputStream(
					new File("D:\\java_workspace\\py_to_java\\java_mybatis\\src\\com\\mysqldbtests\\mybatis.xml"));
			SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
			factory = builder.build(inputStream);// 需创建为单例模式
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
    
    
	static {
		try {
			inputStream = new FileInputStream(
					new File("D:\\java_workspace\\py_to_java\\java_mybatis\\src\\com\\mysqldbtests\\mybatis.xml"));
			SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
			factory = builder.build(inputStream);// 需创建为单例模式
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @return 返回sqlsessionfactory的单例模式
	 */
	private static SqlSessionFactory getSqlSessionFactory() {
		return DbOperateTestsWithMybatisXML.factory;
	}

	@BeforeClass
	public static void startCall() {
		log.info("开始调用并设置全局变量");
	}

	/**
	 * Briefly: 按照id查找记录
	 * 
	 * @author : mabf
	 */

	@Test
	public void testSelectBlog() {
		log.info("===============testSelectBlog===============");
		SqlSession session = factory.openSession();
		try {
			BlogMapper mapper = session.getMapper(BlogMapper.class);
			List<Blog> blog = mapper.selectBlog(101);
			for (int i = 0; i < blog.size(); i++) {
				log.info(blog.get(i).toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	
	
	/**
	 * Briefly:按照两个id查找记录
	 * 
	 * @author : mabf
	 */

	@Test
	public void testSelectBlogTwo() {
		log.info("===============testSelectBlogTwo===============");
		SqlSession session = factory.openSession();
		try {
			BlogMapper mapper = session.getMapper(BlogMapper.class);
			List<Blog> blog = mapper.selectBlogTwo(101, 102);
			for (int i = 0; i < blog.size(); i++) {
				log.info(blog.get(i).toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	@AfterClass
	public static void endCall() {
		log.info("结束调用并清空全局变量");
	}
	
	/**
	 * Briefly:通过列表来实现查询查询
	 * 
	 * @author : mabf
	 */

	@Test
	public void testselectBlogMultiByList() {
		log.info("===============testSelectBlogMulti===============");
		SqlSession session = factory.openSession();
		List<String> list = new ArrayList<>();
		list.add("101");
		list.add("102");
		list.add("103");
		try {
			BlogMapper mapper = session.getMapper(BlogMapper.class);
			List<Blog> blog = mapper.selectBlogMultiByList(list);
			for (int i = 0; i < blog.size(); i++) {
				log.info(blog.get(i).toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	
	
	/**
	 * Briefly:通过数组来实现查询
	 * 
	 * @author : mabf
	 */

	@Test
	public void testselectBlogMultiByArray() {
		log.info("===============selectBlogMultiByArray===============");
		SqlSession session = factory.openSession();
		String[] idArrays = new String[] {"101","103"};
		try {
			BlogMapper mapper = session.getMapper(BlogMapper.class);
			List<Blog> blog = mapper.selectBlogMultiByArray(idArrays);
			for (int i = 0; i < blog.size(); i++) {
				log.info(blog.get(i).toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	
	/**
	 * 
	 * Briefly: 通过对入参进行注解来实现查询
	 * @author : mabf
	 */
	@Test
	public void testselectBlogMultiParamByAnnotation() {
		log.info("===============selectBlogMultiParamByAnnotation===============");
		SqlSession session = factory.openSession();
		String name = "卑鄙的圣人曹操";
		String[] idArrays = new String[] {"101","103"};
		try {
			BlogMapper mapper = session.getMapper(BlogMapper.class);
			List<Blog> blog = mapper.selectBlogMultiParamByAnnotation(name, idArrays);
			for (int i = 0; i < blog.size(); i++) {
				log.info(blog.get(i).toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	
	

	/**
	 * 
	 * Briefly: 通过map对象来实现查询
	 * @author : mabf
	 */
	@Test
	public void testselectBlogMultiParamByMap() {
		log.info("===============selectBlogMultiParamByMap===============");
		SqlSession session = factory.openSession();
		String title = "卑鄙的圣人曹操";
		String[] idArrays = new String[] {"101","103"};
		try {
			BlogMapper mapper = session.getMapper(BlogMapper.class);
			Map<String, Object> params = new HashMap<String, Object>(2);
			params.put("title", title);
			params.put("idList", idArrays);
			List<Blog> blog = mapper.selectBlogMultiParamByMap(params);
			for (int i = 0; i < blog.size(); i++) {
				log.info(blog.get(i).toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	
}
