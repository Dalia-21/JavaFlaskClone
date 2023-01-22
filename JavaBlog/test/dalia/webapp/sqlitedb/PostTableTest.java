package dalia.webapp.sqlitedb;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Timestamp;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class PostTableTest {
	static PostTable testTable = new PostTable();
	static String testUrl = "jdbc:sqlite:////home/dalia/git/JavaBlog/JavaBlog/db/test.db";
	// test user variables
	static User userPrototype = new User();
	static User testUser = new User();
	static String usernameStub = "TestUser";
	static String passwordStub = "password";
	static int userNum = 2;
	// test post variables
	static Post initialPost = new Post();
	static Post testPost = new Post();
	static String titleStub = "Test Post Number ";
	static String bodyStub = "This is test post number ";
	static Timestamp timestamp = new Timestamp(System.currentTimeMillis());
	static int numPosts = 6;
	
	@BeforeAll
	static void setUpBeforeClass() {
		testTable.setConnectionUrl(testUrl);
		testTable.createTable();
		
	}

	@AfterAll
	static void tearDownAfterClass() {
		testTable.dropTable();
	}

	@Test
	void testCreatePost() {
		fail("Not yet implemented");
	}

	@Test
	void testDeletePost() {
		fail("Not yet implemented");
	}

	@Test
	void testGetPostById() {
		fail("Not yet implemented");
	}

	@Test
	void testGetPostByAuthorId() {
		fail("Not yet implemented");
	}

	@Test
	void testUpdatePost() {
		fail("Not yet implemented");
	}

}
