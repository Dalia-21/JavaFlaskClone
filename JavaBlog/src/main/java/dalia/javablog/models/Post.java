package dalia.javablog.models;

import java.sql.Timestamp;

public class Post {
	private int id;
	private int authorId;
	private Timestamp timestamp;
	private String title;
	private String body;
	private String authorName;
	
	public void initialise(int id, int authorId, String authorName, Timestamp timestamp, String title, String body) {
		this.id = id;
		this.authorId = authorId;
		this.authorName = authorName;
		this.timestamp = timestamp;
		this.title = title;
		this.body = body;
	}
	
	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}
	
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public void setBody(String body) {
		this.body = body;
	}
	
	public void updateTitle(String title) {
		this.title = title;
	}
	
	public void updateBody(String body) {
		this.body = body;
	}
	
	public int getId() {
		return id;
	}

	public int getAuthorId() {
		return authorId;
	}
	
	public Timestamp getTimestamp() {
		return timestamp;
	}

	public String getTitle() {
		return title;
	}

	public String getBody() {
		return body;
	}
	
	public String getAuthorName() {
		return authorName;
	}
	
	public void printPost() {
		System.out.println(String.format("Post by %s", authorName));
		System.out.println(String.format("Title: %s", title));
		System.out.println("Body of post:");
		System.out.println(body);
	}
	
}
