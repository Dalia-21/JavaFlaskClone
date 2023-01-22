package dalia.webapp.sqlitedb;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;

class UserTableTest {
	Connection conn = null;
	
	@BeforeAll
	void getConnection() {
		String url = "jdbc:sqlite:////home/dalia/git/JavaBlog/JavaBlog/db/test.db";
		DBConnection testdb  = new DBConnection();
		testdb.setUrl(url);
		try {
			conn = testdb.connect();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@BeforeAll
	void deleteRecords() {
		
	}
	
	@Test
	void test() {
		fail("Not yet implemented");
	}

}
