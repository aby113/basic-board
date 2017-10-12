package me.basicboard.www;

import static org.junit.Assert.assertNotNull;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class DbTest {

	private final String DRIVER = "com.mysql.jdbc.Driver";
	private final String URL = "jdbc:mysql://localhost:3306/boards";
	private final String USER = "boardMaster";
	private final String PW = "board";
	
	@Inject
	private DataSource ds;
	
	@Inject
	private SqlSession session;
	
	@Test
	public void jdbcTest()throws Exception{
		
		Class.forName(DRIVER);
		Connection conn = DriverManager.getConnection(URL, USER, PW);
		assertNotNull(conn);
		System.out.println(conn);
	}
	
	@Test
	public void testDs()throws Exception{
		assertNotNull(ds);
		System.out.println(ds);
	}
	
	@Test
	public void testSession()throws Exception{
		assertNotNull(session);
		System.out.println(session);
	}
	
	
	
}
