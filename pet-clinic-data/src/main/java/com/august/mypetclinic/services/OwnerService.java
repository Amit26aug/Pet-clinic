package com.august.mypetclinic.services;

import com.august.mypetclinic.model.Owner;

import java.util.Set;

public interface OwnerService {

    Owner findById(Long id);

    void save(Owner owner);

    Owner findByLastName(String lastName);

    Set<Owner> findAll();

}
