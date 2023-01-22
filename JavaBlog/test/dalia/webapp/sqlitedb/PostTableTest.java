package dalia.webapp.sqlitedb;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class PostTableTest {
	static PostTable testTable = new PostTable();
	static String testUrl = "jdbc:sqlite:////home/dalia/git/JavaBlog/JavaBlog/db/test.db";
	
	@BeforeAll
	static void setUpBeforeClass() {
		testTable.setConnectionUrl(testUrl);
		testTable.createTable();
		
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
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
