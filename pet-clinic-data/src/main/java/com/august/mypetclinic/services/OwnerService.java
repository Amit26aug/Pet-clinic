package com.august.mypetclinic.services;

import com.august.mypetclinic.model.Owner;

import java.util.Set;

public interface OwnerService extends CrudRepository<Owner, Long> {

    Owner findByLastName(String lastName);

}
