package dalia.webapp.models;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Timestamp;

import org.junit.jupiter.api.Test;

import dalia.javablog.models.Post;

class PostTest {
	Post testPost = new Post();
	String postTitle = "Post Number ";
	String postBody = "This is post number ";
	int authorId = 0;
	int id = 0;
	Timestamp timestamp = new Timestamp(System.currentTimeMillis());
	
	@Test
	void testInitialise() {
		String localPostTitle = postTitle + "1";
		String localPostBody = postBody + "1";
		testPost.initialise(id, authorId, timestamp, postTitle+1, postBody+1);
		assertEquals(id, testPost.getId());
		assertEquals(authorId, testPost.getAuthorId());
		assertEquals(timestamp, testPost.getTimestamp());
		assertEquals(localPostTitle, testPost.getTitle());
		assertEquals(localPostBody, testPost.getBody());
	}

	@Test
	void testSetAuthorId() {
		authorId++;
		testPost.setAuthorId(authorId);
		assertEquals(authorId, testPost.getAuthorId());
	}

	@Test
	void testSetTitle() {
		String localPostTitle = postTitle + "2";
		testPost.setTitle(localPostTitle);
		assertEquals(localPostTitle, testPost.getTitle());
	}

	@Test
	void testSetBody() {
		String localPostBody = postBody + "2";
		testPost.setBody(localPostBody);
		assertEquals(localPostBody, testPost.getBody());
	}

	@Test
	void testUpdateTitle() {
		String localPostTitle = postTitle + "3";
		testPost.setTitle(localPostTitle);
		String updatedTitle = postTitle + "4";
		testPost.updateTitle(updatedTitle);
		assertEquals(updatedTitle, testPost.getTitle());
	}

	@Test
	void testUpdateBody() {
		String localPostBody= postBody + "3";
		testPost.setTitle(localPostBody);
		String updatedBody = postBody + "4";
		testPost.updateBody(updatedBody);
		assertEquals(updatedBody, testPost.getBody());
		
	}

}
