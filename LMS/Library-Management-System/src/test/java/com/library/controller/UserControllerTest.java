package com.library.controller;
import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.library.model.User;
import com.library.service.UserService;

@WebMvcTest(value = UserController.class)
public class UserControllerTest {
	@Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Autowired
    private ObjectMapper objectMapper;

    private User user;
    @BeforeEach
    public void setUpUser() {
        user = User.builder().userName("Manasi").userAge(21).userMailId("mp@gmail.com").gender("Female").mobileNum(7654345L)
                .userAddress("Pune").userType("Student").build();
    }

    @Test
    public void givenUserObject_whenCreateUser_thenReturnSavedUser() throws Exception{
        BDDMockito.given(userService.addUser(user)).willAnswer((invocation)-> invocation.getArgument(0));
        ResultActions response = mockMvc.perform(post("/addUser")
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(user)));
        response.andDo(print()).andExpect(status().isCreated());
    }
    @Test
    public void givenUserObject_whenUpdateUser_thenReturnUserObject() throws Exception {
        User savedUser = User.builder().userId(1L).userName("Asmita").userAge(23).userMailId("at@gmail.com")
                .userAddress("Mumbai").userType("Student").build();
        User updateUser = User.builder().userName("Asmita").userAge(23).userMailId("at@gmail.com")
                .userAddress("Navi Mumbai").userType("Student").build();

       BDDMockito.given(userService.getUserById(1l)).willReturn(savedUser);
        BDDMockito.given(userService.editUser(user)).willAnswer(invocation -> invocation.getArgument(0));
        ResultActions response = mockMvc.perform(put("/editUser").contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(updateUser)));
        response.andExpect(status().isNotFound()).andDo(print());
    }
	@Test
	public void givenUserObjectList_whenGetAllUser_thenReturnUserList() throws Exception {
		List<User> userList = new ArrayList<>();
		userList.add(User.builder().userName("Sanjay").userAge(35).userMailId("sanjay@gmail.com").gender("Male")
				.mobileNum(8888889999L).userAddress("Varanasi").userType("STU").build());
		userList.add(User.builder().userName("Suresh").userAge(35).userMailId("suresh@gmail.com").gender("Male")
				.mobileNum(7777779999L).userAddress("Varanasi").userType("STU").build());
		BDDMockito.given(userService.getAllUsers()).willReturn(userList);
		ResultActions response = mockMvc.perform(get("/getAllUsers"));
		response.andExpect(status().isOk()).andDo(print());
	}
}
