package dalia.webapp.sqlitedb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserTable {
	private DBConnection db = new DBConnection();
	
	public void setConnectionUrl(String url) {
		db.setUrl(url);
		System.out.println(String.format("Connecting to table at %s", url));
	}
	
	public void createTable() {
		String sql = "CREATE TABLE user ("
				+ "id INTEGER PRIMARY KEY AUTOINCREMENT,"
				+ " username TEXT UNIQUE NOT NULL,"
				+ " password TEXT NOT NULL);";
		
		try (Connection conn = db.connect();
			PreparedStatement stmt = conn.prepareStatement(sql);
			) {
			stmt.execute();
			System.out.println("Created table user.");
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void dropTable() {
		String sql = "DROP TABLE IF EXISTS user;";
		
		try (Connection conn = db.connect();
				PreparedStatement stmt = conn.prepareStatement(sql);
				) {
				stmt.execute();
				System.out.println("Table user deleted.");
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}		
	}
	
	public void createUser(User user) {
		String username = user.getUsername();
		String password = user.getPassword();
		
		String sql = "INSERT INTO user (username, password) VALUES (?, ?);";
		
		try(Connection conn = db.connect();
			PreparedStatement stmt = conn.prepareStatement(sql);
			) {
			stmt.setString(1, username);
			stmt.setString(2, password);
			
			System.out.println(stmt);
			
			stmt.executeUpdate();
			
			System.out.println(String.format("Inserted user %s into db.", username));
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteAllUsers() {
		String sql = "DELETE FROM user;";
		
		try (Connection conn = db.connect();
			PreparedStatement stmt = conn.prepareStatement(sql);
			) {
			stmt.execute();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteUser(int id) {
		String sql = "DELETE FROM user WHERE `id` = ?;";
		
		try(Connection conn = db.connect();
			PreparedStatement stmt = conn.prepareStatement(sql);
			) {
			stmt.setInt(1, id);
			stmt.executeUpdate();
			
			System.out.println(String.format("Deleted user with id %d from user table.", id));
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public User getUserByName(String username) {
		String sql = "SELECT * FROM user WHERE `username` = ?;";
		ResultSet res = null;
		User user = new User();
		
		try(Connection conn = db.connect();
			PreparedStatement stmt = conn.prepareStatement(sql);
			) {
			stmt.setString(1, username);
			res = stmt.executeQuery();
			user.setId(res.getInt("id"));
			user.setUsername(res.getString("username"));
			user.setPassword(res.getString("password"));
			conn.close();
			} catch (SQLException e) {
			e.printStackTrace();
		}

		return user;
	}

	public User getUserById(int id) {
		String sql = "SELECT * FROM user WHERE `id` = ?;";
		User user = new User();
		
		try(Connection conn = db.connect();
			PreparedStatement stmt = conn.prepareStatement(sql);
			) {
			stmt.setInt(1, id);
			ResultSet res = stmt.executeQuery();
			user.setId(res.getInt("id"));
			user.setUsername(res.getString("username"));
			user.setPassword(res.getString("password"));
			conn.close();
			} catch (SQLException e) {
			e.printStackTrace();
		}

		return user;
	}
	
}