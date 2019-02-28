package com.lambdaschool.demo.Repositories;

import com.lambdaschool.demo.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>
    // Could also be Userdao - database access object
{
    User findByUsername(String username);
}
