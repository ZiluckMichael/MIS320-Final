package com.ziluck.iastate.mis320final;

import com.github.javafaker.Faker;
import com.github.javafaker.Internet;
import com.github.javafaker.Name;
import com.ziluck.iastate.mis320final.model.WebUser;
import com.ziluck.iastate.mis320final.repository.WebUserRepository;
import com.ziluck.iastate.mis320final.service.JwtUserDetailsService;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest(classes = HotelApplication.class)
public class DataSetup {
    @Autowired
    private WebUserRepository userRepository;

    @Autowired
    private JwtUserDetailsService userDetailsService;

    private static Faker faker;

    @BeforeClass
    public static void setup() {
        faker = new Faker();
    }

    @Test
    public void add500() {
        int starting = userRepository.findByActiveTrue().size();

        for (int i = 0; i < 500; i++) {
            WebUser user = new WebUser();
            Name name = faker.name();
            Internet internet = faker.internet();
            user.setFirstName(name.firstName());
            user.setLastName(name.lastName());
            user.setEmail(internet.emailAddress(user.getFirstName() + "." + user.getLastName()));
            user.setPassword(internet.password(true));
            user.setActive(true);
            userDetailsService.registerUser(user);
        }

        Assert.assertEquals(starting + 500, userRepository.findByActiveTrue().size());
    }
}
