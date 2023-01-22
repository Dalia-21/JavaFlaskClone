package dalia.webapp.sqlitedb;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Timestamp;
import java.util.ArrayList;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class PostTableTest {
	static PostTable postTable = new PostTable();
	static UserTable userTable = new UserTable();
	static String testUrl = "jdbc:sqlite:////home/dalia/git/JavaBlog/JavaBlog/db/test.db";
	// test user variables
	static User userPrototype = new User();
	static User testUser = new User();
	static String usernameStub = "TestUser";
	static String passwordStub = "password";
	static int userNum = 2;
	// test post variables
	static Post postPrototype = new Post();
	static Post testPost = new Post();
	static String titleStub = "Test Post Number ";
	static String bodyStub = "This is test post number ";
	static Timestamp timestamp = new Timestamp(System.currentTimeMillis());
	static int numPosts = 6;
	static int postId;
	static int authorId;
	
	@BeforeAll
	static void setUpBeforeClass() {
		postTable.setConnectionUrl(testUrl);
		postTable.createTable();
		userTable.setConnectionUrl(testUrl);
		userTable.createTable();
		for (int i = 1; i <= userNum; i++) {
			userPrototype.setUsername(usernameStub + String.valueOf(i));
			userPrototype.setPassword(passwordStub + String.valueOf(i));
			userTable.createUser(userPrototype);
		}
		for (int i = 1; i <= numPosts/2; i++) {
			authorId = userTable.getUserByName(usernameStub + "1").getId();
			postPrototype.setAuthorId(authorId);
			postPrototype.setTitle(titleStub + String.valueOf(i));
			postPrototype.setBody(bodyStub + String.valueOf(i));
			postTable.createPost(postPrototype);
		}
		
		for (int i = numPosts/2+1; i <= numPosts; i++) {
			authorId = userTable.getUserByName(usernameStub + "2").getId();
			postPrototype.setAuthorId(authorId);
			postPrototype.setTitle(titleStub + String.valueOf(i));
			postPrototype.setBody(bodyStub + String.valueOf(i));
			postTable.createPost(postPrototype);
		}
		
	}

	@AfterAll
	static void tearDownAfterClass() {
		postTable.dropTable();
		userTable.dropTable();
	}

	@Test
	void testGetPostById() {
		// don't run right now
	}

	@Test
	void testGetPostByAuthorId() {
		ArrayList<Post> postsByUser1 = postTable.getPostByAuthorId(userTable.getUserByName(usernameStub + "1").getId());
		assertEquals(numPosts/2, postsByUser1.size());
		ArrayList<Post> postsByUser2 = postTable.getPostByAuthorId(userTable.getUserByName(usernameStub + "2").getId());
		assertEquals(numPosts/2, postsByUser2.size());
	}

	@Test
	void testUpdatePost() {
		
	}

}
