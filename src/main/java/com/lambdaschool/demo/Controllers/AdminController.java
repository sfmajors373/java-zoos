package com.lambdaschool.demo.Controllers;

import com.lambdaschool.demo.Models.Animal;
import com.lambdaschool.demo.Models.Telephone;
import com.lambdaschool.demo.Models.Zoo;
import com.lambdaschool.demo.Repositories.AnimalRepo;
import com.lambdaschool.demo.Repositories.TelephoneRepo;
import com.lambdaschool.demo.Repositories.ZooRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/admin/", produces = MediaType.APPLICATION_JSON_VALUE)
public class AdminController
{
    @Autowired
    ZooRepo zoorepo;

    @Autowired
    AnimalRepo animalrepo;

    @Autowired
    TelephoneRepo telerepo;

//     PUT /admin/zoos/{id} - update the zoo referenced by the id number with the provided information
    @PutMapping("/zoos/{id}")
    public Zoo updateZooById(@RequestBody Zoo newZoo, @PathVariable long id)
    {
        Optional<Zoo> updateZoo = zoorepo.findById(id);
        if (updateZoo.isPresent())
        {
            if (newZoo.getTelephones() == null)
            {
                newZoo.setTelephones(updateZoo.get().getTelephones());
            }

            if (newZoo.getAnimals() == null)
            {
                newZoo.setAnimals(updateZoo.get().getAnimals());
            }
            newZoo.setId(id);
            zoorepo.save(newZoo);
            return newZoo;
        }
        else
        {
            return null;
        }
    }
//     PUT /admin/phones/{id} - update the telephone referenced by the id number with the provided information
    @PutMapping("/phones/{id}")
    public Telephone updatePhoneById(@RequestBody Telephone newPhone, @PathVariable long id)
    {
        Optional<Telephone> updatePhone = telerepo.findById(id);
        if (updatePhone.isPresent())
        {
            if (newPhone.getZoo() == null)
            {
                newPhone.setZoo(updatePhone.get().getZoo());
            }
            newPhone.setPhoneid(id);
            telerepo.save(newPhone);
            return newPhone;
        }
        else
        {
            return null;
        }
    }
//     PUT /admin/animals/{id} - update the animal referenced by the id number with the provided information
    @PutMapping("/animals/{id}")
    public Animal updateAnimalById(@RequestBody Animal newAnimal, @PathVariable long id)
    {
        Optional<Animal> updateAnimal = animalrepo.findById(id);
        if (updateAnimal.isPresent())
        {
            if (newAnimal.getZoos() == null)
            {
                newAnimal.setZoos(updateAnimal.get().getZoos());
            }
            newAnimal.setAnimalid(id);
            animalrepo.save(newAnimal);
            return newAnimal;
        }
        else
        {
            return null;
        }
    }
//     POST /admin/zoos - add the zoo
    @PostMapping("/zoos")
    public Zoo addZoo(@RequestBody Zoo newZoo)
    {
        zoorepo.save(newZoo);
        return newZoo;
    }
//     POST /admin/phones - add the phone number
    @PostMapping("/phones")
    public Telephone addPhone(@RequestBody Telephone newPhone)
    {
        telerepo.save(newPhone);
        return newPhone;
    }
//     POST /admin/animals - add the animal
    @PostMapping("/animals")
    public Animal addAnimal(@RequestBody Animal newAnimal)
    {
        animalrepo.save(newAnimal);
        return newAnimal;
    }
//     POST /admin/zoos/animals - add the zooid, animalid combination to the zoo animals relations table
    // ********* That's a good question

//     DELETE /admin/zoos/{id} - delete the zoo, associated phone numbers, and zoo animals combination associated with this zoo id
//
//     DELETE /admin/phones/{id} - delete the phone number associated with this id
//
//     DELETE /admin/animals/{id} - delete the animal associated with this id including all the appropriate zoo animal combinations
//
//     DELETE /admin/zoos/{zooid}/animals/{animalid} - delete the zoo animal combination based off of ids.
//
//         Hint: @PathVariable("zooid", long zooid), @PathVariable("animalid") long animalid
}
