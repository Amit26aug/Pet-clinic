package com.august.mypetclinic.services.jpa;

import com.august.mypetclinic.model.Owner;
import com.august.mypetclinic.repositories.OwnerRepository;
import com.august.mypetclinic.services.OwnerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OwnerServiceJpaTest {

    public static final String LAST_NAME_PARKER = "Parker";
    @Mock
    private OwnerRepository ownerRepository;

    @InjectMocks
    private OwnerServiceJpa ownerService;

    private Owner owner;

    @BeforeEach
    void setUp() {
        owner = Owner.builder().id(1L).lastName(LAST_NAME_PARKER).firstName("Peter").build();
    }

    @Test
    void findByLastName() {
        when(ownerRepository.findByLastName(any())).thenReturn(owner);
        Owner owner = ownerService.findByLastName(LAST_NAME_PARKER);
        assertEquals(LAST_NAME_PARKER, owner.getLastName());
    }

    @Test
    void save() {
        Owner ownerToSave = Owner.builder().firstName("Steve").lastName("Rogers").build();
        when(ownerRepository.save(any())).thenReturn(ownerToSave);
        Owner savedOwner = ownerService.save(ownerToSave);
        verify(ownerRepository, times(1)).save(any());
        assertNotNull(savedOwner);
    }

    @Test
    void findById() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.of(owner));
        Owner returnedOwner = ownerService.findById(1L);
        assertNotNull(returnedOwner);
    }

    @Test
    void findAll() {
        Set<Owner> owners = new HashSet<>(Collections.singleton(
                Owner.builder().id(3L).firstName("Tony").lastName("Stark").build()
        ));
        when(ownerRepository.findAll()).thenReturn(owners);
        Set<Owner> resultSet = ownerService.findAll();
        assertEquals(1, resultSet.size());
    }

    @Test
    void deleteById() {
        ownerService.deleteById(1L);
        verify(ownerRepository).deleteById(anyLong());
    }

    @Test
    void delete() {
        ownerService.delete(owner);
        verify(ownerRepository).delete(any());
    }
}