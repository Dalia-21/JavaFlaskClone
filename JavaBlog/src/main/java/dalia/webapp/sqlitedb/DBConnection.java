package dalia.webapp.sqlitedb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	private String url = "jdbc:sqlite:////home/dalia/git/JavaBlog/JavaBlog/db/sqlite.db";
	private Connection conn;
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	public Connection connect() throws SQLException {
		conn = DriverManager.getConnection(url);
		return conn;
	}
}
