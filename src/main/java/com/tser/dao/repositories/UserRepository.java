package com.tser.dao.repositories;

import com.tser.dao.entities.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Integer> {
    public List<User> findByUserName(String userName);

    public List<User> findByUserNameContaining(String userName);
}
