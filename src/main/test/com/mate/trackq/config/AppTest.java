package com.mate.trackq.config;

import com.mate.trackq.dao.UserDao;
import com.mate.trackq.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = AppConfig.class)
public class AppTest {

    @Autowired
    UserDao userDao;

    @Test
    public void testValidation() {
        User user = new User();
        user.setEmail("yolo1@mail.ru");
        user.setPassword("1231234");
        user.setUsername("Johns");
        //user.setId(55L);
        assertNotNull(user);

        userDao.create(user);
    }

//    @Test
//    public void testValidation123() {
//        User user = new User();
//        user.setEmail("yolo@mail.ru");
//        user.setPassword("123123");
//        user.setUsername("John");
//        //user.setId(55L);
//        assertNotNull(user);
//
//        userDao.create(user);
//    }
}
