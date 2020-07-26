package com.august.mypetclinic.services;

import com.august.mypetclinic.model.Vet;

import java.util.Set;

public interface VetService {

    Vet getById(Long id);

    Set<Vet> findAll();

    void save(Vet vet);

}
