package dalia.webapp.sqlitedb;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;

class UserTableTest {
	UserTable testTable = new UserTable();
	
	@BeforeAll
	void getConnection() {
		// WARNING: Don't forget to set test url, otherwise main db records will be deleted
		String url = "jdbc:sqlite:////home/dalia/git/JavaBlog/JavaBlog/db/test.db";
		testTable.setConnectionUrl(url);
	}

	@BeforeAll
	void deleteRecords() {
		testTable.deleteAllUsers();
	}
	
	@Test
	void test() {
		fail("Not yet implemented");
	}

}
