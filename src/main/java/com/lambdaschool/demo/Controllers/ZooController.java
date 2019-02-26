package com.lambdaschool.demo.Controllers;

import com.lambdaschool.demo.Models.Zoo;
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
@RequestMapping(path = "/zoos/", produces = MediaType.APPLICATION_JSON_VALUE)
public class ZooController
{
    @Autowired
    ZooRepo zoorepo;

    @Autowired
    AnimalRepo animalrepo;

    @Autowired
    TelephoneRepo telerepo;

    // GET /zoos/zoos - returns all zoos with their phone numbers and animals
    @GetMapping("/zoos")
    public List<Zoo> getAllZoos()
    {
        return zoorepo.findAll();
    }

    // GET /zoos/{name} - return the zoo with this name with its phone numbers and animals
    @GetMapping("/{name}")
    public Zoo findByName(@PathVariable String name)
    {
        return zoorepo.findZooByZooname(name);
    }
}
