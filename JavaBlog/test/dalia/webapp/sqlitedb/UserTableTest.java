package dalia.webapp.sqlitedb;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import org.junit.jupiter.api.Test;

class UserTableTest {
	static UserTable testTable = new UserTable();
	static User initialUser = new User();
	static User testUser = new User();
	static String testUsername = "TestUser";
	static String testPassword = "password";
	static int testId;
	
	@BeforeAll
	static void setUrl() {
		// WARNING: Don't forget to set test url, otherwise main db records will be deleted
		String url = "jdbc:sqlite:////home/dalia/git/JavaBlog/JavaBlog/db/test.db";
		testTable.setConnectionUrl(url);
	}
	
	@BeforeAll
	static void createTable() {
		testTable.createTable();
	}

	@BeforeAll
	static void deleteRecords() {
		testTable.deleteAllUsers();
	}
	
	@BeforeAll
	static void setUserAttributes() {
		initialUser.setUsername(testUsername);
		initialUser.setPassword(testPassword);
		testTable.createUser(initialUser);
	}
	
	@Test
	void testGetUserByName() {
		testUser = testTable.getUserByName(testUsername);
		testId = testUser.getId();
		assertEquals(testUsername, testUser.getUsername(), "Returned username does not match");
		assertEquals(testPassword, testUser.getPassword(), "Returned password does not match");
	}

	@AfterAll
	static void dropTable() {
		testTable.dropTable();
	}
}
