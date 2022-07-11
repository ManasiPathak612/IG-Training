package com.library.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.BDDMockito.given;
import org.mockito.junit.jupiter.MockitoExtension;

import com.library.model.User;
import com.library.repository.UserRepository;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
	@Mock 
	private UserRepository userRepository;
	
	@InjectMocks
	private UserService userService;
	
	private User user;
	
		
	@BeforeEach
	public void setUpUser() {
		user = User.builder().userName("Manasi").userAge(25).userMailId("manasi@gmail.com").gender("female").
				mobileNum(6876876867L).userAddress("Pune").userType("Librarian").build();
	}

	@Test
    public void UserObject_whenSaveUser_thenReturnUserObject(){
        given(userRepository.save(user)).willReturn(user);
        System.out.println(userRepository);
        System.out.println(userService);
        User savedUser = userService.addUser(user);
        System.out.println(savedUser);
        assertThat(savedUser).isNotNull();
    }
	@Test
    public void givenUserList_whenGetAllUsers_thenReturnUserList(){

        given(userRepository.findAll()).willReturn(List.of(user,user));
        List<User> UserList = userService.getAllUsers();
        assertThat(UserList).isNotNull();
        assertThat(UserList.size()).isEqualTo(2);
    }
	
}
    