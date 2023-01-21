import dalia.webapp.sqlitedb.UserTable;
import dalia.webapp.sqlitedb.Post;
import dalia.webapp.sqlitedb.PostTable;
import dalia.webapp.sqlitedb.User;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		UserTable dbUser = new UserTable();
		User dalia = new User();
		dalia.setUsername("Dalia");
		dalia.setPassword("password");
		dbUser.createUser(dalia);
		User user = dbUser.getUserByName("Dalia");
		user.printUser();
		dbUser.deleteUser(user.getId());
		
		PostTable dbPost = new PostTable();
		Post testPost1 = new Post();
		Post testPost2 = new Post();
		Post testPost3 = new Post();
		Post testPost4 = new Post();
		User testUser1 = new User();
		User testUser2 = new User();
		
		testUser1.setUsername("testuser1");
		testUser1.setPassword("password");
		testUser2.setUsername("testuser2");
		testUser2.setPassword("password");
		dbUser.createUser(testUser1);
		dbUser.createUser(testUser2);
		
		testUser1 = dbUser.getUserByName("testuser1");
		testUser2 = dbUser.getUserByName("testuser2");
		testPost1.setAuthorId(testUser1.getId());
		testPost1.setTitle("Test Post Title");
		testPost1.setBody("This is the body of a test post.");
		testPost2.setAuthorId(testUser1.getId());
		testPost2.setTitle("Test Post 2 Title");
		testPost2.setBody("This is the body of the second test post.");
		testPost3.setAuthorId(testUser2.getId());
		testPost3.setTitle("Test Post 3 Title");
		testPost3.setBody("This is the body of the third test post.");
		testPost4.setAuthorId(testUser2.getId());
		testPost4.setTitle("Test Post 4 Title");
		testPost4.setBody("This is the body of the fourth test post.");
		
		dbPost.createPost(testPost1);
		dbPost.createPost(testPost2);
		dbPost.createPost(testPost3);
		dbPost.createPost(testPost4);
		
		ArrayList<Post> user1Posts = dbPost.getPostByAuthorId(testUser1.getId());
		ArrayList<Post> user2Posts = dbPost.getPostByAuthorId(testUser2.getId());
		System.out.println(String.format("Number of posts for user 1: %d; user 2: %d", user1Posts.size(), user2Posts.size()));
		
		testPost1 = dbPost.getPostByAuthorId(testUser1.getId()).get(0);
		testPost2 = dbPost.getPostByAuthorId(testUser1.getId()).get(1);
		testPost3 = dbPost.getPostByAuthorId(testUser2.getId()).get(0);
		testPost4 = dbPost.getPostByAuthorId(testUser2.getId()).get(1);
		
		System.out.println("Bulk query:");
		ArrayList<Post> posts = dbPost.getPostByAuthorId(testUser1.getId());
		for (int i = 0; i < posts.size(); i++) {
			posts.get(i).printPost();
		}
		
		System.out.println("Testing update method:");
		testPost1.updateTitle("New Updated Title");
		dbPost.updatePost(testPost1);
		testPost3.updateBody("This is the body of an updated post.");
		dbPost.updatePost(testPost3);
		
		testPost1 = dbPost.getPostById(testPost1.getId());
		testPost3 = dbPost.getPostById(testPost3.getId());
		testPost1.printPost();
		testPost3.printPost();
		
		dbPost.deletePost(testPost1.getId());
		dbPost.deletePost(testPost2.getId());
		dbPost.deletePost(testPost3.getId());
		dbPost.deletePost(testPost4.getId());
		
		dbUser.deleteUser(testUser1.getId());
		dbUser.deleteUser(testUser2.getId());
	}
}
