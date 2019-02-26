package com.lambdaschool.demo.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "zoo")
public class Zoo
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String zooname;

    @ManyToMany(mappedBy = "zoos")
    @JsonIgnoreProperties("zoos")
    private Set<Animal> animals;

    @OneToMany(mappedBy = "zoo")
    @JsonIgnoreProperties("zoo")
    private Set<Telephone> telephones;

    public Zoo()
    {
    }

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public String getZooname()
    {
        return zooname;
    }

    public void setZooname(String zooname)
    {
        this.zooname = zooname;
    }

    public Set<Animal> getAnimals()
    {
        return animals;
    }

    public void setAnimals(Set<Animal> animals)
    {
        this.animals = animals;
    }

    public Set<Telephone> getTelephones()
    {
        return telephones;
    }

    public void setTelephones(Set<Telephone> telephones)
    {
        this.telephones = telephones;
    }
}
