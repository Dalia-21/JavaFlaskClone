package dalia.webapp.sqlitedb;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;

class DBConnectionTest {

	String testUrl = "jdbc:sqlite:////home/dalia/git/JavaBlog/JavaBlog/db/test.db";
	String invalidUrl = "jdbc:sqlite:////home/dalia/git/JavaBlog/JavaBlog/nonExistentFolder/test.db";

	@Test
	void testConnect() {
		DBConnection db = new DBConnection();
		Connection conn = null;
		try {
			conn = db.connect();
			assertTrue(conn.isValid(0));
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	void testConnectWithURL() {
		// Valid test
		DBConnection testdb = new DBConnection();
		Connection testConn = null;
		testdb.setUrl(testUrl);
		try {
			testConn = testdb.connect();
			assertTrue(testConn.isValid(0));
			testConn.close();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
	
	@Test
	void testConnectException() {
		DBConnection invalidDB = new DBConnection();
		invalidDB.setUrl(invalidUrl);
		assertThrows(SQLException.class, ()->invalidDB.connect(), "Expected exception to be thrown for invalid url path.");
		}

}
