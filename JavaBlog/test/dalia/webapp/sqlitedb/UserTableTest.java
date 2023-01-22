package dalia.webapp.sqlitedb;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import org.junit.jupiter.api.Test;

import dalia.javablog.sqlitedb.User;
import dalia.javablog.sqlitedb.UserTable;

class UserTableTest {
	static UserTable testTable = new UserTable();
	static String testUrl = "jdbc:sqlite:////home/dalia/git/JavaBlog/JavaBlog/db/test.db";
	static User userPrototype = new User();
	static User testUser = new User();
	static String testUsername = "TestUser";
	static String testPassword = "password";
	// number of test users to create
	static int userNum = 5;
	
	@BeforeAll
	static void setUpBeforeClass() {
		// WARNING: Don't forget to set test url, otherwise main db records will be deleted
		testTable.setConnectionUrl(testUrl);
		testTable.createTable();
		for (int i = 1; i <= userNum; i++) {
			userPrototype.setUsername(testUsername + String.valueOf(i));
			userPrototype.setPassword(testPassword + String.valueOf(i));
			testTable.createUser(userPrototype);
		}
	}
	
	@AfterAll
	static void tearDownAfterClass() {
		testTable.dropTable();
	}

	@Test
	void testGetUserByName() {
		String loopName;
		String loopPassword;
		for (int i = 1; i <= userNum; i++) {
			loopName = testUsername + String.valueOf(i);
			loopPassword = testPassword + String.valueOf(i);
			testUser = testTable.getUserByName(loopName);
			testUser.printUser();
			assertEquals(loopName, testUser.getUsername());
			assertEquals(loopPassword, testUser.getPassword());
		}
	}
	
	@Test
	void testGetAllUsers() {
		ArrayList<User> testUsers = testTable.getAllUsers();
		assertEquals(userNum, testUsers.size());
	}
	
	@Test
	void testGetUserById() {
		String localTestName = testUsername + 1;
		String localTestPassword = testPassword + 1;
		int testId = testTable.getUserByName(localTestName).getId();
		testUser = testTable.getUserById(testId);
		assertEquals(localTestName, testUser.getUsername());
		assertEquals(localTestPassword, testUser.getPassword());
	}
}
