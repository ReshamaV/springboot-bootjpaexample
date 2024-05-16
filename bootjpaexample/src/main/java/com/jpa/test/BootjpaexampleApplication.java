package com.jpa.test;

import java.util.List;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.jpa.test.dao.UserRepository;
import com.jpa.test.entities.User;

@SpringBootApplication
public class BootjpaexampleApplication {

	private static Optional<User> findById;

	public static void main(String[] args) {
		ApplicationContext context=SpringApplication.run(BootjpaexampleApplication.class, args);
		UserRepository userRepository = context.getBean(UserRepository.class);
		
		User user=new User();
		user.setName("reshama");
		user.setPassword("reshamacv@19");
		
		User user1=new User();
		user1.setName("Rani");
		user1.setPassword("dkgsundlk");
		
		//Saving single user
		//User user1= userRepository.save(user);
		
		/*List<User> users= List.of(user,user1);
		Iterable<User> result=userRepository.saveAll(users);
		
		result.forEach(user2->{
			System.out.println(user2);
		});*/
		//System.out.println(user1);
		
	/*	//update the user with id 6
		 Optional<User> optional = userRepository.findById(6);
		 User user2 = optional.get();
		 user2.setName("Meera");
		 User result = userRepository.save(user2);
		 System.out.println(result);*/
		 
		 //how to get data
		 //findbyId(id) --return optional containing your data
		 
		 //deleting data 
		// userRepository.deleteById(6);
		// System.out.println("deleted");
		
		List<User> users = userRepository.findByName("reshama");
		users.forEach(e->System.out.println(e));
		
		List<User> usersr = userRepository.findByNameAndPassword("Rani","dkgsundlk");
		usersr.forEach(e->System.out.println(e));
		
		
		
	}
 
}
