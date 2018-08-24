/*
 *
 *  * Copyright (c) 2018. For DMSoft Group.
 *
 */

package com.dmsoft.hyacinth.server.dao;

import com.dmsoft.hyacinth.server.HyainthServerApplication;
import com.dmsoft.hyacinth.server.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = HyainthServerApplication.class)
@DirtiesContext
public class UserDaoTest {

    @Autowired
    private UserDao userDao;

    @Test
    public void findByUserId() {
        Page<User> usersPage = userDao.findAll(new PageRequest(0, 10));
        List<User> users = usersPage.getContent();

        assertThat(users).hasSize(2);
        assertThat(users.get(0).getLogin_name()).isEqualTo("admin");
    }

}
