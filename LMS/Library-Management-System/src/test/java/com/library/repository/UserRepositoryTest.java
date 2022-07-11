package com.library.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


import com.library.model.User;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserRepositoryTest {
	@Autowired
	private UserRepository userRepository;
	
	private User user;
	
	@BeforeEach
	public void setUpUser() {
		user = User.builder().userName("Manasi").
				userAge(28).userAddress("Pune").userMailId("manasip612@gmail.com").userType("Librarian").gender("Female").
				mobileNum(12341L).build();
	}
	@Test
	void userExists() {
	      userRepository.save(user);
	      User savedUser = userRepository.findById(user.getUserId()).get();
	      assertThat(savedUser).isNotNull();
	    }
	@Test
	public void updateUserTest() {
		userRepository.save(user);
		User savedUser = userRepository.findById(user.getUserId()).get();
						savedUser.setUserMailId("manasi@gmail.com");
						savedUser.setMobileNum(1234567890);
		User updateUser = userRepository.save(savedUser);
		assertThat(updateUser.getUserMailId()).isEqualTo("manasi@gmail.com");
		assertThat(updateUser.getMobileNum()).isEqualTo(1234567890);
	}
	
	@Test
	public void deleteUserTest() {
		userRepository.save(user);
		userRepository.deleteById(user.getUserId());
		Optional<User> userDetails=userRepository.findById(user.getUserId());
		assertThat(userDetails).isEmpty();
	}
}    

