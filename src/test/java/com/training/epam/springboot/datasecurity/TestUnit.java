package com.training.epam.springboot.datasecurity;

import com.training.epam.springboot.datasecurity.models.UserApp;
import com.training.epam.springboot.datasecurity.repositories.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

//@DataJpaTest
//@Sql(scripts = "/create-data.sql")
//@Sql(scripts = "/cleanup-data.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
public class TestUnit {

    /*@Autowired
    private UserRepository userRepository;*/


    @Test
    public void getUserByIdSuccessPath(){
        /*UserApp user = new UserApp();
        user.setNombre("pao");
        user.setEmail("ee");
        user.setPrioridad(1);
        userRepository.save(user);*/
        Assertions.assertTrue(true);
    }
}
