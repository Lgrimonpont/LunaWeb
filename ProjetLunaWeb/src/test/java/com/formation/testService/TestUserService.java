package com.formation.testService;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.formation.config.ConteneurSpring;
import com.formation.persistence.User;
import com.formation.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ConteneurSpring.class })
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestUserService {

	@Autowired
	UserService userService;

	@Test
	public void testInsertUser() {

		List<User> listUser = userService.getAllUser();
		int verifInsert = listUser.size();

		User user = new User();
		String login = "root";
		String pass = "root";
		String role = "6";
		

		user.setLogin(login);
		user.setPass(pass);
		user.setRole(role);
		

		userService.insertUser(user);
		assertEquals("insert effectué", verifInsert + 1, userService.getAllUser().size());
		User user2 = userService.getUser(user.getId());
		assertEquals("meme login", login, user2.getLogin());
		assertEquals("meme pass", pass, user2.getPass());
		assertEquals("meme role", role, user2.getRole());

		userService.removeUser(user.getId());
	}

	@Test
	public void testUpdateUser() {


		User user = new User();
		String login = "root";
		String pass = "root";
		String role = "6";

		user.setLogin(login);
		user.setPass(pass);
		user.setRole(role);
		
		userService.insertUser(user);

		String login2 = "root2";
		String pass2 = "root2";
		String role2 = "7";
		
		user.setLogin(login2);
		user.setPass(pass2);
		user.setRole(role2);

		userService.updateUser(user);
		User user2 = userService.getUser(user.getId());
		assertEquals("meme login", login2, user2.getLogin());
		assertEquals("meme pass", pass2, user2.getPass());
		assertEquals("meme role", role2, user2.getRole());

		userService.removeUser(user.getId());
	}

	@Test
	public void testRemoveUser() {

		List<User> listUser = userService.getAllUser();
		int verifInsert = listUser.size();

		User user = new User();
		String login = "root";
		String pass = "root";
		String role = "6";

		user.setLogin(login);
		user.setPass(pass);
		user.setRole(role);
		
		userService.insertUser(user);

		userService.removeUser(user.getId());
		assertEquals("suppression effectué", verifInsert, userService.getAllUser().size());
	}

}