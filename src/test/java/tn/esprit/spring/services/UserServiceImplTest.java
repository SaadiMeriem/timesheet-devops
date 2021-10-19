package tn.esprit.spring.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import tn.esprit.spring.entities.Role;


import java.util.List;
import tn.esprit.spring.entities.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
class UserServiceImplTest {
	
	@Autowired 
	IUserService us;
	
	
	@Test
	@Order(1)
	public void testRetrieveAllUsers() {
		List<User> listUsers =us.retrieveAllUsers();
		Assertions.assertEquals(7, listUsers.size());
	}
	
	
 	@Test
 	@Order(2)
	public void testAddUser() throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date d = dateFormat.parse("1965-03-23");
		User user = new User("Jhony", "Depp", d , Role.INGENIEUR);
		User userAdd = us.addUser(user);
		Assertions.assertEquals(user.getLastName(), userAdd.getLastName());
	}
 	
 	@Test
 	@Order(3)
	public void testUpdateUser() throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date d = dateFormat.parse("1965-03-23");
		User user = new User(7L,"Manel", "Abdi", d , Role.INGENIEUR);
		User userUpdated = us.addUser(user);
		Assertions.assertEquals(user.getLastName(), userUpdated.getLastName());
	}
 	
 	@Test
 	@Order(4)
	public void testRetrieveUser() throws ParseException {
		User userRetrieved = us.retrieveUser("1");
		Assertions.assertEquals(1L, userRetrieved.getId());
	}
 	
	@Test
 	@Order(5)
	public void testDeleteUser() throws ParseException {
		us.deleteUser("8");;
		Assertions.assertNull(us.retrieveUser("8"));
	}
 	
 

	 
}
