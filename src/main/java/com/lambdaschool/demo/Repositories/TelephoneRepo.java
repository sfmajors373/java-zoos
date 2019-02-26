package com.lambdaschool.demo.Repositories;

import com.lambdaschool.demo.Models.Telephone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TelephoneRepo extends JpaRepository<Telephone, Long>
{
}
