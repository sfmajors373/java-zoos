package com.lambdaschool.demo.Repositories;

import com.lambdaschool.demo.Models.Animal;
import org.hibernate.metamodel.model.convert.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimalRepo extends JpaRepository<Animal , Long>
{
    Animal findAnimalByAnimaltype(String name);
}
