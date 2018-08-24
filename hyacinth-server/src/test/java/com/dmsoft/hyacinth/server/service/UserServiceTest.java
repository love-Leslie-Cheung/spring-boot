/*
 *
 *  * Copyright (c) 2018. For DMSoft Group.
 *
 */

package com.dmsoft.hyacinth.server.service;

import com.dmsoft.hyacinth.server.HyainthServerApplication;
import com.dmsoft.hyacinth.server.dao.UserDao;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = HyainthServerApplication.class, webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@TestExecutionListeners
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Mock
    private UserDao spyUserDao;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
//		userService = Mockito.mock(UserService.class);
//		ReflectionTestUtils.setField(userService, "userDao", spyUserDao);

    }

	/*
	@Test
	public void findById() {

		User user = new User();
		user.setId(1L);
		user.setCode("DM10001");
		//Mockito.when(spyUserDao.findById(1L)).thenReturn(user);

		UserDto entity = userService.findUserById(1L);

		assertThat(entity.getCode()).isEqualTo("DM10001");
//		assertThat(users.get(0).getLoginName()).isEqualTo("admin");
	}
	*/
}
