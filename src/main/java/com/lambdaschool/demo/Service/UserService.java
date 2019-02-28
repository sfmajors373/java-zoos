package com.lambdaschool.demo.Service;

import com.lambdaschool.demo.Models.User;

import java.util.List;

public interface UserService
{
    User save(User user);
    List<User> findAll();
    void delete(long id);
}
