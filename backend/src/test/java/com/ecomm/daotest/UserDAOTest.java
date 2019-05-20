package com.ecomm.daotest;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ecomm.dao.UserDAO;
import com.ecomm.model.User;

public class UserDAOTest {

	static UserDAO userDAO;

	@BeforeClass
	public static void executeFirst()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.ecomm");
		context.refresh();
		
		userDAO=(UserDAO)context.getBean("userDAO");
	}
	@Test
	public void addUserTest()
	{
		User user=new User();
		user.setName("Admin");
		user.setMobileNo("1122334455");
		user.setPassword("imman");
		user.setUsername("imman");
		user.setRole("ROLE_ADMIN");
		user.setEmail("imman@google.com");
		user.setAddress("chennai");
		assertTrue("Problem in User Insertion",userDAO.addUser(user));
	}
    @Ignore
	@Test
	public void updateUserTest()
	{
		User user=userDAO.getUser(115);
	    user.setUsername("imman");
	    user.setRole("ROLE_ADMIN");
		assertTrue("Problem in Updation",userDAO.updateUser(user));
	}
    @Ignore
    @Test
	public void listUserTest()
	{
		List<User> listUser=userDAO.getUser();
		assertNotNull("No User",listUser);
		
		for(User user:listUser)
		{
			System.out.print(user.getUsername()+" ");
			System.out.print(user.getEmail()+" ");
			
		}
}
}
