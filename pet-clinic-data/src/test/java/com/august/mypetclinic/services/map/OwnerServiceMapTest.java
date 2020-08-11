package com.august.mypetclinic.services.map;

import com.august.mypetclinic.model.Owner;
import com.august.mypetclinic.services.OwnerService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class OwnerServiceMapTest {

    private OwnerService ownerService;
    private final Long id = 1L;

    @BeforeEach
    void setUp() {
        ownerService = new OwnerServiceMap(new PetTypeServiceMap(), new PetServiceMap());
        ownerService.save(Owner.builder().id(id).build());
    }

    @Test
    void findByLastName() {
        String parker = "Parker";
        ownerService.save(Owner.builder().lastName(parker).id(2L).build());
        Owner findByNameOwner = ownerService.findByLastName(parker);
        log.info(String.valueOf(findByNameOwner.getId()));
        assertEquals(findByNameOwner.getId(), 2L);
    }

    @Test
    void findByLastNameNotFound() {
        assertNull(ownerService.findByLastName("none"));
    }

    @Test
    void save() {
        Long id = 2L;
        Owner savedOwner = ownerService.save(Owner.builder().id(id).firstName("Tony").lastName("Stark").build());
        assertEquals(savedOwner.getId(), id);
    }

    @Test
    void findById() {
        assertEquals(id, ownerService.findById(id).getId());
    }

    @Test
    void findAll() {
        assertEquals(1, ownerService.findAll().size());
    }

    @Test
    void deleteById() {
        ownerService.deleteById(id);
        assertEquals(0, ownerService.findAll().size());
    }

    @Test
    void delete() {
        ownerService.delete(ownerService.findById(id));
        assertEquals(0, ownerService.findAll().size());
    }
}