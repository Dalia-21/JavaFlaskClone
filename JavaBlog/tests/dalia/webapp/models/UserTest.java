package dalia.webapp.models;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import dalia.javablog.models.User;

class UserTest {
	User testUser = new User();
	
	@Test
	void testSetId() {
		testUser.setId(0);
		assertEquals(0, testUser.getId());
		assertNotEquals(1, testUser.getId());
		
	}

	@Test
	void testSetUsername() {
		String testUsername = "Test";
		testUser.setUsername(testUsername);
		assertEquals(testUsername, testUser.getUsername());
	}

	@Test
	void testSetPassword() {
		String testPassword = "password";
		testUser.setPassword(testPassword);
		assertEquals(testPassword, testUser.getPassword());
	}

}
