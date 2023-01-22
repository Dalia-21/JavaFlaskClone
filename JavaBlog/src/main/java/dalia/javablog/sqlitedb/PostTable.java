package dalia.webapp.sqlitedb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PostTable {
	private DBConnection db = new DBConnection();
	
	public void setConnectionUrl(String url) {
		db.setUrl(url);
		System.out.println(String.format("Connecting to table at %s", url));
	}
	
	public void createTable() {
		String sql = "CREATE TABLE post ("
				+ "  id INTEGER PRIMARY KEY AUTOINCREMENT,"
				+ "  authorId INTEGER NOT NULL,"
				+ "  created TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,"
				+ "  title TEXT NOT NULL,"
				+ "  body TEXT NOT NULL,"
				+ "  FOREIGN KEY (authorId) REFERENCES user (id));";
		
		try (Connection conn = db.connect();
				PreparedStatement stmt = conn.prepareStatement(sql);
				) {
				stmt.execute();
				System.out.println("Created table post.");
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	
	public void dropTable() {
		String sql = "DROP TABLE IF EXISTS post;";
		
		try (Connection conn = db.connect();
				PreparedStatement stmt = conn.prepareStatement(sql);
				) {
				stmt.execute();
				System.out.println("Table post deleted.");
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}		

	}
	
	public void createPost(Post post) {
		int authorId = post.getAuthorId();
		String title = post.getTitle();
		String body = post.getBody();
		
		String sql = "INSERT INTO post (title, body, authorId) VALUES (?, ?, ?);";
		
		try (Connection conn = db.connect();
			PreparedStatement stmt = conn.prepareStatement(sql);
			) {
			stmt.setString(1, title);
			stmt.setString(2, body);
			stmt.setInt(3, authorId);
			
			stmt.executeUpdate();
			
			System.out.println(String.format("Inserted post with title %s into db.", title));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deletePost(int id) {
		String sql = "DELETE FROM post WHERE `id` = ?;";
		
		try (Connection conn = db.connect();
			PreparedStatement stmt = conn.prepareStatement(sql);
			) {
			stmt.setInt(1, id);
			stmt.executeUpdate();
			
			System.out.println(String.format("Deleted post with id %d from db.", id));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Post getPostById(int id) {
		String sql = "SELECT * FROM post WHERE `id` = ?;";
		Post post = new Post();
		
		try (Connection conn = db.connect();
			PreparedStatement stmt = conn.prepareStatement(sql);
			) {
			stmt.setInt(1, id);
			ResultSet res = stmt.executeQuery();
			post.initialise(res.getInt("id"), res.getInt("authorId"),
					res.getTimestamp("created"), res.getString("title"), res.getString("body"));
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return post;
	}

	public Post getPostByTitle(String title) {
		String sql = "SELECT * FROM post WHERE `title` = ?;";
		Post post = new Post();
		
		try (Connection conn = db.connect();
			PreparedStatement stmt = conn.prepareStatement(sql);
			) {
			stmt.setString(1, title);
			ResultSet res = stmt.executeQuery();
			post.initialise(res.getInt("id"), res.getInt("authorId"),
					res.getTimestamp("created"), res.getString("title"), res.getString("body"));
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return post;
	}
	
	
	public ArrayList<Post> getPostByAuthorId(int authorId) {
		String sql = "SELECT * FROM post WHERE `authorId` = ?;";
		ArrayList<Post> posts = new ArrayList<Post>();
		
		try (Connection conn = db.connect();
			PreparedStatement stmt = conn.prepareStatement(sql);
			) {
			stmt.setInt(1, authorId);
			System.out.println(String.format("Bulk query sql: %s", stmt));
			
			boolean results = stmt.execute();
			
			do {
				if (results) {
					ResultSet res = stmt.getResultSet();
					
					while (res.next()) {
						Post post = new Post();
						post.initialise(res.getInt("id"), res.getInt("authorId"),
								res.getTimestamp("created"), res.getString("title"), res.getString("body"));
						posts.add(post);
					}
					res.close();
				}
				results = stmt.getMoreResults();
			} while(results);
			stmt.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return posts;
	}
	
	public void updatePost(Post post) {
		String title = post.getTitle();
		String body = post.getBody();
		int id = post.getId();
		String sql = "UPDATE post SET title = ?, body = ?"
				+ "WHERE `id` = ?;";
		
		try (Connection conn = db.connect();
			PreparedStatement stmt = conn.prepareStatement(sql);
			) {
			stmt.setString(1, title);
			stmt.setString(2,  body);
			stmt.setInt(3,  id);
			stmt.executeUpdate();
			
			System.out.println(String.format("Updated post with id %d", id));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
