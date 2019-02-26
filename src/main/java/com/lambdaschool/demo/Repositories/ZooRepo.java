package com.lambdaschool.demo.Repositories;

import com.lambdaschool.demo.Models.Zoo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ZooRepo extends JpaRepository<Zoo, Long>
{
    Zoo findZooByZooname(String name);
}
