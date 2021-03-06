package com.example.wbdvsp21recipeplannerserverjava.repositories;

import com.example.wbdvsp21recipeplannerserverjava.models.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Integer> {

    @Query(value="SELECT * FROM users WHERE email=:e", nativeQuery = true)
    public List<User> findUserByEmail(String e);

    @Query(value="SELECT id FROM users WHERE email=:e", nativeQuery = true)
    public Integer findIdByEmail(String e);

    @Query(value="SELECT name FROM users WHERE email=:e", nativeQuery = true)
    public String findNameByEmail(String e);

    @Query(value="SELECT * FROM users WHERE id=:i", nativeQuery = true)
    public User findUserById(Integer i);

}
