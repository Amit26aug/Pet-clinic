package com.august.mypetclinic.services.map;

import com.august.mypetclinic.model.Owner;
import com.august.mypetclinic.services.OwnerService;
import lombok.extern.slf4j.Slf4j;

import java.util.Set;

@Slf4j
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {
    @Override
    public Owner findByLastName(String lastName) {
        log.info("Not yet implemented!");
        return null;
    }

    @Override
    public Owner save(Owner owner) {
        return super.save(owner.getId(), owner);
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Set<Owner> finAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Owner owner) {
        super.delete(owner);
    }
}
