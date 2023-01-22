package dalia.webapp.sqlitedb;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

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
	// number of test users to create
	static int userNum = 5;
	
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
	static void createUsers() {
		for (int i = 1; i <= userNum; i++) {
			initialUser.setUsername(testUsername + i);
			initialUser.setPassword(testPassword + i);
			testTable.createUser(initialUser);
		}
	}
	
	@Test
	void testGetUserByName() {
		for (int i = 1; i <= userNum; i++) {
			testUser = testTable.getUserByName(testUsername + i);
			assertEquals(testUsername + i, testUser.getUsername(),
					String.format("Returned username %s does not match expected %s", testUsername+i, testUser.getUsername()));
			assertEquals(testPassword + i, testUser.getPassword(),
					String.format("Returned password %s does not match expected %s", testPassword+i, testUser.getPassword()));
		}
	}
	
	@Test
	void testGetAllUsers() {
		ArrayList<User> testUsers = testTable.getAllUsers();
		assertEquals(userNum, testUsers.size(),
				String.format("Expected number of users %d does not match actual, %d", userNum, testUsers.size()));
	}

	@AfterAll
	static void dropTable() {
		testTable.dropTable();
	}
}
