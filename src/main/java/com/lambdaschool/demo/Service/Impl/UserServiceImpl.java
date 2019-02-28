package com.lambdaschool.demo.Service.Impl;

import com.lambdaschool.demo.Models.User;
import com.lambdaschool.demo.Repositories.UserRepository;
import com.lambdaschool.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service(value = "userService")
public class UserServiceImpl implements UserDetailsService, UserService
{

    @Autowired
    private UserRepository userrepo;

    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException
    {
        User user = userrepo.findByUsername(userId);
        if (user == null)
        {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), user.getAuthority());
    }

    public List<User> findAll()
    {
        List<User> list = new ArrayList<>();
        userrepo.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    public void delete(long id)
    {
        userrepo.deleteById(id);
    }

    @Override
    public User save(User user)
    {
        return userrepo.save(user);
    }
}
