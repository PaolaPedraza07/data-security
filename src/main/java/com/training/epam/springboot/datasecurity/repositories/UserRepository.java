package com.training.epam.springboot.datasecurity.repositories;

import com.training.epam.springboot.datasecurity.models.UserApp;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserApp, Long> {
    UserApp findByEmail(String email);
}
