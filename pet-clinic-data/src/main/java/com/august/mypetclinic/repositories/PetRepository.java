package com.august.mypetclinic.repositories;

import com.august.mypetclinic.model.Pet;
import com.august.mypetclinic.services.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
