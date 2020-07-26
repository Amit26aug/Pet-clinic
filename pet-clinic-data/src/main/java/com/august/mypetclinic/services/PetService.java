package com.august.mypetclinic.services;

import com.august.mypetclinic.model.Pet;

import java.util.Set;

public interface PetService {

    Pet findById(Long id);

    Set<Pet> findAll();

    void save(Pet pet);

}
