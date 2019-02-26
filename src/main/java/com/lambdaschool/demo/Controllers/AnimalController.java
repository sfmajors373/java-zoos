package com.lambdaschool.demo.Controllers;

import com.lambdaschool.demo.Models.Animal;
import com.lambdaschool.demo.Repositories.AnimalRepo;
import com.lambdaschool.demo.Repositories.TelephoneRepo;
import com.lambdaschool.demo.Repositories.ZooRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/animals/", produces = MediaType.APPLICATION_JSON_VALUE)
public class AnimalController
{
    @Autowired
    ZooRepo zoorepo;

    @Autowired
    AnimalRepo animalrepo;

    @Autowired
    TelephoneRepo telerepo;

    // GET /animals/animals - returns all animals with their zoos
    @GetMapping("/animals")
    public List<Animal> listAllAnimals()
    {
        return animalrepo.findAll();
    }

    // GET /animals/{name} - return the animal with a list of zoos where they can be found
    @GetMapping("/{name}")
    public Animal returnAnimalByName(@PathVariable String name)
    {
        return animalrepo.findAnimalByAnimaltype(name);
    }
}
